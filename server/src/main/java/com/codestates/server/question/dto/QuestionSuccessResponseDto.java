package com.codestates.server.question.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
public class QuestionSuccessResponseDto {
    @Setter
    private Long questionId;

    private String message = "요청이 성공적으로 처리되었습니다";

}
