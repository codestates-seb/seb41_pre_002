package com.codestates.server.tag.mapper;

import com.codestates.server.tag.dto.TagResponseDto;
import com.codestates.server.tag.entity.Tag;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface TagMapper {
    default List<TagResponseDto> tagsToTagResponseDtos(List<Tag> tags) {
        return tags.stream()
                .map(tag -> tagToTagResponseDto(tag))
                .collect(Collectors.toList());
    }

    default TagResponseDto tagToTagResponseDto(Tag tag) {
        TagResponseDto tagResponseDto = new TagResponseDto();
        tagResponseDto.setTagId(tag.getTagId());
        tagResponseDto.setCategory(tag.getCategory());
        tagResponseDto.setQuestionsCount(tag.getQuestionsCount());

        return tagResponseDto;
    }

}
