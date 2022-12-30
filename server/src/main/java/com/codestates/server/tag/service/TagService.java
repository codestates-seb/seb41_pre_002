package com.codestates.server.tag.service;

import com.codestates.server.question.entity.Question;
import com.codestates.server.question.entity.QuestionTag;
import com.codestates.server.question.repository.QuestionTagRepository;
import com.codestates.server.tag.entity.Tag;
import com.codestates.server.tag.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class TagService {
    private final TagRepository tagRepository;
    private final QuestionTagRepository questionTagRepository;

    public Tag createTag(String category) {
        Tag tag = new Tag();
        tag.setCategory(category);
        return tagRepository.save(tag);
    }

    public List<Tag> findTagsElseCreateTags(List<String> categories) {
        return categories.stream()
                .map(category -> findVerifiedTag(category))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Page<Tag> findTags(int page, int size, String keyword, String tab) {
        /**
         * 쿼리 파라미터 tab =
         *  popular - questionCount 높은 순 : questionCount 기준 descending
         *  name - 이름순 : category 기준 ascending
         *  new - 최근에 만들어진 순 : tagId 기준 descending
         * */

        Pageable pageable;
        Page<Tag> tags;

        switch (tab) {
            case "new":
                pageable = PageRequest.of(page, size, Sort.by("tagId").descending());
                break;

            case "name":
                pageable = PageRequest.of(page, size, Sort.by("category").ascending());
                break;

            default: // popular
                pageable = PageRequest.of(page, size, Sort.by("questionsCount").descending());
        }

        if (keyword.length() == 0) {
            tags = tagRepository.findAll(pageable);
        } else {
            tags = tagRepository.findAllByCategoryContains(keyword, pageable);
        }

        return tags;
    }

    public void updateQuestionsCount(Tag tag) {
        tag.calQuestionsCount();
        tagRepository.save(tag);
    }

    public void updateQuestionTags(Question question, List<String> categories) {
        //Todo: 더 효율적인 방법이 존재함. 무식한 방법말고 업그레이드해야됨

        // 기존 질문태그 삭제
        questionTagRepository.findAllByQuestion(question).stream()
                .forEach(questionTag -> {
                    questionTagRepository.delete(questionTag);
                    updateQuestionsCount(questionTag.getTag());
                });

        // 새로운 태그 유효성 검사 및 등록
        List<Tag> findTags = findTagsElseCreateTags(categories);

        // Question에 새로운 QuestionTag 저장
        findTags.stream()
                .forEach(tag -> {
                    QuestionTag questionTag = new QuestionTag();
                    questionTag.setQuestion(question);
                    questionTag.setTag(tag);
                    QuestionTag savedQuestionTag = questionTagRepository.save(questionTag);
                    updateQuestionsCount(savedQuestionTag.getTag());
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
