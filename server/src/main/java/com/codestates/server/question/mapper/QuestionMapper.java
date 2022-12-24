package com.codestates.server.question.mapper;

import com.codestates.server.answer.mapper.AnswerMapper;
import com.codestates.server.audit.AuditableResponseDto;
import com.codestates.server.comment.dto.QuestionCommentDto;
import com.codestates.server.comment.mapper.AnswerCommentMapper;
import com.codestates.server.comment.mapper.QuestionCommentMapper;
import com.codestates.server.question.dto.*;
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

        if (questionPostDto != null) {
            question.setTitle(questionPostDto.getTitle());
            question.setContent(questionPostDto.getContent());
            question.setMember(questionPostDto.getMember());

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

    default Question questionPatchDtoToQuestion(QuestionPatchDto questionPatchDto, List<Tag> tags) {
        if (tags == null) {
            return questionPatchDtoToQuestion(questionPatchDto);
        }

        Question question = new Question();

        if (questionPatchDto != null) {
            question.setQuestionId(questionPatchDto.getQuestionId());
            question.setTitle(questionPatchDto.getTitle());
            question.setContent(questionPatchDto.getContent());
            question.setMember(questionPatchDto.getMember());

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

    Question questionPatchDtoToQuestion(QuestionPatchDto questionPatchDto);

    QuestionSuccessResponseDto questionToQuestionSuccessResponseDto(Question question);

    default List<QuestionResponseDto> questionsToQuestionResponseDtos(List<Question> questions, QuestionCommentMapper questionCommentMapper) {
        if (questions == null) return null;

        return questions.stream()
                .map(question -> questionToQuestionResponseDto(question, false, questionCommentMapper ))
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

    default QuestionDetailResponseDto questionToQuestionDetailResponseDto(Question question, AnswerMapper answerMapper, AnswerCommentMapper answerCommentMapper, QuestionCommentMapper questionCommentMapper) {

        if (question == null) {
            return null;
        }

        // questionDetailResponseDto 변환 시작
        return QuestionDetailResponseDto
                .builder()
                .questionResponseDto(questionToQuestionResponseDto(question, true, questionCommentMapper))
                .answerResponseDtos(question.getAnswers().stream()
                        .map(answer -> answerMapper.AnswerToAnswerResponseDto(answer, answerCommentMapper))
                        .collect(Collectors.toList()))
                .build();
    }

    default QuestionResponseDto questionToQuestionResponseDto(Question question, boolean detail, QuestionCommentMapper questionCommentMapper) {
        if (question == null) {
            return null;
        }
        List<QuestionCommentDto.Response> commentResponseDto = null;
        if (detail) {
            commentResponseDto = question.getComments().stream()
                    .map(comment -> questionCommentMapper.commentToCommentResponseDto(comment))
                    .collect(Collectors.toList());

        }

        return QuestionResponseDto
                .builder()
                .questionId(question.getQuestionId())
                .title(question.getTitle())
                .content(question.getContent())
                .auditableResponseDto(new AuditableResponseDto(question.getCreatedAt(), question.getModifiedAt()))
                .memberId(question.getMember().getMemberId())
                .memberName(question.getMember().getMemberName())
                .tagResponseDtos(questionTagsToTagResponseDtos(question.getQuestionTags()))
                .answerCount(question.getAnswers().size())
                .voteCount(question.getQuestionVotes().stream()
                        .map(questionVote -> questionVote.getScore())
                        .reduce(0, (x, y) -> x + y))
                .commentResponseDtos(commentResponseDto)
                .build();
    }
}
