package com.codestates.server.answer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

public class AnswerDto {

    @Getter
    public static class Post {
        private String content;
    }
    @Getter
    public static class Patch {
        private String content;
    }
    @Getter
    @AllArgsConstructor
    public static class Response {
        private String content;
        private LocalDateTime createdAt;
        private LocalDateTime modifiedAt;
    }
}
