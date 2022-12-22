package com.codestates.server.question.dto;

import com.codestates.server.audit.AuditableResponseDto;
import com.codestates.server.tag.dto.TagResponseDto;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class QuestionResponseDto {
    private Long questionId;
    private String title;
    private String content;
    private AuditableResponseDto auditableResponseDto;
    private Long memberId;
    private String memberName;
    private List<TagResponseDto> tagResponseDtos;
    private Integer answerCount;
    private Integer voteCount;
    private List<CommentResponseDto> commentResponseDtos;
}
//Todo: 리펙터링할 때 중복사항 감싸기