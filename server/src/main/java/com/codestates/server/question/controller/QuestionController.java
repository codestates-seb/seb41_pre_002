package com.codestates.server.question.controller;

import com.codestates.server.answer.mapper.AnswerMapper;
import com.codestates.server.comment.mapper.AnswerCommentMapper;
import com.codestates.server.comment.mapper.QuestionCommentMapper;
import com.codestates.server.dto.MultiResponseDto;
import com.codestates.server.dto.SingleResponseDto;
import com.codestates.server.question.dto.QuestionPatchDto;
import com.codestates.server.question.dto.QuestionPostDto;
import com.codestates.server.question.entity.Question;
import com.codestates.server.question.mapper.QuestionMapper;
import com.codestates.server.question.service.QuestionService;
import com.codestates.server.tag.entity.Tag;
import com.codestates.server.tag.service.TagService;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionMapper questionMapper;
    private final AnswerMapper answerMapper;
    private final AnswerCommentMapper answerCommentMapper;
    private final QuestionService questionService;
    private final TagService tagService;

    private final QuestionCommentMapper questionCommentMapper;

    @PostMapping
    public ResponseEntity postQuestion(@Valid @RequestBody QuestionPostDto questionPostDto) {
        /**Insert Into MEMBER
         values (1,NOW(),NOW(),'test@test.com','테스트','1234') 멤버 생성 쿼리*/

        /**Insert Into ANSWER
         values (1,NOW(),NOW(),'답변입니다',1,2) 답변 생성 쿼리*/

        List<Tag> tags = tagService.findTagsElseCreateTags(questionPostDto.getCategories());
        Question question = questionService.createQuestion(questionMapper.questionPostDtoToQuestion(questionPostDto, tags));
        tags.stream()
                .forEach(tag -> tagService.updateQuestionsCount(tag));

        return new ResponseEntity(
                new SingleResponseDto<>(questionMapper.questionToQuestionSuccessResponseDto(question)),
                HttpStatus.CREATED
        );
    }

    @PatchMapping("/{question-id}")
    public ResponseEntity patchQuestion(@Positive @PathVariable("question-id") long questionId,
                                        @Valid @RequestBody QuestionPatchDto questionPatchDto) {
        // 답변 혹은 댓글이 있으면 수정/삭제 할 수 없음
        questionPatchDto.setQuestionId(questionId);

        Question question = questionService.updateQuestion(questionMapper.questionPatchDtoToQuestion(questionPatchDto));
        tagService.updateQuestionTags(question, questionPatchDto.getCategories());

        return new ResponseEntity<>(
                new SingleResponseDto<>(questionMapper.questionToQuestionSuccessResponseDto(question)),
                HttpStatus.OK);
    }

    @GetMapping("/{question-id}")
    public ResponseEntity getQuestionDetail(@Positive @PathVariable("question-id") long questionId) {
        /** 질문 상세페이지에 포함되어야 할 내용
         *질문내용
         *   - 질문한 사람의 간략한 정보
         *   - 질문에 대한 댓글들
         *       - 댓글을 작성한 사람의 정보
         *답변내용들
         *   - 질문한 사람의 간략한 정보
         *   - 답변에 대한 댓글들
         *       - 댓글을 작성한 사람의 정보*/

        Question question = questionService.findQuestion(questionId);

        return new ResponseEntity<>(
                new SingleResponseDto<>(questionMapper.questionToQuestionDetailResponseDto(question, answerMapper, answerCommentMapper, questionCommentMapper)),
                HttpStatus.OK
        );
    }

    @GetMapping
    public ResponseEntity getQuestions(@Positive @RequestParam(required = false, defaultValue = "1") int page,
                                       @Positive @RequestParam(required = false, defaultValue = "10") int size,
                                       @RequestParam(required = false, defaultValue = "") String keyword,
                                       @RequestParam(required = false, defaultValue = "all") String filter,
                                       @RequestParam(required = false, defaultValue = "questionId") String sortedBy,
                                       @RequestParam(required = false, defaultValue = "descending") String order) {

        /**
         * page
         * size
         * keyword - 검색어
         * filter - 모두(기본값=all), 답변없음(noAnswer), 답변있음(answer)
         * sortedBy - questionId(기본값), 추천순, 답변많은순 (규격 외에 questionId로 정렬됨)
         * order - 내림차순(기본값) = descending, 오름차순 = ascending (규격 외에 오름차순 정렬됨)
         * */

        Page<Question> pageQuestions = questionService.findQuestions(page - 1, size, keyword, filter, sortedBy, order);

        return new ResponseEntity(
                new MultiResponseDto<>(questionMapper.questionsToQuestionResponseDtos(pageQuestions.getContent(), questionCommentMapper), pageQuestions),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{question-id}")
    public ResponseEntity deleteQuestion(@Positive @PathVariable("question-id") long questionId) {
        // 답변 혹은 댓글이 있으면 수정/삭제 할 수 없음
        questionService.deleteQuestion(questionId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
