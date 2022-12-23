package com.codestates.server.answer.dto;

import com.codestates.server.audit.AuditableResponseDto;
import com.codestates.server.comment.dto.CommentDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import java.util.List;

@AllArgsConstructor // tset 를 위해 추가.
public class AnswerDto {
    @Getter
    public static class Post {
        private Long memberId;
        private Long questionId;
        @NotBlank
        private String content;
    }
    @Getter
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
        private List<CommentDto.Response> commentResponseDtos;
    }
}
