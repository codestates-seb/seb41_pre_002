package com.codestates.server.question.controller;

import com.codestates.server.dto.SingleResponseDto;
import com.codestates.server.question.dto.QuestionPostDto;
import com.codestates.server.question.entity.Question;
import com.codestates.server.question.mapper.QuestionMapper;
import com.codestates.server.question.service.QuestionService;
import com.codestates.server.tag.entity.Tag;
import com.codestates.server.tag.mapper.TagMapper;
import com.codestates.server.tag.service.TagService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
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
                new SingleResponseDto<>(questionMapper.QuestionToQuestionSuccessResponseDto(question)),
                HttpStatus.CREATED
        );
    }

}
