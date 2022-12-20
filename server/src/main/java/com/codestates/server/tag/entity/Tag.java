package com.codestates.server.tag.entity;

import com.codestates.server.question.entity.QuestionTag;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tagId;

    /* 동일한 태그가 존재하면 안되기 때문에 유니크 추가함
     * 길이 지정은 스택오버플로우 최대입력가능 수 기준 */
    @Column(nullable = false, unique = true, length = 35)
    private String category;

    @OneToMany(mappedBy = "tag")
    private List<QuestionTag> questionTags = new ArrayList<>();

    // 연관 관계 매핑 관련 메서드

    public void addQuestionTag(QuestionTag questionTag) {
        this.questionTags.add(questionTag);
        if (questionTag.getTag() != this) {
            questionTag.setTag(this);
        }
    }
}
