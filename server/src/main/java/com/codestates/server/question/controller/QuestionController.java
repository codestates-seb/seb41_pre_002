package com.codestates.server.question.controller;

import com.codestates.server.dto.MultiResponseDto;
import com.codestates.server.dto.SingleResponseDto;
import com.codestates.server.question.dto.QuestionPostDto;
import com.codestates.server.question.entity.Question;
import com.codestates.server.question.mapper.QuestionMapper;
import com.codestates.server.question.service.QuestionService;
import com.codestates.server.tag.entity.Tag;
import com.codestates.server.tag.service.TagService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping("/questions")
@Validated
public class QuestionController {
    private QuestionMapper questionMapper;
    private QuestionService questionService;
    private TagService tagService;

    public QuestionController(QuestionMapper questionMapper, QuestionService questionService, TagService tagService) {
        this.questionMapper = questionMapper;
        this.questionService = questionService;
        this.tagService = tagService;
    }

    @PostMapping
    public ResponseEntity postQuestion(@Valid @RequestBody QuestionPostDto questionPostDto) {

        List<Tag> tags = tagService.findTags(questionPostDto.getCategories());
        Question question = questionService.createQuestion(questionMapper.questionPostDtoToQuestion(questionPostDto, tags));

        return new ResponseEntity(
                new SingleResponseDto<>(questionMapper.questionToQuestionSuccessResponseDto(question)),
                HttpStatus.CREATED
        );
    }

    @PatchMapping("/{question-id}")
    public ResponseEntity patchQuestion() {
        //Todo: 질문 수정 - 답변 혹은 댓글이 있으면 수정/삭제 할 수 없음

        return new ResponseEntity<>(
//                new SingleResponseDto<>(questionMapper.questionToQuestionSuccessResponseDto(question)),
                HttpStatus.OK);
    }

    @GetMapping("/{question-id}")
    public ResponseEntity getQuestionDetail(@Positive @PathVariable("question-id") long questionId) {
        /*질문내용
         *   - 질문한 사람의 간략한 정보
         *   - 질문에 대한 댓글들
         *       - 댓글을 작성한 사람의 정보*/


        /*답변내용들
         *   - 질문한 사람의 간략한 정보
         *   - 답변에 대한 댓글들
         *       - 댓글을 작성한 사람의 정보*/

        return new ResponseEntity<>(
                HttpStatus.OK
        );
    }

    @GetMapping
    public ResponseEntity getQuestions(@Positive @RequestParam int page,
                                       @Positive @RequestParam int size) { //Todo: 다양한 정렬 조건들 받을 예정
        Page<Question> pageQuestions = questionService.findQuestions(page - 1, size);

        return new ResponseEntity(
                new MultiResponseDto<>(questionMapper.questionsToQuestionResponseDtos(pageQuestions.getContent()), pageQuestions),
                HttpStatus.OK
        );
    }

}
