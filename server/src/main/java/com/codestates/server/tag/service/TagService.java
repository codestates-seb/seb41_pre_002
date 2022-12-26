package com.codestates.server.tag.service;

import com.codestates.server.question.entity.Question;
import com.codestates.server.question.entity.QuestionTag;
import com.codestates.server.question.repository.QuestionTagRepository;
import com.codestates.server.tag.entity.Tag;
import com.codestates.server.tag.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TagService {
    private final TagRepository tagRepository;
    private final QuestionTagRepository questionTagRepository;

    public Tag createTag(String category) {
//        Tag.TagBuilder tag = Tag.builder();
//        tag.category(category);
//        return tagRepository.save(tag.build());
        Tag tag = new Tag();
        tag.setCategory(category);
        return tagRepository.save(tag);
    }

    public List<Tag> findTagsElseCreateTags(List<String> categories) {
        return categories.stream()
                .map(category -> findVerifiedTag(category))
                .collect(Collectors.toList());
    }

    public void updateQuestionTags(Question question, List<String> categories) {
        //Todo: 더 효율적인 방법이 존재함. 무식한 방법말고 업그레이드해야됨

        // 기존 질문태그 삭제
        questionTagRepository.findAllByQuestion(question).stream()
                .forEach(questionTag -> questionTagRepository.delete(questionTag));

        // 새로운 태그 유효성 검사 및 등록
        List<Tag> findTags = findTagsElseCreateTags(categories);

        // Question에 새로운 QuestionTag 저장
        findTags.stream()
                .forEach(tag -> {
                    QuestionTag questionTag = new QuestionTag();
                    questionTag.setQuestion(question);
                    questionTag.setTag(tag);
                    questionTagRepository.save(questionTag);
                });
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
