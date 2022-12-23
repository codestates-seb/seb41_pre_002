package com.codestates.server.vote.dto;

import lombok.Getter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Positive;

@Getter
public class VoteRequestDto {
    @Positive
    private Long memberId;

    @Range(min = -1, max = 1)
    private Integer score;

}
