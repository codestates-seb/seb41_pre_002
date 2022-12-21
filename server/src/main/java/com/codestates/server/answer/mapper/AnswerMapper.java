package com.codestates.server.answer.mapper;

import com.codestates.server.answer.dto.AnswerDto;
import com.codestates.server.answer.entity.Answer;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.time.LocalDateTime;
import java.util.List;

@Mapper(componentModel = "spring",unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface AnswerMapper {
    Answer AnswerPostDtoToAnswer(AnswerDto.Post requestBody);
    Answer AnswerPatchDtoToAnswer(AnswerDto.Patch requestBody);

    List<AnswerDto.Response> AnswersToAnswerResponseDtos(List<Answer> answers);

    default AnswerDto.Response AnswerToAnswerResponseDto(Answer answer) {
        if (answer == null) {
            return null;
        } else {
            String content = null;
            LocalDateTime createdAt = null;
            LocalDateTime modifiedAt = null;
            String memberName = null;
            content = answer.getContent();
            createdAt = answer.getCreatedAt();
            modifiedAt = answer.getModifiedAt();
            memberName = answer.getMember().getMemberName();
            AnswerDto.Response response = new AnswerDto.Response((String) memberName, content, createdAt, modifiedAt);
            return response;
        }
    }
}

