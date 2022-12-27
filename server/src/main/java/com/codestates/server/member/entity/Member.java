package com.codestates.server.member.entity;

import com.codestates.server.answer.entity.Answer;
import com.codestates.server.audit.Auditable;
import com.codestates.server.comment.entity.AnswerComment;
import com.codestates.server.comment.entity.QuestionComment;
import com.codestates.server.question.entity.Question;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;
import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
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

    //멤버 권한 정보 테이블과 매핑
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles = new ArrayList<>();

    public enum MemberRole{
        ROLE_USER,
        ROLE_ADMIN
    }

    @OneToMany(mappedBy = "member")
    private List<Question> questionList = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<QuestionComment> questionComments = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Answer> answerList = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<AnswerComment> answerComments = new ArrayList<>();
}