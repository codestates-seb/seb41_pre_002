package com.codestates.server.question.repository;

import com.codestates.server.question.entity.Question;
import com.codestates.server.question.entity.QuestionTag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionTagRepository extends JpaRepository<QuestionTag, Long> {
    List<QuestionTag> findAllByQuestion(Question question);
}