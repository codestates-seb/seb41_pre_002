package com.codestates.server.answer.entity;

import com.codestates.server.audit.Auditable;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
public class AnswerComment extends Auditable {
    @Id
    @GeneratedValue
    private Long answerCommentId;
    private String comment;


}
