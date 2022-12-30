package com.codestates.server.comment.mapper;

import com.codestates.server.audit.AuditableResponseDto;
import com.codestates.server.comment.dto.QuestionCommentDto;
import com.codestates.server.comment.entity.QuestionComment;
import com.codestates.server.member.entity.Member;
import com.codestates.server.question.entity.Question;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.time.LocalDateTime;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface QuestionCommentMapper {

    default QuestionComment questionCommentPostDtoToQuestionComment(QuestionCommentDto.Post requestBody) {
        if (requestBody == null) {
            return null;
        }

        QuestionComment comment = new QuestionComment();
        Member member = new Member();
        Question question = new Question();

        member.setMemberId(requestBody.getMemberId());
        question.setQuestionId(requestBody.getQuestionId());


        comment.setMember(member);
        comment.setQuestion(question);
        comment.setContent(requestBody.getContent());

        return comment;
    }

    default QuestionComment questionCommentPatchDtoToQuestionComment(QuestionCommentDto.Patch requestBody) {
        if (requestBody == null) {
            return null;
        }
        QuestionComment comment = new QuestionComment();
        Member member = new Member();
        Question question = new Question();

        member.setMemberId(requestBody.getMemberId());
        question.setQuestionId(requestBody.getQuestionId());

        comment.setMember(member);
        comment.setQuestion(question);
        comment.setContent(requestBody.getContent());

        return comment;
    }

    default QuestionCommentDto.Response commentToCommentResponseDto(QuestionComment comment) {
        if (comment == null) {
            return null;
        }

        String content = null;
        LocalDateTime createdAt = null;
        LocalDateTime modifiedAt = null;

        content = comment.getContent();
        createdAt = comment.getCreatedAt();
        modifiedAt = comment.getModifiedAt();

        Long questionId = comment.getQuestion().getQuestionId();
        Long memberId = comment.getMember().getMemberId();
        String memberName = comment.getMember().getMemberName();

        QuestionCommentDto.Response response = new QuestionCommentDto.Response(comment.getCommentId(), questionId, memberId, memberName, content, new AuditableResponseDto(createdAt, modifiedAt));

        return response;
    }
    default QuestionCommentDto.QuestionIdResponse questionCommentToQuestionIdResponseDto(QuestionComment questionComment) {
        QuestionCommentDto.QuestionIdResponse questionIdResponse = new QuestionCommentDto.QuestionIdResponse(questionComment.getQuestion().getQuestionId());
        return questionIdResponse;
    }
}
