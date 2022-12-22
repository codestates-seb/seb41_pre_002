package com.codestates.server.comment.mapper;

import com.codestates.server.comment.dto.CommentDto;
import com.codestates.server.comment.entity.Comment;
import com.codestates.server.member.entity.Member;
import com.codestates.server.question.entity.Question;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.time.LocalDateTime;
import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CommentMapper {

    List<CommentDto.Response> commentsToCommentResponseDto(List<Comment> comments);

    default Comment commentPostDtoToComment(CommentDto.Post requestBody) {
        if ( requestBody == null ) {
            return null;
        }

        Comment comment = new Comment();
        Member member = new Member();
        Question question = new Question();

        member.setMemberId(requestBody.getMemberId());
        question.setQuestionId(requestBody.getQuestionId());


        comment.setMember(member);
        comment.setQuestion(question);
        comment.setContent(requestBody.getContent());

        return comment;
    }
    default Comment commentPatchDtoToComment(CommentDto.Patch requestBody) {
        if ( requestBody == null ) {
            return null;
        }

        Comment comment = new Comment();
        Member member = new Member();
        Question question = new Question();

        member.setMemberId(requestBody.getMemberId());
        question.setQuestionId(requestBody.getQuestionId());

        comment.setMember(member);
        comment.setQuestion(question);
        comment.setContent(requestBody.getContent());

        return comment;
    }
    default CommentDto.Response commentToCommentResponseDto(Comment comment) {
        if ( comment == null ) {
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

        CommentDto.Response response = new CommentDto.Response( questionId, memberId, content, createdAt, modifiedAt );

        return response;
    }
}
