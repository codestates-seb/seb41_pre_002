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
import com.codestates.server.exception.BusinessLogicException;
import com.codestates.server.exception.ExceptionCode;
import com.codestates.server.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping
@RequiredArgsConstructor
@Validated
public class CommentController {

    private final QuestionCommentService questionCommentService;
    private final AnswerCommentService answerCommentService;
    private final AnswerCommentMapper answerCommentMapper;
    private final QuestionCommentMapper questionCommentMapper;
    private final MemberService memberService;

    // AnswerComment
    @PostMapping("/answers/{answer-id}/comments")
    public ResponseEntity postAnswerComment(@PathVariable("answer-id") Long answerId,
                                            @Valid @RequestBody AnswerCommentDto.Post requestBody) {

        // 헤더에 담겨서 넘어온 JWT토큰을 해독하여 email 정보를 가져온다
        String jwtEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        if(memberService.findMemberByEmail(jwtEmail).getMemberId() != requestBody.getMemberId()){
            throw new BusinessLogicException(ExceptionCode.REQUEST_FORBIDDEN);

        }

        AnswerComment answerComment = answerCommentMapper.answerCommentPostDtoToComment(requestBody);
        AnswerComment response = answerCommentService.postAnswerComment(answerId, answerComment);
        return new ResponseEntity<>(new SingleResponseDto<>(answerCommentMapper.answerCommentToAnswerIdResponseDto(response)),HttpStatus.CREATED);

    }

    @PatchMapping("/answers/{answer-id}/comments/{comment-id}")
    public ResponseEntity patchAnswerComment(@PathVariable("answer-id") Long answerId,
                                             @PathVariable("comment-id") Long commentId,
                                             @RequestBody AnswerCommentDto.Patch requestBody) {

        // 헤더에 담겨서 넘어온 JWT토큰을 해독하여 email 정보를 가져온다
        String jwtEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        if(memberService.findMemberByEmail(jwtEmail).getMemberId() != requestBody.getMemberId()){
            throw new BusinessLogicException(ExceptionCode.REQUEST_FORBIDDEN);

        }

        AnswerComment comment = answerCommentMapper.commentPatchDtoToComment(requestBody);
        AnswerComment response = answerCommentService.updateAnswerComment(commentId, comment);
        return new ResponseEntity<>(new SingleResponseDto<>(answerCommentMapper.answerCommentToAnswerIdResponseDto(response)),HttpStatus.OK);
    }

    @DeleteMapping("/answers/{answer-id}/comments/{comment-id}")
    public ResponseEntity deleteAnswerComment(@PathVariable("comment-id") Long commentId) {
        // 헤더에 담겨서 넘어온 JWT토큰을 해독하여 email 정보를 가져온다
        String jwtEmail = SecurityContextHolder.getContext().getAuthentication().getName();

        Long questionId = answerCommentService.deleteComment(commentId,jwtEmail);
        return new ResponseEntity<>(new SingleResponseDto<>(new AnswerCommentDto.QuestionIdResponse(questionId)),HttpStatus.OK);
    }

    // QuestionComment
    @PostMapping("/questions/{question-id}/comments")
    public ResponseEntity postQuestionComment(@PathVariable("question-id") Long questionId,
                                              @Valid @RequestBody QuestionCommentDto.Post requestBody) {

        // 헤더에 담겨서 넘어온 JWT토큰을 해독하여 email 정보를 가져온다
        String jwtEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        if(memberService.findMemberByEmail(jwtEmail).getMemberId() != requestBody.getMemberId()){
            throw new BusinessLogicException(ExceptionCode.REQUEST_FORBIDDEN);

        }

        QuestionComment comment = questionCommentMapper.questionCommentPostDtoToQuestionComment(requestBody);
        QuestionComment response = questionCommentService.postQuestionComment(questionId, comment);
        return new ResponseEntity<>(new SingleResponseDto<>(questionCommentMapper.questionCommentToQuestionIdResponseDto(response)),HttpStatus.CREATED);
    }

    @PatchMapping("/questions/{question-id}/comments/{comment-id}")
    public ResponseEntity patchQuestionComment(@PathVariable("question-id") Long questionId,
                                               @PathVariable("comment-id") Long commentId,
                                               @RequestBody QuestionCommentDto.Patch requestBody) {

        // 헤더에 담겨서 넘어온 JWT토큰을 해독하여 email 정보를 가져온다
        String jwtEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        if(memberService.findMemberByEmail(jwtEmail).getMemberId() != requestBody.getMemberId()){
            throw new BusinessLogicException(ExceptionCode.REQUEST_FORBIDDEN);

        }

        QuestionComment comment = questionCommentMapper.questionCommentPatchDtoToQuestionComment(requestBody);
        QuestionComment response = questionCommentService.updateQuestionComment(commentId, comment);
        return new ResponseEntity<>(new SingleResponseDto<>(questionCommentMapper.questionCommentToQuestionIdResponseDto(response)),HttpStatus.OK);
    }

    @DeleteMapping("/questions/{question-id}/comments/{comment-id}")
    public ResponseEntity deleteQuestionComment(@PathVariable("question-id")Long questionId,
                                                @PathVariable("comment-id") Long commentId) {
        // 헤더에 담겨서 넘어온 JWT토큰을 해독하여 email 정보를 가져온다
        String jwtEmail = SecurityContextHolder.getContext().getAuthentication().getName();

        questionCommentService.deleteComment(commentId,jwtEmail);

        return new ResponseEntity<>(new SingleResponseDto<>(new QuestionCommentDto.QuestionIdResponse(questionId)),HttpStatus.OK);
    }
}

