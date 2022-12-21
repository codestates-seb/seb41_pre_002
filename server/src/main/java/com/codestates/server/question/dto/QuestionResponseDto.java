package com.codestates.server.question.dto;

import com.codestates.server.tag.dto.TagResponseDto;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
public class QuestionResponseDto {
    private Long questionId;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private Long memberId;
    private String memberName;
    private List<TagResponseDto> tagResponseDtos;
}
