package com.codestates.server.answer.repository;

import com.codestates.server.answer.entity.Answer;
import com.codestates.server.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AnswerRepository extends JpaRepository<Answer,Long> {
}
