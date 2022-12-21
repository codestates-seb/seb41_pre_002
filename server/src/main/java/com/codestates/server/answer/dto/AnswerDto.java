package com.codestates.server.answer.dto;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public class AnswerDto {
    @Getter
    public static class Post {
        private Long memberId;
        private Long questionId;
        private String memberName;
        @NotBlank
        private String content;
    }
    @Getter
    public static class Patch {
        private Long memberId;
        private Long questionId;
        private String memberName;
        @NotBlank
        private String content;
    }
    @Getter
    @Builder
    public static class Response {
        private Long memberId;
        private Long questionId;
        private String memberName;
        private String content;
        private LocalDateTime createdAt;
        private LocalDateTime modifiedAt;
    }
}
