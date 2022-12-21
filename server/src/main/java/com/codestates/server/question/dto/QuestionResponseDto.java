package com.codestates.server.question.dto;

import lombok.Getter;

@Getter
public class QuestionResponseDto {
    private Long questionId;
    private String title;
    private String content;
    private Long memberId;
    private String memberName;

    //Todo: 질문을 남긴 시간 ???
}
