package com.codestates.server.vote.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Positive;

@Getter
@Setter // 테스트를 위해 추가
public class VoteRequestDto {
    @Positive
    private Long memberId;

    @Range(min = -1, max = 1)
    private Integer score;

}
