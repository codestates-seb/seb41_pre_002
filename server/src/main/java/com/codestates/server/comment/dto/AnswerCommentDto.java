package com.codestates.server.comment.dto;

import com.codestates.server.audit.AuditableResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class AnswerCommentDto {

    @Getter
    public static class Post {
        private Long memberId;
        private Long answerId;
        private String content;
    }
    @Getter
    public static class Patch {
        private Long memberId;
        private Long answerId;
        private String content;
    }
    @Getter
    @AllArgsConstructor
    public static class Response {
        private Long commentId;
        private Long answerId;
        private Long memberId;
        private String memberName;
        private String content;
        private AuditableResponseDto auditableResponseDto;
    }
}
