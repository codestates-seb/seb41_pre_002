package com.codestates.server.question.dto;

import com.codestates.server.audit.AuditableResponseDto;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CommentResponseDto {
    private Long commentId;
    private String comment;
    private Long memberId;
    private String memberName;
    private AuditableResponseDto auditableResponseDto;
}
//Todo: 리펙터링할 때 중복사항 감싸기