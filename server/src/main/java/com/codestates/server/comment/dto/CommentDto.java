package com.codestates.server.comment.dto;

import com.codestates.server.audit.AuditableResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

public class CommentDto {

    @Getter
    public static class Post {
        private Long memberId;
        private Long questionId;
        private Long answerId;
        private String content;
    }
    @Getter
    public static class Patch {
        private Long memberId;
        private Long questionId;
        private Long answerId;
        private String content;
    }
    @Getter
    @AllArgsConstructor
    public static class Response {
        private Long questionId;
        private Long answerId;
        private Long memberId;
        private String content;
        private AuditableResponseDto auditableResponseDto;
        /*private LocalDateTime createdAt;
        private LocalDateTime modifiedAt;*/
    }
}
