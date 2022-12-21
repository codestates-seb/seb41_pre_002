package com.codestates.server.answer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public class AnswerDto {

    @Getter
    public static class Post {
        @NotBlank
        private String content;
    }
    @Getter
    public static class Patch {
        @NotBlank
        private String content;
    }
    @Getter
    @AllArgsConstructor
    public static class Response {
        private String memberName;
        private String content;
        private LocalDateTime createdAt;
        private LocalDateTime modifiedAt;
    }
}
