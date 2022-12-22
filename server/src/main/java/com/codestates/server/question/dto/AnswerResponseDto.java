package com.codestates.server.question.dto;

import com.codestates.server.audit.AuditableResponseDto;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class AnswerResponseDto {
    private Long answerId;
    private String content;
    private AuditableResponseDto auditableResponseDto;
    private Integer voteCount;
    private Long memberId;
    private String memberName;
    private List<CommentResponseDto> commentResponseDtos;
}
//Todo: 리펙터링할 때 중복사항 감싸기