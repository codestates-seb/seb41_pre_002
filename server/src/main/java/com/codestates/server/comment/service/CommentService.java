package com.codestates.server.comment.service;

import com.codestates.server.answer.entity.Answer;
import com.codestates.server.answer.service.AnswerService;
import com.codestates.server.comment.entity.Comment;
import com.codestates.server.comment.repository.CommentRepository;
import com.codestates.server.exception.BusinessLogicException;
import com.codestates.server.exception.ExceptionCode;
import com.codestates.server.question.entity.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final AnswerService answerService;


    // 질문에 댓글 달기
    public Comment postQuestionComment(Long questionId,Comment comment) {
        Question question = answerService.verifyQuestion(questionId);// questionservice로 수정하기
        comment.setQuestion(question);
        Comment savedComment = commentRepository.save(comment);
        return savedComment;
    }

    // 답글에 댓글 달기
    public Comment postAnswerComment(Long answerId,Comment comment) {
        Answer answer = answerService.verifyAnswer(answerId);
        Question question = answerService.verifyQuestion(answer.getQuestion().getQuestionId());

        comment.setAnswer(answer);
        comment.setQuestion(question);
        
        Comment savedComment = commentRepository.save(comment);
        return savedComment;
    }
    // 댓글 수정
    public Comment updateComment(Long commentId, Comment comment) {
        Comment findComment = findVerifyComment(commentId);
        Optional.ofNullable(comment.getContent())
                        .ifPresent(content -> findComment.setContent(content) );
        return commentRepository.save(findComment);
    }

    // 댓글 삭제
    public void deleteComment(Long commentId) {
        Comment verifyComment = findVerifyComment(commentId);
        commentRepository.delete(verifyComment);
    }
    //댓글 존재 확인
    private Comment findVerifyComment(Long commentId) {
        return commentRepository.findById(commentId)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.COMMENT_NOT_FOUND));
    }
}
