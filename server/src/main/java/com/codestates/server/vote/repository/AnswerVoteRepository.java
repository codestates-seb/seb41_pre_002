package com.codestates.server.vote.repository;

import com.codestates.server.vote.entity.AnswerVote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerVoteRepository extends JpaRepository<AnswerVote, Long> {

}
