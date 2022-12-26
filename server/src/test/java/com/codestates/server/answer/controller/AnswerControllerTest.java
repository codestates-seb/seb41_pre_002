package com.codestates.server.answer.controller;

import com.codestates.server.answer.dto.AnswerDto;
import com.codestates.server.answer.entity.Answer;
import com.codestates.server.answer.mapper.AnswerMapper;
import com.codestates.server.answer.service.AnswerService;
import com.codestates.server.audit.AuditableResponseDto;
import com.codestates.server.comment.mapper.AnswerCommentMapper;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AnswerController.class)
@MockBean(JpaMetamodelMappingContext.class)
@AutoConfigureRestDocs
public class AnswerControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Gson gson;

    @MockBean
    private AnswerMapper mapper;

    @MockBean
    private AnswerCommentMapper answerCommentMapper;

    @MockBean
    private AnswerService answerService;

    @Test
    public void postAnswerTest() throws Exception {
        //given
        AnswerDto.Post post = new AnswerDto.Post(1L,1L,"content");
        String content = gson.toJson(post);

        AnswerDto.Response responseDto = AnswerDto.Response
                .builder()
                .answerId(1L)
                .memberId(1L)
                .questionId(1L)
                .memberName("홍길동")
                .content("content")
                .voteCount(0)
                .auditableResponseDto(new AuditableResponseDto(LocalDateTime.now(), null))
                .commentResponseDtos(null)
                .build();


        given(mapper.AnswerPostDtoToAnswer(Mockito.any(AnswerDto.Post.class))).willReturn(new Answer());

        Answer mockResultAnswer = new Answer();
        mockResultAnswer.setAnswerId(1L);
        given(answerService.createAnswer(Mockito.anyLong(),Mockito.any(Answer.class))).willReturn(mockResultAnswer);

        given(mapper.AnswerToAnswerResponseDto(Mockito.any(Answer.class),Mockito.any(AnswerCommentMapper.class))).willReturn(responseDto);

        Long questionId = 1L;
        //when

        ResultActions actions = mockMvc.perform(
                post("/questions/{question-id}/answers", questionId)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content)
        );

        //then
        actions.andExpect(status().isCreated())
                .andExpect(jsonPath("$.data.memberId").value(post.getMemberId()))
                .andExpect(jsonPath("$.data.questionId").value(post.getQuestionId()))
                .andExpect(jsonPath("$.data.content").value(post.getContent()));

    }
}