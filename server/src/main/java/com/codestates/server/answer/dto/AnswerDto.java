package com.codestates.server.answer.dto;

import com.codestates.server.audit.AuditableResponseDto;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;


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
        private Integer voteCount;
        private AuditableResponseDto auditableResponseDto;
    }
}
