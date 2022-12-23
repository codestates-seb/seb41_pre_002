package com.codestates.server.answer.mapper;

import com.codestates.server.answer.dto.AnswerDto;
import com.codestates.server.answer.entity.Answer;
import com.codestates.server.audit.AuditableResponseDto;
import com.codestates.server.comment.dto.CommentDto;
import com.codestates.server.member.entity.Member;
import com.codestates.server.question.entity.Question;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;


@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface AnswerMapper {

    List<AnswerDto.Response> AnswersToAnswerResponseDtos(List<Answer> answers);

    default Answer AnswerPostDtoToAnswer(AnswerDto.Post requestBody) {
        if (requestBody == null) {
            return null;
        } else {
            Answer answer = new Answer();
            Question question = new Question();
            question.setQuestionId(requestBody.getQuestionId());
            Member member = new Member();
            member.setMemberId(requestBody.getMemberId());

            answer.setContent(requestBody.getContent());
            answer.setQuestion(question);
            answer.setMember(member);
            return answer;
        }
    }

    default Answer AnswerPatchDtoToAnswer(AnswerDto.Patch requestBody) {
        if (requestBody == null) {
            return null;
        } else {
            Answer answer = new Answer();
            Question question = new Question();
            question.setQuestionId(requestBody.getQuestionId());
            Member member = new Member();
            member.setMemberId(requestBody.getMemberId());

            answer.setContent(requestBody.getContent());
            answer.setQuestion(question);
            answer.setMember(member);
            return answer;
        }
    }

    default AnswerDto.Response AnswerToAnswerResponseDto(Answer answer) {
        if (answer == null) {
            return null;
        }
        return AnswerDto.Response.builder()
                .answerId(answer.getAnswerId())
                .questionId(answer.getQuestion().getQuestionId())
                .content(answer.getContent())
                .auditableResponseDto(new AuditableResponseDto(answer.getCreatedAt(), answer.getModifiedAt()))
                .voteCount(answer.getAnswerVotes().stream()
                        .map(answerVote -> answerVote.getScore())
                        .reduce(0, (x, y) -> x + y))
                .memberId(answer.getMember().getMemberId())
                .memberName(answer.getMember().getMemberName())
                .commentResponseDtos(answer.getComments().stream()
                        .map(comment -> { //Todo: CommentMapper에 있음 합쳐야됨
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
                            Long answerId = null;
                            if (comment.getAnswer() == null) {
                                answerId = null;
                            } else answerId = comment.getAnswer().getAnswerId();

                            CommentDto.Response response = new CommentDto.Response(comment.getCommentId(), questionId, answerId, memberId, memberName, content, new AuditableResponseDto(createdAt, modifiedAt));

                            return response;
                        })
                        .collect(Collectors.toList()))
                .build();
    }
}

