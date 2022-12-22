package com.codestates.server.comment.controller;

import com.codestates.server.answer.repository.AnswerRepository;
import com.codestates.server.comment.dto.CommentDto;
import com.codestates.server.comment.entity.Comment;
import com.codestates.server.comment.mapper.CommentMapper;
import com.codestates.server.comment.service.CommentService;
import com.codestates.server.dto.SingleResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;
    private final CommentMapper mapper;
    private final AnswerRepository answerRepository;

    @PostMapping("/questions/{question-id}/comments")
    public ResponseEntity postQuestionComment(@PathVariable("question-id") Long questionId,
                                       @Valid @RequestBody CommentDto.Post requestBody) {

        Comment comment = mapper.commentPostDtoToComment(requestBody);
        Comment response = commentService.postQuestionComment(questionId, comment);
        return new ResponseEntity<>(new SingleResponseDto<>(mapper.commentToCommentResponseDto(response)), HttpStatus.CREATED);
    }

    @PostMapping("/answers/{answer-id}/comments")
    public ResponseEntity postAnswerComment(@PathVariable("answer-id") Long answerId,
                                       @Valid @RequestBody CommentDto.Post requestBody) {

        Comment comment = mapper.commentPostDtoToComment(requestBody);
        Comment response = commentService.postAnswerComment(answerId, comment);
        return new ResponseEntity<>(new SingleResponseDto<>(mapper.commentToCommentResponseDto(response)), HttpStatus.CREATED);

    }
    @PatchMapping("/comments/{comment-id}")
    public ResponseEntity patchComment(@PathVariable("comment-id") Long commentId,
                                       @RequestBody CommentDto.Patch requestBody,
                                       HttpServletRequest request) {

        Comment comment = mapper.commentPatchDtoToComment(requestBody);
        Comment response = commentService.updateComment(commentId, comment);
        return new ResponseEntity<>(new SingleResponseDto<>(mapper.commentToCommentResponseDto(response)), HttpStatus.OK);
    }
    @DeleteMapping("/comments/{comment-id}")
    public ResponseEntity deleteComment(@PathVariable("comment-id") Long commentId,
                                        HttpServletRequest request) {

        commentService.deleteComment(commentId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

