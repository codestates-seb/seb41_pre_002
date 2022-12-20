package com.codestates.server.answer.entity;

import com.codestates.server.audit.Auditable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@NoArgsConstructor
public class Answer extends Auditable {


    @Id
    @GeneratedValue
    private Long answerId;
    private String content;

    @OneToMany
    private List<AnswerComment> comments;

}
