package com.codestates.server.question.mapper;

import com.codestates.server.question.dto.QuestionPostDto;
import com.codestates.server.question.dto.QuestionResponseDto;
import com.codestates.server.question.dto.QuestionSuccessResponseDto;
import com.codestates.server.question.entity.Question;
import com.codestates.server.question.entity.QuestionTag;
import com.codestates.server.tag.dto.TagResponseDto;
import com.codestates.server.tag.entity.Tag;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface QuestionMapper {
    default Question questionPostDtoToQuestion(QuestionPostDto questionPostDto, List<Tag> tags) {
        if (tags == null) {
            return questionPostDtoToQuestion(questionPostDto);
        }

        Question question = new Question();
        question.setMember(questionPostDto.getMember());

        if (questionPostDto != null) {
            question.setTitle(questionPostDto.getTitle());
            question.setContent(questionPostDto.getContent());

            tags.stream()
                    .forEach(tag -> {
                        QuestionTag questionTag = new QuestionTag();
                        questionTag.setQuestion(question);

                        Tag tag1 = new Tag();
                        tag1.setTagId(tag.getTagId());
                        questionTag.setTag(tag1);

                        question.addQuestionTag(questionTag);
                    });
        }

        return question;
    }

    Question questionPostDtoToQuestion(QuestionPostDto questionPostDto);

    QuestionSuccessResponseDto questionToQuestionSuccessResponseDto(Question question);

    default List<QuestionResponseDto> questionsToQuestionResponseDtos(List<Question> questions) {
        if (questions == null) return null;

        return questions.stream()
                .map(question -> {
                    QuestionResponseDto.QuestionResponseDtoBuilder questionResponseDto = QuestionResponseDto.builder();
                    questionResponseDto.questionId(question.getQuestionId());
                    questionResponseDto.title(question.getTitle());
                    questionResponseDto.content(question.getContent());
                    questionResponseDto.memberId(question.getMember().getMemberId());
                    questionResponseDto.memberName(question.getMember().getMemberName());
                    questionResponseDto.tagResponseDtos(questionTagsToTagResponseDtos(question.getQuestionTags()));
                    return questionResponseDto.build();
                })
                .collect(Collectors.toList());
    }

    default List<TagResponseDto> questionTagsToTagResponseDtos(List<QuestionTag> questionTags) {
        return questionTags.stream()
                .map(questionTag -> {
                    TagResponseDto tagResponseDto = new TagResponseDto();
                    tagResponseDto.setTagId(questionTag.getTag().getTagId());
                    tagResponseDto.setCategory(questionTag.getTag().getCategory());
                    return tagResponseDto;
                })
                .collect(Collectors.toList());
    }

}
