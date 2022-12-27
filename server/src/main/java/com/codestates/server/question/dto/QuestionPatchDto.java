package com.codestates.server.question.dto;

import com.codestates.server.member.entity.Member;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.util.List;

@Getter
@Setter // 테스트를 위해 추가
public class QuestionPatchDto {
    @Positive
    private long questionId;

    @Positive
    private long memberId;

    @NotBlank
    @Length(max = 150) // 영문 기준 최대 150자
    private String title;

    @NotBlank
    private String content;

    private List<String> categories;

    public Member getMember() {
        Member member = new Member();
        member.setMemberId(this.memberId);
        return member;
    }
}
