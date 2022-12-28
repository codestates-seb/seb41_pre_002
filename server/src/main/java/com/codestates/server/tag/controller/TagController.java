package com.codestates.server.tag.controller;

import com.codestates.server.dto.MultiResponseDto;
import com.codestates.server.tag.entity.Tag;
import com.codestates.server.tag.mapper.TagMapper;
import com.codestates.server.tag.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/tags")
@Validated
@RequiredArgsConstructor
public class TagController {
    private final TagService tagService;
    private final TagMapper tagMapper;

    @GetMapping
    public ResponseEntity getTags(@Positive @RequestParam(required = false, defaultValue = "1") int page,
                                  @Positive @RequestParam(required = false, defaultValue = "36") int size,
                                  @RequestParam(required = false, defaultValue = "") String keyword,
                                  @RequestParam(required = false, defaultValue = "popular") String tab) {

        /**
         * 쿼리 파라미터 tab =
         *  popular - questionCount 높은 순 : questionCount 기준 descending
         *  name - 이름순 : category 기준 ascending
         *  new - 최근에 만들어진 순 : tagId 기준 descending
         * */

        Page<Tag> pageTags = tagService.findTags(page - 1, size, keyword, tab);

        return new ResponseEntity(
                new MultiResponseDto<>(tagMapper.tagsToTagResponseDtos(pageTags.getContent()), pageTags),
                HttpStatus.OK
        );
    }

}
