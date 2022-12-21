package com.codestates.server.question.dto;

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
    private Long memberId;
    private String memberName;
    private List<TagResponseDto> tagResponseDtos;

    //Todo: 질문을 남긴 시간 ???
}
