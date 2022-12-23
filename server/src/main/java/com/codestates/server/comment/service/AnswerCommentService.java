package com.codestates.server.comment.service;

import com.codestates.server.answer.entity.Answer;
import com.codestates.server.answer.service.AnswerService;
import com.codestates.server.comment.entity.AnswerComment;
import com.codestates.server.comment.repository.AnswerCommentRepository;
import com.codestates.server.exception.BusinessLogicException;
import com.codestates.server.exception.ExceptionCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Service
@RequiredArgsConstructor
public class AnswerCommentService {
    private final AnswerCommentRepository answerCommentRepository;
    private final AnswerService answerService;

    // 답글에 댓글 달기
    public AnswerComment postAnswerComment(Long answerId, AnswerComment answerComment) {
        Answer answer = answerService.verifyAnswer(answerId);

        answerComment.setAnswer(answer);

        AnswerComment savedComment = answerCommentRepository.save(answerComment);
        return savedComment;
    }
    // 댓글 수정
    public AnswerComment updateAnswerComment(Long commentId, AnswerComment answerComment) {
        AnswerComment findComment = findVerifyAnswerComment(commentId);
        Optional.ofNullable(answerComment.getContent())
                        .ifPresent(content -> findComment.setContent(content) );
        return answerCommentRepository.save(findComment);
    }

    // 댓글 삭제
    public void deleteComment(Long commentId) {
        AnswerComment verifyComment = findVerifyAnswerComment(commentId);
        answerCommentRepository.delete(verifyComment);
    }
    //댓글 존재 확인
    private AnswerComment findVerifyAnswerComment(Long commentId) {
        return answerCommentRepository.findById(commentId)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.COMMENT_NOT_FOUND));
    }
}
