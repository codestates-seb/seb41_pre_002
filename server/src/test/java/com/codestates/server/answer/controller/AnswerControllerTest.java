package com.codestates.server.answer.controller;

import com.codestates.server.answer.dto.AnswerDto;
import com.codestates.server.answer.entity.Answer;
import com.codestates.server.answer.mapper.AnswerMapper;
import com.codestates.server.answer.service.AnswerService;
import com.codestates.server.audit.AuditableResponseDto;
import com.codestates.server.comment.mapper.AnswerCommentMapper;
import com.codestates.server.config.SecurityTestConfig;
import com.codestates.server.config.TestUserDetailService;
import com.codestates.server.member.entity.Member;
import com.codestates.server.member.service.MemberService;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.http.MediaType;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.delete;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AnswerController.class)
@MockBean(JpaMetamodelMappingContext.class)
@AutoConfigureRestDocs
@Import({SecurityTestConfig.class, TestUserDetailService.class})
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

    @MockBean
    private MemberService memberService;

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

        Member member = new Member();
        member.setMemberId(post.getMemberId());

        given(memberService.findMemberByEmail(Mockito.anyString())).willReturn(member);

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
                .andExpect(jsonPath("$.data.content").value(post.getContent()))
                .andDo(document(
                        "post-answer",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()),
                        pathParameters(
                                parameterWithName("question-id").description("질문 식별자")
                        ),
                        requestFields(
                                List.of(
                                        fieldWithPath("memberId").type(JsonFieldType.NUMBER).description("회원 식별자"),
                                        fieldWithPath("questionId").type(JsonFieldType.NUMBER).description("질문 식별자").ignored(),
                                        fieldWithPath("content").type(JsonFieldType.STRING).description("답변 내용")
                        )
                        ),
                        responseFields(
                                List.of(
                                        fieldWithPath("data").type(JsonFieldType.OBJECT).description("결과 데이터"),
                                        fieldWithPath("data.answerId").type(JsonFieldType.NUMBER).description("답변 식별자"),
                                        fieldWithPath("data.memberId").type(JsonFieldType.NUMBER).description("회원 식별자"),
                                        fieldWithPath("data.questionId").type(JsonFieldType.NUMBER).description("질문 식별자"),
                                        fieldWithPath("data.memberName").type(JsonFieldType.STRING).description("답변자 이름"),
                                        fieldWithPath("data.content").type(JsonFieldType.STRING).description("답변 내용"),
                                        fieldWithPath("data.voteCount").type(JsonFieldType.NUMBER).description("추천수"),
                                        fieldWithPath("data.auditableResponseDto").type(JsonFieldType.OBJECT).description("시간 데이터"),
                                        fieldWithPath("data.auditableResponseDto.createdAt").type(JsonFieldType.STRING).description("작성 날짜"),
                                        fieldWithPath("data.auditableResponseDto.modifiedAt").type(JsonFieldType.STRING).description("수정 날짜").ignored(),
                                        fieldWithPath("data.commentResponseDtos").type(JsonFieldType.OBJECT).description("답글 정보").ignored()
                                )
                        )
                        )
                );
    }
    @Test
    public void patchAnswerTest() throws Exception {
        //given
        AnswerDto.Patch patch = new AnswerDto.Patch(1L, 1L, "patched content");
        String content = gson.toJson(patch);

        AnswerDto.Response responseDto = AnswerDto.Response
                .builder()
                .answerId(1L)
                .memberId(1L)
                .questionId(1L)
                .memberName("홍길동")
                .content("patched content")
                .voteCount(0)
                .auditableResponseDto(new AuditableResponseDto(LocalDateTime.now(), null))
                .commentResponseDtos(null)
                .build();

        Member member = new Member();
        member.setMemberId(patch.getMemberId());

        given(memberService.findMemberByEmail(Mockito.anyString())).willReturn(member);

        given(mapper.AnswerPatchDtoToAnswer(Mockito.any(AnswerDto.Patch.class))).willReturn(new Answer());
        Answer mockResultAnswer = new Answer();
        mockResultAnswer.setAnswerId(1L);
        given(answerService.updateAnswer(Mockito.anyLong(),Mockito.any(Answer.class))).willReturn(mockResultAnswer);

        given(mapper.AnswerToAnswerResponseDto(Mockito.any(Answer.class),Mockito.any(AnswerCommentMapper.class))).willReturn(responseDto);

        Long answerId = 1L;
        //when
        ResultActions actions = mockMvc.perform(
                RestDocumentationRequestBuilders.patch("/answers/{answer-id}", answerId)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content)
        );


        //then
        actions.andExpect(status().isOk())
                .andExpect(jsonPath("$.data.memberId").value(patch.getMemberId()))
                .andExpect(jsonPath("$.data.questionId").value(patch.getQuestionId()))
                .andExpect(jsonPath("$.data.content").value(patch.getContent()))
                .andDo(document(
                                "patch-answer",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()),

                                pathParameters(
                                        parameterWithName("answer-id").description("답변 식별자")
                                ),
                                requestFields(
                                        List.of(
                                                fieldWithPath("memberId").type(JsonFieldType.NUMBER).description("회원 식별자"),
                                                fieldWithPath("questionId").type(JsonFieldType.NUMBER).description("질문 식별자").ignored(),
                                                fieldWithPath("content").type(JsonFieldType.STRING).description("답변 내용")
                                        )
                                ),
                                responseFields(
                                        List.of(
                                                fieldWithPath("data").type(JsonFieldType.OBJECT).description("결과 데이터"),
                                                fieldWithPath("data.answerId").type(JsonFieldType.NUMBER).description("답변 식별자"),
                                                fieldWithPath("data.memberId").type(JsonFieldType.NUMBER).description("회원 식별자"),
                                                fieldWithPath("data.questionId").type(JsonFieldType.NUMBER).description("질문 식별자"),
                                                fieldWithPath("data.memberName").type(JsonFieldType.STRING).description("답변자 이름"),
                                                fieldWithPath("data.content").type(JsonFieldType.STRING).description("답변 내용"),
                                                fieldWithPath("data.voteCount").type(JsonFieldType.NUMBER).description("추천수"),
                                                fieldWithPath("data.auditableResponseDto").type(JsonFieldType.OBJECT).description("시간 데이터"),
                                                fieldWithPath("data.auditableResponseDto.createdAt").type(JsonFieldType.STRING).description("작성 날짜"),
                                                fieldWithPath("data.auditableResponseDto.modifiedAt").type(JsonFieldType.STRING).description("수정 날짜").ignored(),
                                                fieldWithPath("data.commentResponseDtos").type(JsonFieldType.OBJECT).description("답글 정보").ignored()
                                        )
                                )
                        )
                );

    }
    @Test
    public void deleteAnswerTest() throws Exception {
        //given
        Long answerId = 1L;

        doNothing().when(answerService).deleteAnswer(Mockito.anyLong(),Mockito.anyString());


        //when
        ResultActions actions = mockMvc.perform(
                delete("/answers/{answer-id}",answerId)
                        .contentType(MediaType.APPLICATION_JSON)
        );

        //then
        actions.andExpect(status().isOk())
                .andDo(
                        document(
                                "delete-answer",
                                preprocessRequest(prettyPrint()),
                                preprocessResponse(prettyPrint()),
                                pathParameters(
                                        parameterWithName("answer-id").description("답변 식별자")
                                ),
                                responseFields(
                                        List.of(fieldWithPath("data").type(JsonFieldType.OBJECT).description("결과 데이터"),
                                        fieldWithPath("data.questionId").type(JsonFieldType.NUMBER).description("질문 식별자")
                                )


                        )
                )
                );
    }
}