package com.codestates.server.vote.entity;

import com.codestates.server.answer.entity.Answer;
import com.codestates.server.member.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class AnswerVote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long voteId;

    @Range(min = -1, max = 1, message = "투표는 한번만 할 수 있습니다.")
    private Integer score;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "ANSWER_ID")
    private Answer answer;

    public AnswerVote(Integer score, Member member, Answer answer) {
        this.score = score;
        this.member = member;
        this.answer = answer;
    }

    public void calculateScore(int score) {
        this.score += score;
    }
}