//package com.codestates.server.vote;
//
//import com.codestates.server.vote.controller.VoteController;
//import com.codestates.server.vote.dto.VoteRequestDto;
//import com.codestates.server.vote.service.VoteService;
//import com.google.gson.Gson;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
//import org.springframework.http.MediaType;
//import org.springframework.restdocs.payload.JsonFieldType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.ResultActions;
//
//import java.util.List;
//
//import static org.mockito.Mockito.doNothing;
//import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
//import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
//import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessRequest;
//import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
//import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
//import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
//import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
//import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@WebMvcTest(VoteController.class)
//@MockBean(JpaMetamodelMappingContext.class)
//@AutoConfigureRestDocs
//public class VoteControllerTest {
//    @Autowired
//    private MockMvc mockMvc;
//    @Autowired
//    private Gson gson;
//    @MockBean
//    private VoteService voteService;
//
//    @Test
//    void postQuestionVote() throws Exception {
//        //given
//        VoteRequestDto post = new VoteRequestDto();
//        post.setMemberId(1L);
//        post.setScore(1);
//
//        doNothing().when(voteService).doVote(Mockito.anyChar(), Mockito.anyInt(), Mockito.anyLong(), Mockito.anyLong());
//
//        String content = gson.toJson(post);
//
//        //when
//        ResultActions actions = mockMvc.perform(
//                post("/votes/questions/{question-id}", 1L)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(content)
//        );
//
//        //then
//        MvcResult result = actions
//                .andExpect(status().isOk())
//                .andDo(document(
//                        "post-questionVote",
//                        preprocessRequest(prettyPrint()),
//                        pathParameters(parameterWithName("question-id").description("추천 대상이 되는 질문의 식별자")),
//                        requestFields(
//                                List.of(
//                                        fieldWithPath("memberId").type(JsonFieldType.NUMBER).description("회원 식별자"),
//                                        fieldWithPath("score").type(JsonFieldType.NUMBER).description("요청 점수 : 추천 = 1, 비추천 = -1")
//                                )
//                        )
//                ))
//                .andReturn();
//
//        System.out.println("\nresult = " + result.getResponse().getContentAsString() + "\n");
//    }
//
//    @Test
//    void postAnswerVote() throws Exception {
//        //given
//        VoteRequestDto post = new VoteRequestDto();
//        post.setMemberId(1L);
//        post.setScore(1);
//
//        doNothing().when(voteService).doVote(Mockito.anyChar(), Mockito.anyInt(), Mockito.anyLong(), Mockito.anyLong());
//
//        String content = gson.toJson(post);
//
//        //when
//        ResultActions actions = mockMvc.perform(
//                post("/votes/answers/{answer-id}", 1L)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(content)
//        );
//
//        //then
//        MvcResult result = actions
//                .andExpect(status().isOk())
//                .andDo(document(
//                        "post-answerVote",
//                        preprocessRequest(prettyPrint()),
//                        pathParameters(parameterWithName("answer-id").description("추천 대상이 되는 답변의 식별자")),
//                        requestFields(
//                                List.of(
//                                        fieldWithPath("memberId").type(JsonFieldType.NUMBER).description("회원 식별자"),
//                                        fieldWithPath("score").type(JsonFieldType.NUMBER).description("요청 점수 : 추천 = 1, 비추천 = -1")
//                                )
//                        )
//                ))
//                .andReturn();
//
//        System.out.println("\nresult = " + result.getResponse().getContentAsString() + "\n");
//    }
//}
//
