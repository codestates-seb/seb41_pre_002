package com.codestates.server.comment.dto;

import com.codestates.server.audit.AuditableResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AnswerCommentDto {

    @Getter
    @AllArgsConstructor
    public static class Post {
        private Long memberId;
        private Long answerId;
        @NotBlank
        private String content;
    }
    @Getter
    @AllArgsConstructor
    public static class Patch {
        private Long memberId;
        private Long answerId;
        @NotBlank
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
    @Getter
    @AllArgsConstructor
    public static class AnswerIdResponse {
        private Long answerId;
    }
    @Getter
    @AllArgsConstructor
    public static class QuestionIdResponse {
        private Long questionId;
    }
}
