package com.codestates.server.vote.repository;

import com.codestates.server.member.entity.Member;
import com.codestates.server.question.entity.Question;
import com.codestates.server.vote.entity.QuestionVote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QuestionVoteRepository extends JpaRepository<QuestionVote, Long> {
    Optional<QuestionVote> findByMemberAndQuestion(Member member, Question question);
}
