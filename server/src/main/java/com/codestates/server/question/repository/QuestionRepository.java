package com.codestates.server.question.repository;

import com.codestates.server.question.entity.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    Page<Question> findAllByTitleContainsOrContentContains(String title, String content, Pageable pageable);

    Page<Question> findAllByAnswerCountIs(Integer answerCount, Pageable pageable);

    Page<Question> findAllByAnswerCountGreaterThan(Integer answerCount, Pageable pageable); // 질문이 존재하는 경우

    Page<Question> findAllByAnswerCountIsAndTitleContainsOrContentContains(Integer answerCount, String title, String content, Pageable pageable);

    Page<Question> findAllByAnswerCountGreaterThanAndTitleContainsOrContentContains(Integer answerCount, String title, String content, Pageable pageable);

    @Query("select q from Question q join fetch q.member where q.questionId= :id")
    Optional<Question> findByQuestionId(@Param("id") Long questionId);
}
