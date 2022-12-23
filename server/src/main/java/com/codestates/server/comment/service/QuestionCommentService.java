package com.codestates.server.comment.service;

import com.codestates.server.comment.entity.QuestionComment;
import com.codestates.server.comment.repository.QuestionCommentRepository;
import com.codestates.server.exception.BusinessLogicException;
import com.codestates.server.exception.ExceptionCode;
import com.codestates.server.question.entity.Question;
import com.codestates.server.question.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Service
@RequiredArgsConstructor
public class QuestionCommentService {
    private final QuestionCommentRepository questionCommentRepository;
    private final QuestionService questionService;


    // 질문에 댓글 달기
    public QuestionComment postQuestionComment(Long questionId, QuestionComment comment) {
        Question question = questionService.findVerifiedQuestion(questionId);// questionservice로 수정하기
        comment.setQuestion(question);
        QuestionComment savedComment = questionCommentRepository.save(comment);
        return savedComment;
    }

    // 댓글 수정
    public QuestionComment updateQuestionComment(Long commentId, QuestionComment comment) {
        QuestionComment findComment = findVerifyComment(commentId);
        Optional.ofNullable(comment.getContent())
                .ifPresent(content -> findComment.setContent(content));
        return questionCommentRepository.save(findComment);
    }

    // 댓글 삭제
    public void deleteComment(Long commentId) {
        QuestionComment verifyComment = findVerifyComment(commentId);
        questionCommentRepository.delete(verifyComment);
    }

    //댓글 존재 확인
    private QuestionComment findVerifyComment(Long commentId) {
        return questionCommentRepository.findById(commentId)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.COMMENT_NOT_FOUND));
    }
}
