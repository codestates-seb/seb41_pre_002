package com.codestates.server.comment.mapper;

import com.codestates.server.audit.AuditableResponseDto;
import com.codestates.server.comment.dto.AnswerCommentDto;
import com.codestates.server.comment.entity.AnswerComment;
import com.codestates.server.member.entity.Member;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.time.LocalDateTime;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AnswerCommentMapper {
    default AnswerComment answerCommentPostDtoToComment(AnswerCommentDto.Post requestBody) {
        if (requestBody == null) {
            return null;
        }

        AnswerComment answerComment = new AnswerComment();
        Member member = new Member();

        member.setMemberId(requestBody.getMemberId());


        answerComment.setMember(member);
        answerComment.setContent(requestBody.getContent());

        return answerComment;
    }

    default AnswerComment commentPatchDtoToComment(AnswerCommentDto.Patch requestBody) {
        if (requestBody == null) {
            return null;
        }

        AnswerComment comment = new AnswerComment();
        Member member = new Member();

        member.setMemberId(requestBody.getMemberId());

        comment.setMember(member);
        comment.setContent(requestBody.getContent());

        return comment;
    }

    default AnswerCommentDto.Response answerCommentToAnswerCommentResponseDto(AnswerComment comment) {
        if (comment == null) {
            return null;
        }

        String content = null;
        LocalDateTime createdAt = null;
        LocalDateTime modifiedAt = null;

        content = comment.getContent();
        createdAt = comment.getCreatedAt();
        modifiedAt = comment.getModifiedAt();

        Long memberId = comment.getMember().getMemberId();
        String memberName = comment.getMember().getMemberName();
        Long answerId = comment.getAnswer().getAnswerId();

        AnswerCommentDto.Response response = new AnswerCommentDto.Response(comment.getAnswerCommentId(), answerId, memberId, memberName, content, new AuditableResponseDto(createdAt, modifiedAt));

        return response;
    }
}
