package com.codestates.server.comment.entity;

import com.codestates.server.answer.entity.Answer;
import com.codestates.server.audit.Auditable;
import com.codestates.server.member.entity.Member;
import com.codestates.server.question.entity.Question;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Comment extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @Column(nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "answer_id")
    private Answer answer;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;


    /**
     * 연관 관계 편의 메서드
     */
    public void setAnswer(Answer answer){
        this.answer = answer;
        answer.addComment(this);
    }
    public void setMember(Member member) {
        this.member = member;
       // member.addComment(this);
    }
    public void setQuestion(Question question) {
        this.question = question;
       //  question.addComment(this);
    }
}
