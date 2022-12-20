package com.codestates.server.question.entity;

import com.codestates.server.tag.entity.Tag;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class QuestionTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionTagId;

    @ManyToOne
    @JoinColumn(name = "QUESTION_ID")
    private Question question;

    @ManyToOne
    @JoinColumn(name = "TAG_ID")
    private Tag tag;

    // 연관 관계 매핑 관련 메서드
    public void addQuestion(Question question) {
        this.question = question;
        if (!this.question.getQuestionTags().contains(this)) {
            this.question.getQuestionTags().add(this);
        }
    }

    public void addTag(Tag tag) {
        this.tag = tag;
        if (!this.tag.getQuestionTags().contains(this)) {
            this.tag.getQuestionTags().add(this);
        }
    }

}
