package com.codestates.server.comment.mapper;

import com.codestates.server.comment.dto.CommentDto;
import com.codestates.server.comment.entity.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CommentMapper {
    Comment CommentPostDtoToComment(CommentDto.Post requestBody);
    Comment CommentPatchDtoToComment(CommentDto.Patch requestBody);
    CommentDto.Response CommentToCommentResponseDto(Comment answerComment);
    List<CommentDto.Response> CommentsToCommentResponseDtos(List<Comment> answerComments);
}
