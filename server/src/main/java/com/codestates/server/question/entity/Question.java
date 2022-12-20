package com.codestates.server.question.entity;

import com.codestates.server.audit.Auditable;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Question extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;

    @Column(nullable = false, length = 150)
    private String title;

    @Column(nullable = false)
    private String content;

    @OneToMany(mappedBy = "question", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<QuestionTag> questionTags = new ArrayList<>();

//Todo:    private Member member; // 다대일 연관관계 매핑 예

//Todo:    private List<Answer> answers = new ArrayList<>(); // 일대다 연관관계 매핑 예정

    // 연관 관계 매핑 관련 메서드
    public void addQuestionTag(QuestionTag questionTag) {
        this.questionTags.add(questionTag);
        if (questionTag.getQuestion() != this) {
            questionTag.setQuestion(this);
        }
    }
}
