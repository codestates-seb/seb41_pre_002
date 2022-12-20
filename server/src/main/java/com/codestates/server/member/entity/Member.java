package com.codestates.server.member.entity;

import com.codestates.server.answer.entity.Answer;
import com.codestates.server.audit.Auditable;
import com.codestates.server.question.entity.Question;
import lombok.Getter;
import lombok.Setter;

import java.util.*;
import javax.persistence.*;

@Entity
@Getter
@Setter
public class Member extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String memberName;

    @Column(nullable = false)
    private String memberPassword;

    @OneToMany
    private List<Question> questionList = new ArrayList<>();

    @OneToMany
    private List<Answer> answerList = new ArrayList<>();

    //Todo: comment 매핑 추가
}