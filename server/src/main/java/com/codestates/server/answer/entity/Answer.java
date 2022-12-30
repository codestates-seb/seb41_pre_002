package com.codestates.server.answer.entity;

import com.codestates.server.audit.Auditable;
import com.codestates.server.comment.entity.AnswerComment;
import com.codestates.server.member.entity.Member;
import com.codestates.server.question.entity.Question;
import com.codestates.server.vote.entity.AnswerVote;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Answer extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long answerId;

    @Column(nullable = false)
    private String content;

    @OneToMany(mappedBy = "answer")
    private List<AnswerComment> answerComments;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @OneToMany(mappedBy = "answer")
    private List<AnswerVote> answerVotes = new ArrayList<>();

    /**
     * 연관관계 편의 메서드
     */
    public void setMember(Member member) {
        this.member = member;
        member.getAnswerList().add(this);
    }
    public void setQuestion(Question question) {
        this.question = question;
        question.getAnswers().add(this);
    }
    public void addComment(AnswerComment answerComment) {
        this.answerComments.add(answerComment);
    }
}

