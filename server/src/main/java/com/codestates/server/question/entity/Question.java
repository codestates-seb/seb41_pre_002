package com.codestates.server.question.entity;

import com.codestates.server.answer.entity.Answer;
import com.codestates.server.audit.Auditable;
import com.codestates.server.comment.entity.QuestionComment;
import com.codestates.server.member.entity.Member;
import com.codestates.server.vote.entity.QuestionVote;
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

    private Integer answerCount = 0;

    private Integer voteCount = 0;

    @OneToMany(mappedBy = "question", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<QuestionTag> questionTags = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @OneToMany(mappedBy = "question")
    private List<Answer> answers = new ArrayList<>(); // 일대다 연관관계 매핑 예정

    // Todo: 일대다 연관관계 매핑 예정
    @OneToMany(mappedBy = "question")
    private List<QuestionComment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "question")
    private List<QuestionVote> questionVotes = new ArrayList<>();

    // 연관 관계 매핑 관련 메서드
    public void addQuestionTag(QuestionTag questionTag) {
        this.questionTags.add(questionTag);
        if (questionTag.getQuestion() != this) {
            questionTag.setQuestion(this);
        }
    }

    public void calAnswerCount() {
        this.answerCount = this.answers.size();
    }

    public void calVoteCount() {
        this.voteCount = this.questionVotes.stream()
                .map(questionVote -> questionVote.getScore())
                .reduce(0, (x, y) -> x + y);
    }
}
