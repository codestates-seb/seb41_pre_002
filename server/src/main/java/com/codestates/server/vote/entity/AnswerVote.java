package com.codestates.server.vote.entity;

import com.codestates.server.answer.entity.Answer;
import com.codestates.server.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class AnswerVote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long voteId;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "ANSWER_ID")
    private Answer answer;

    public AnswerVote(Member member, Answer answer) {
        this.member = member;
        this.answer = answer;
    }
}