package com.codestates.server.tag.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TagResponseDto {
    private Long tagId;
    private String category;
    private Integer questionsCount;
}
