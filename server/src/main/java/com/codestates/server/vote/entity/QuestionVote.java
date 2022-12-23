package com.codestates.server.vote.entity;

import com.codestates.server.member.entity.Member;
import com.codestates.server.question.entity.Question;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class QuestionVote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long voteId;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "QUESTION_ID")
    private Question question;

    public QuestionVote(Member member, Question question) {
        this.member = member;
        this.question = question;
    }
}
