package com.codestates.server.answer.mapper;

import com.codestates.server.answer.dto.AnswerDto;
import com.codestates.server.answer.entity.Answer;
import com.codestates.server.member.entity.Member;
import com.codestates.server.question.entity.Question;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Mapper(componentModel = "spring",unmappedSourcePolicy = ReportingPolicy.IGNORE)
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
                .memberId(answer.getMember().getMemberId())
                .questionId(answer.getAnswerId())
                .memberName(answer.getMember().getMemberName())
                .content(answer.getContent())
                .createdAt(answer.getCreatedAt())
                .modifiedAt(answer.getModifiedAt())
                .build();
    }
}

