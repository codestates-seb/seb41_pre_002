package com.codestates.server.answer.mapper;

import com.codestates.server.answer.dto.AnswerDto;
import com.codestates.server.answer.entity.Answer;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface AnswerMapper {
    Answer AnswerPostDtoToAnswer(AnswerDto.Post requestBody);
    Answer AnswerPatchDtoToAnswer(AnswerDto.Patch requestBody);
    AnswerDto.Response AnswerToAnswerResponseDto(Answer answer);
    List<AnswerDto.Response> AnswersToAnswerResponseDtos(List<Answer> answers);
}
