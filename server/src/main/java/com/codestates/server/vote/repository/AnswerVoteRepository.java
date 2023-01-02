package com.codestates.server.vote.repository;

import com.codestates.server.answer.entity.Answer;
import com.codestates.server.member.entity.Member;
import com.codestates.server.vote.entity.AnswerVote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AnswerVoteRepository extends JpaRepository<AnswerVote, Long> {
    Optional<AnswerVote> findByMemberAndAnswer(Member member, Answer answer);
}
