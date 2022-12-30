package com.codestates.server.comment.controller;

import com.codestates.server.answer.controller.AnswerController;
import com.codestates.server.comment.dto.AnswerCommentDto;
import com.codestates.server.comment.dto.QuestionCommentDto;
import com.codestates.server.comment.entity.AnswerComment;
import com.codestates.server.comment.entity.QuestionComment;
import com.codestates.server.comment.mapper.AnswerCommentMapper;
import com.codestates.server.comment.mapper.QuestionCommentMapper;
import com.codestates.server.comment.service.AnswerCommentService;
import com.codestates.server.comment.service.QuestionCommentService;
import com.codestates.server.config.SecurityTestConfig;
import com.codestates.server.config.TestUserDetailService;
import com.codestates.server.security.SecurityConfig;
import com.google.gson.Gson;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.http.MediaType;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CommentController.class)
@MockBean(JpaMetamodelMappingContext.class)
@Import({SecurityTestConfig.class, TestUserDetailService.class})
@AutoConfigureRestDocs
public class CommentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Gson gson;

    @MockBean
    private AnswerCommentMapper answerCommentMapper;

    @MockBean
    private AnswerCommentService answerCommentService;

    @MockBean
    private QuestionCommentMapper questionCommentMapper;

    @MockBean
    private QuestionCommentService questionCommentService;

    @Test

    public void postAnswerCommentTest() throws Exception {
        //given
        AnswerCommentDto.Post post = new AnswerCommentDto.Post(1L, 1L, "content");
        String content = gson.toJson(post);

        given(answerCommentMapper.answerCommentPostDtoToComment(Mockito.any(AnswerCommentDto.Post.class))).willReturn(new AnswerComment());

        AnswerComment mockAnswerComment = new AnswerComment();
        mockAnswerComment.setAnswerCommentId(1L);

        given(answerCommentService.postAnswerComment(Mockito.anyLong(),Mockito.any(AnswerComment.class))).willReturn(mockAnswerComment);

        AnswerCommentDto.AnswerIdResponse answerIdResponse = new AnswerCommentDto.AnswerIdResponse(post.getAnswerId());

        given(answerCommentMapper.answerCommentToAnswerIdResponseDto(Mockito.any(AnswerComment.class))).willReturn(answerIdResponse);
        Long answerId = post.getAnswerId();
        //when
        ResultActions actions = mockMvc.perform(
                post("/answers/{answer-id}/comments", answerId)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content)
        );

        //then
        actions.andExpect(status().isCreated())
                .andExpect(jsonPath("data.answerId").value(post.getAnswerId()))
                .andDo(document(
                                "post-answerComment",
                                preprocessRequest(prettyPrint()),
                                preprocessResponse(prettyPrint()),
                                pathParameters(
                                        parameterWithName("answer-id").description("답변 식별자")
                                ),
                                requestFields(
                                        List.of(
                                                fieldWithPath("memberId").type(JsonFieldType.NUMBER).description("회원 식별자"),
                                                fieldWithPath("answerId").type(JsonFieldType.NUMBER).description("답변 식별자").ignored(),
                                                fieldWithPath("content").type(JsonFieldType.STRING).description("댓글 내용")
                                        )
                                ),
                                responseFields(
                                        List.of(
                                                fieldWithPath("data").type(JsonFieldType.OBJECT).description("결과 데이터"),
                                                fieldWithPath("data.answerId").type(JsonFieldType.NUMBER).description("답변 식별자")
                                        )
                                )
                        )
                );


    }
    @Test
    public void patchAnswerCommentTest() throws Exception {
        AnswerCommentDto.Patch patch = new AnswerCommentDto.Patch(1L, 1L, "content");
        String content = gson.toJson(patch);

        given(answerCommentMapper.commentPatchDtoToComment(Mockito.any(AnswerCommentDto.Patch.class))).willReturn(new AnswerComment());

        AnswerComment mockAnswerComment = new AnswerComment();
        mockAnswerComment.setAnswerCommentId(1L);

        given(answerCommentService.updateAnswerComment(Mockito.anyLong(),Mockito.any(AnswerComment.class))).willReturn(mockAnswerComment);

        AnswerCommentDto.AnswerIdResponse answerIdResponse = new AnswerCommentDto.AnswerIdResponse(patch.getAnswerId());

        given(answerCommentMapper.answerCommentToAnswerIdResponseDto(Mockito.any(AnswerComment.class))).willReturn(answerIdResponse);
        Long answerId = patch.getAnswerId();
        Long commentId = mockAnswerComment.getAnswerCommentId();
        //when
        ResultActions actions = mockMvc.perform(
                patch("/answers/{answer-id}/comments/{comment-id}", answerId, commentId)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content)
        );

        //then
        actions.andExpect(status().isOk())
                .andExpect(jsonPath("data.answerId").value(patch.getAnswerId()))
                .andDo(document(
                                "patch-answerComment",
                                preprocessRequest(prettyPrint()),
                                preprocessResponse(prettyPrint()),
                                pathParameters(
                                        parameterWithName("answer-id").description("답변 식별자"),
                                        parameterWithName("comment-id").description("댓글 식별자")
                                ),
                                requestFields(
                                        List.of(
                                                fieldWithPath("memberId").type(JsonFieldType.NUMBER).description("회원 식별자"),
                                                fieldWithPath("answerId").type(JsonFieldType.NUMBER).description("답변 식별자").ignored(),
                                                fieldWithPath("content").type(JsonFieldType.STRING).description("댓글 내용")
                                        )
                                ),
                                responseFields(
                                        List.of(
                                                fieldWithPath("data").type(JsonFieldType.OBJECT).description("결과 데이터"),
                                                fieldWithPath("data.answerId").type(JsonFieldType.NUMBER).description("답변 식별자")
                                        )
                                )
                        )
                );

    }
    @Test
    public void deleteAnswerCommentTest() throws Exception {
        //given
        given(answerCommentService.deleteComment(Mockito.anyLong())).willReturn(1L);

        Long answerId = 1L;
        Long commentId = 1L;
        //when
        ResultActions actions = mockMvc.perform(
                delete("/answers/{answer-id}/comments/{comment-id}",answerId,commentId)
                        .contentType(MediaType.APPLICATION_JSON)
        );

        //then
        actions.andExpect(status().isOk())
                .andExpect(jsonPath("data.questionId").value(1L))
                .andDo(document(
                                "delete-answerComment",
                                preprocessRequest(prettyPrint()),
                                preprocessResponse(prettyPrint()),
                                pathParameters(
                                        parameterWithName("answer-id").description("답변 식별자"),
                                        parameterWithName("comment-id").description("댓글 식별자")
                                ),
                                responseFields(
                                        List.of(
                                                fieldWithPath("data").type(JsonFieldType.OBJECT).description("결과 데이터"),
                                                fieldWithPath("data.questionId").type(JsonFieldType.NUMBER).description("질문 식별자")
                                        )
                                )
                        )
                );
    }
    @Test
    public void postQuestionCommentTest() throws Exception {
        //given
        QuestionCommentDto.Post post = new QuestionCommentDto.Post(1L, 1L, "content");
        String content = gson.toJson(post);

        given(questionCommentMapper.questionCommentPostDtoToQuestionComment(Mockito.any(QuestionCommentDto.Post.class))).willReturn(new QuestionComment());

        QuestionComment mockQuestionComment = new QuestionComment();
        mockQuestionComment.setCommentId(1L);

        given(questionCommentService.postQuestionComment(Mockito.anyLong(),Mockito.any(QuestionComment.class))).willReturn(mockQuestionComment);

        QuestionCommentDto.QuestionIdResponse questionIdResponse = new QuestionCommentDto.QuestionIdResponse(post.getQuestionId());

        given(questionCommentMapper.questionCommentToQuestionIdResponseDto(Mockito.any(QuestionComment.class))).willReturn(questionIdResponse);
        Long questionId = post.getQuestionId();
        //when
        ResultActions actions = mockMvc.perform(
                post("/questions/{question-id}/comments", questionId)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content)
        );

        //then
        actions.andExpect(status().isCreated())
                .andExpect(jsonPath("data.questionId").value(post.getQuestionId()))
                .andDo(document(
                                "post-questionComment",
                                preprocessRequest(prettyPrint()),
                                preprocessResponse(prettyPrint()),
                                pathParameters(
                                        parameterWithName("question-id").description("질문 식별자")
                                ),
                                requestFields(
                                        List.of(
                                                fieldWithPath("memberId").type(JsonFieldType.NUMBER).description("회원 식별자"),
                                                fieldWithPath("questionId").type(JsonFieldType.NUMBER).description("질문 식별자").ignored(),
                                                fieldWithPath("content").type(JsonFieldType.STRING).description("댓글 내용")
                                        )
                                ),
                                responseFields(
                                        List.of(
                                                fieldWithPath("data").type(JsonFieldType.OBJECT).description("결과 데이터"),
                                                fieldWithPath("data.questionId").type(JsonFieldType.NUMBER).description("질문 식별자")
                                        )
                                )
                        )
                );


    }
    @Test
    public void patchQuestionCommentTest() throws Exception {
        //given
        QuestionCommentDto.Patch patch = new QuestionCommentDto.Patch(1L, 1L, "content");
        String content = gson.toJson(patch);

        given(questionCommentMapper.questionCommentPatchDtoToQuestionComment(Mockito.any(QuestionCommentDto.Patch.class))).willReturn(new QuestionComment());

        QuestionComment mockQuestionComment = new QuestionComment();
        mockQuestionComment.setCommentId(1L);

        given(questionCommentService.updateQuestionComment(Mockito.anyLong(),Mockito.any(QuestionComment.class))).willReturn(mockQuestionComment);

        QuestionCommentDto.QuestionIdResponse questionIdResponse = new QuestionCommentDto.QuestionIdResponse(patch.getQuestionId());

        given(questionCommentMapper.questionCommentToQuestionIdResponseDto(Mockito.any(QuestionComment.class))).willReturn(questionIdResponse);
        Long questionId = patch.getQuestionId();
        Long commentId = 1L;
        //when
        ResultActions actions = mockMvc.perform(
                patch("/questions/{question-id}/comments/{comment-id}", questionId, commentId)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content)
        );

        //then
        actions.andExpect(status().isOk())
                .andExpect(jsonPath("data.questionId").value(patch.getQuestionId()))
                .andDo(document(
                                "patch-questionComment",
                                preprocessRequest(prettyPrint()),
                                preprocessResponse(prettyPrint()),
                                pathParameters(
                                        parameterWithName("question-id").description("질문 식별자"),
                                        parameterWithName("comment-id").description("댓글 식별자")
                                ),
                                requestFields(
                                        List.of(
                                                fieldWithPath("memberId").type(JsonFieldType.NUMBER).description("회원 식별자"),
                                                fieldWithPath("questionId").type(JsonFieldType.NUMBER).description("질문 식별자").ignored(),
                                                fieldWithPath("content").type(JsonFieldType.STRING).description("댓글 내용")
                                        )
                                ),
                                responseFields(
                                        List.of(
                                                fieldWithPath("data").type(JsonFieldType.OBJECT).description("결과 데이터"),
                                                fieldWithPath("data.questionId").type(JsonFieldType.NUMBER).description("질문 식별자")
                                        )
                                )
                        )
                );

    }
    @Test
    public void deleteQuestionCommentTest() throws Exception {
        //given
        given(questionCommentService.deleteComment(Mockito.anyLong())).willReturn(1L);

        Long questionId = 1L;
        Long commentId = 1L;
        //when
        ResultActions actions = mockMvc.perform(
                delete("/questions/{question-id}/comments/{comment-id}",questionId,commentId)
                        .contentType(MediaType.APPLICATION_JSON)
        );

        //then
        actions.andExpect(status().isOk())
                .andExpect(jsonPath("data.questionId").value(1L))
                .andDo(document(
                                "delete-questionComment",
                                preprocessRequest(prettyPrint()),
                                preprocessResponse(prettyPrint()),
                                pathParameters(
                                        parameterWithName("question-id").description("질문 식별자"),
                                        parameterWithName("comment-id").description("댓글 식별자")
                                ),
                                responseFields(
                                        List.of(
                                                fieldWithPath("data").type(JsonFieldType.OBJECT).description("결과 데이터"),
                                                fieldWithPath("data.questionId").type(JsonFieldType.NUMBER).description("질문 식별자")
                                        )
                                )
                        )
                );
    }
}