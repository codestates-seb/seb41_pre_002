package com.codestates.server.answer.dto;

import com.codestates.server.audit.AuditableResponseDto;
import com.codestates.server.comment.dto.AnswerCommentDto;
import com.codestates.server.comment.dto.QuestionCommentDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class AnswerDto {
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
    @Builder
    public static class Response {
        private Long answerId;
        private Long memberId;
        private Long questionId;
        private String memberName;
        private String content;
        private Integer voteCount;
        private AuditableResponseDto auditableResponseDto;
        private List<AnswerCommentDto.Response> commentResponseDtos;
    }
    @Getter
    @AllArgsConstructor
    public static class QuestionIdResponse {
        private Long questionId;
    }
}
