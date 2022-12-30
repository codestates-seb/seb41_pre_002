package com.codestates.server.question.dto;

import com.codestates.server.answer.dto.AnswerDto;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class QuestionDetailResponseDto {
    private QuestionResponseDto questionResponseDto;

    //Todo: 어떻게 하면 멋지게 디테일 화면 데이터를 쏴줄 수 있을 것인가?
    private List<AnswerDto.Response> answerResponseDtos;
}
//Todo: 리펙터링할 때 중복사항 감싸기