package com.codestates.server.comment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

public class CommentDto {

    @Getter
    public static class Post {
        private String content;
    }
    @Getter
    public static class Patch {
        private String comment;
    }
    @Getter
    @AllArgsConstructor
    public static class Response {
        private String comment;
        private LocalDateTime createdAt;
        private LocalDateTime modifiedAt;
    }
}
