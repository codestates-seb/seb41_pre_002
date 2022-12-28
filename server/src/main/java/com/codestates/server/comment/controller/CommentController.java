package com.codestates.server.comment.controller;

import com.codestates.server.comment.dto.AnswerCommentDto;
import com.codestates.server.comment.dto.QuestionCommentDto;
import com.codestates.server.comment.entity.AnswerComment;
import com.codestates.server.comment.entity.QuestionComment;
import com.codestates.server.comment.mapper.AnswerCommentMapper;
import com.codestates.server.comment.mapper.QuestionCommentMapper;
import com.codestates.server.comment.service.AnswerCommentService;
import com.codestates.server.comment.service.QuestionCommentService;
import com.codestates.server.dto.SingleResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class CommentController {

    private final QuestionCommentService questionCommentService;
    private final AnswerCommentService answerCommentService;
    private final AnswerCommentMapper answerCommentMapper;
    private final QuestionCommentMapper questionCommentMapper;

    // AnswerComment
    @PostMapping("/answers/{answer-id}/comments")
    public ResponseEntity postAnswerComment(@PathVariable("answer-id") Long answerId,
                                            @Valid @RequestBody AnswerCommentDto.Post requestBody) {

        AnswerComment answerComment = answerCommentMapper.answerCommentPostDtoToComment(requestBody);
        AnswerComment response = answerCommentService.postAnswerComment(answerId, answerComment);
        return new ResponseEntity<>(new SingleResponseDto<>(answerCommentMapper.answerCommentToAnswerIdResponseDto(response)),HttpStatus.CREATED);

    }

    @PatchMapping("/answers/{answer-id}/comments/{comment-id}")
    public ResponseEntity patchAnswerComment(@PathVariable("answer-id") Long answerId,
                                             @PathVariable("comment-id") Long commentId,
                                             @RequestBody AnswerCommentDto.Patch requestBody) {

        AnswerComment comment = answerCommentMapper.commentPatchDtoToComment(requestBody);
        AnswerComment response = answerCommentService.updateAnswerComment(commentId, comment);
        return new ResponseEntity<>(new SingleResponseDto<>(answerCommentMapper.answerCommentToAnswerIdResponseDto(response)),HttpStatus.OK);
    }

    @DeleteMapping("/answers/{answer-id}/comments/{comment-id}")
    public ResponseEntity deleteAnswerComment(@PathVariable("comment-id") Long commentId) {
        Long questionId = answerCommentService.deleteComment(commentId);
        return new ResponseEntity<>(new SingleResponseDto<>(new AnswerCommentDto.QuestionIdResponse(questionId)),HttpStatus.OK);
    }

    // QuestionComment
    @PostMapping("/questions/{question-id}/comments")
    public ResponseEntity postQuestionComment(@PathVariable("question-id") Long questionId,
                                              @Valid @RequestBody QuestionCommentDto.Post requestBody) {

        QuestionComment comment = questionCommentMapper.questionCommentPostDtoToQuestionComment(requestBody);
        QuestionComment response = questionCommentService.postQuestionComment(questionId, comment);
        return new ResponseEntity<>(new SingleResponseDto<>(questionCommentMapper.questionCommentToQuestionIdResponseDto(response)),HttpStatus.CREATED);
    }

    @PatchMapping("/questions/{question-id}/comments/{comment-id}")
    public ResponseEntity patchQuestionComment(@PathVariable("question-id") Long questionId,
                                               @PathVariable("comment-id") Long commentId,
                                               @RequestBody QuestionCommentDto.Patch requestBody) {

        QuestionComment comment = questionCommentMapper.questionCommentPatchDtoToQuestionComment(requestBody);
        QuestionComment response = questionCommentService.updateQuestionComment(commentId, comment);
        return new ResponseEntity<>(new SingleResponseDto<>(questionCommentMapper.questionCommentToQuestionIdResponseDto(response)),HttpStatus.OK);
    }

    @DeleteMapping("/questions/{question-id}/comments/{comment-id}")
    public ResponseEntity deleteQuestionComment(@PathVariable("question-id")Long questionId,
                                                @PathVariable("comment-id") Long commentId) {

        questionCommentService.deleteComment(commentId);

        return new ResponseEntity<>(new SingleResponseDto<>(new QuestionCommentDto.QuestionIdResponse(questionId)),HttpStatus.OK);
    }
}

