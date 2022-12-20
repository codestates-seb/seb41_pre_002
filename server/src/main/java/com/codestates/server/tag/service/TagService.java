package com.codestates.server.tag.service;

import com.codestates.server.tag.entity.Tag;
import com.codestates.server.tag.repository.TagRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TagService {
    private TagRepository tagRepository;

    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public Tag createTag(String category) {
//        Tag.TagBuilder tag = Tag.builder();
//        tag.category(category);
//        return tagRepository.save(tag.build());
        Tag tag = new Tag();
        tag.setCategory(category);
        return tagRepository.save(tag);
    }

    public List<Tag> findTags(List<String> categories) {
        return categories.stream()
                .map(category -> findVerifiedTag(category))
                .collect(Collectors.toList());
    }

    public Tag findVerifiedTag(String category) {
        Optional<Tag> optionalTag = tagRepository.findByCategory(category);
        if (optionalTag.isPresent()) {
            return optionalTag.get();
        } else {
            return createTag(category);
        }
    }
}
