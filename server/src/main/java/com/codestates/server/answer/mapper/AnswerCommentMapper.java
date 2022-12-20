package com.codestates.server.answer.mapper;

import com.codestates.server.answer.dto.AnswerCommentDto;
import com.codestates.server.answer.entity.AnswerComment;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AnswerCommentMapper {
    AnswerComment AnswerCommentPostDtoToAnswerComment(AnswerCommentDto.Post requestBody);
    AnswerComment AnswerCommentPatchDtoToAnswerComment(AnswerCommentDto.Patch requestBody);
    AnswerCommentDto.Response AnswerCommentToAnswerCommentResponseDto(AnswerComment answerComment);
    List<AnswerCommentDto.Response> AnswerCommentsToAnswerCommentResponseDtos(List<AnswerComment> answerComments);
}
