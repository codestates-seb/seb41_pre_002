package com.codestates.server.comment.dto;

import com.codestates.server.audit.AuditableResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

public class QuestionCommentDto {

    @Getter
    @AllArgsConstructor
    public static class Post {
        private Long memberId;
        private Long questionId;
        @NotBlank
        private String content;
    }
    @Getter
    @AllArgsConstructor
    public static class Patch {
        private Long memberId;
        private Long questionId;
        @NotBlank
        private String content;
    }
    @Getter
    @AllArgsConstructor
    public static class Response {
        private Long commentId;
        private Long questionId;
        private Long memberId;
        private String memberName;
        private String content;
        private AuditableResponseDto auditableResponseDto;
    }
    @Getter
    @AllArgsConstructor
    public static class QuestionIdResponse {
        private Long questionId;
    }
}
