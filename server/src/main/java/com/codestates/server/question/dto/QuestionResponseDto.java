package com.codestates.server.question.dto;

import com.codestates.server.audit.AuditableResponseDto;
import com.codestates.server.comment.dto.CommentDto;
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
    private List<CommentDto.Response> commentResponseDtos;
}