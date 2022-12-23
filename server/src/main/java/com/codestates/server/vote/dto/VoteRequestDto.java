package com.codestates.server.vote.dto;

import lombok.Getter;

import javax.validation.constraints.Positive;

@Getter
public class VoteRequestDto {
    @Positive
    private Long memberId;
}
