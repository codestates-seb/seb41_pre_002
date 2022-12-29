package com.codestates.server.question.repository;

import com.codestates.server.question.entity.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    Page<Question> findAllByTitleContainsOrContentContains(String title, String content, Pageable pageable);

    @Query("select q from Question q join fetch q.member join fetch q.answers a")
    Optional<Question> findByQuestionId(Long questionId);
}
