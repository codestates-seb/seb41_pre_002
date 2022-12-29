package com.codestates.server.comment.entity;

import com.codestates.server.audit.Auditable;
import com.codestates.server.member.entity.Member;
import com.codestates.server.question.entity.Question;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class QuestionComment extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;


    /**
     * 연관 관계 편의 메서드
     */
    public void setMember(Member member) {
        this.member = member;
        member.getQuestionComments().add(this);
    }
    public void setQuestion(Question question) {
        this.question = question;
         question.getComments().add(this);
    }
}
