package com.codestates.server.question;

import com.codestates.server.answer.mapper.AnswerMapper;
import com.codestates.server.audit.AuditableResponseDto;
import com.codestates.server.comment.dto.QuestionCommentDto;
import com.codestates.server.comment.mapper.AnswerCommentMapper;
import com.codestates.server.comment.mapper.QuestionCommentMapper;
import com.codestates.server.question.controller.QuestionController;
import com.codestates.server.question.dto.QuestionPostDto;
import com.codestates.server.question.dto.QuestionResponseDto;
import com.codestates.server.question.dto.QuestionSuccessResponseDto;
import com.codestates.server.question.entity.Question;
import com.codestates.server.question.mapper.QuestionMapper;
import com.codestates.server.question.service.QuestionService;
import com.codestates.server.tag.dto.TagResponseDto;
import com.codestates.server.tag.service.TagService;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.http.MediaType;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(QuestionController.class)
@MockBean(JpaMetamodelMappingContext.class)
@AutoConfigureRestDocs
public class QuestionControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private Gson gson;
    @MockBean
    private QuestionMapper questionMapper;
    @MockBean
    private AnswerMapper answerMapper;
    @MockBean
    private AnswerCommentMapper answerCommentMapper;
    @MockBean
    private QuestionService questionService;
    @MockBean
    private TagService tagService;
    @MockBean
    private QuestionCommentMapper questionCommentMapper;


    @Test
    void postQuestionTest() throws Exception {
        //given
        QuestionPostDto post = QuestionPostDto
                .builder()
                .memberId(1L)
                .title("title 입니다")
                .content("content 입니다")
                .categories(List.of("태그1", "태그2"))
                .build();

        QuestionSuccessResponseDto response = new QuestionSuccessResponseDto();
        response.setQuestionId(1L);

        given(tagService.findTagsElseCreateTags(Mockito.anyList())).willReturn(new ArrayList<>());
        given(questionMapper.questionPostDtoToQuestion(Mockito.any(QuestionPostDto.class), Mockito.anyList())).willReturn(new Question());
        given(questionService.createQuestion(Mockito.any(Question.class))).willReturn(new Question());
        given(questionMapper.questionToQuestionSuccessResponseDto(Mockito.any(Question.class))).willReturn(response);

        String content = gson.toJson(post);

        //when
        ResultActions actions = mockMvc.perform(
                post("/questions")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content)
        );

        //then
        MvcResult result = actions
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.data.questionId").value(1L))
                .andExpect(jsonPath("$.data.message").value("요청이 성공적으로 처리되었습니다"))
                .andDo(document(
                        "post-question",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()),
                        requestFields(
                                List.of(
                                        fieldWithPath("memberId").type(JsonFieldType.NUMBER).description("회원 식별자"),
                                        fieldWithPath("title").type(JsonFieldType.STRING).description("질문 제목"),
                                        fieldWithPath("content").type(JsonFieldType.STRING).description("질문 내용"),
                                        fieldWithPath("categories").type(JsonFieldType.ARRAY).description("태그")
                                )
                        ),
                        responseFields(
                                List.of(
                                        fieldWithPath("data").type(JsonFieldType.OBJECT).description("결과 데이터"),
                                        fieldWithPath("data.questionId").type(JsonFieldType.NUMBER).description("질문 식별자"),
                                        fieldWithPath("data.message").type(JsonFieldType.STRING).description("결과 메세지")
                                )
                        )
                ))
                .andReturn();

        System.out.println("\nresult = " + result.getResponse().getContentAsString() + "\n");
    }

    @Test
    void patchQuestionTest() throws Exception {

    }

    @Test
    void getQuestionDetailTest() throws Exception {

    }

    @Test
    void getQuestionsTest() throws Exception {
        //given

        // 시간 더미 정보
        AuditableResponseDto auditableResponseDto = new AuditableResponseDto(LocalDateTime.now(), LocalDateTime.now());

        //태그
        TagResponseDto tagResponseDto1 = new TagResponseDto();
        tagResponseDto1.setTagId(1L);
        tagResponseDto1.setCategory("태그1");
        tagResponseDto1.setQuestionsCount(9);

        TagResponseDto tagResponseDto2 = new TagResponseDto();
        tagResponseDto2.setTagId(2L);
        tagResponseDto2.setCategory("태그2");
        tagResponseDto2.setQuestionsCount(9);

        int page = 1;
        int size = 10;
        long totalElements = 9;

        List<Question> questions = new ArrayList<>();
        for (int i = 0; i < totalElements; i++) {
            questions.add(new Question());
        }

        Page<Question> pageQuestions = new PageImpl<>(
                questions, PageRequest.of(page - 1, size, Sort.by("questionId").descending()), 1
        );

        List<QuestionResponseDto> responses = new ArrayList<>();
        for (long i = totalElements; i >= totalElements; i--) {
            // 댓글 생성
            QuestionCommentDto.Response questionCommentResponseDto = new QuestionCommentDto.Response(
                    i, i, 1L, "사용자1", "댓글 더미입니다", auditableResponseDto
            );

            QuestionResponseDto questionResponseDto = QuestionResponseDto
                    .builder()
                    .questionId(i)
                    .title("질문 제목입니다" + i)
                    .content("질문 내용입니다" + i)
                    .auditableResponseDto(auditableResponseDto)
                    .memberId(i)
                    .memberName("사용자" + i)
                    .tagResponseDtos(List.of(tagResponseDto1, tagResponseDto2))
                    .answerCount(3)
                    .voteCount(5)
                    .commentResponseDtos(List.of(questionCommentResponseDto))
                    .build();
            responses.add(questionResponseDto);
        }

        given(questionService.findQuestions(
                Mockito.anyInt(),
                Mockito.anyInt(),
                Mockito.anyString(),
                Mockito.anyString(),
                Mockito.anyString(),
                Mockito.anyString()
        )).willReturn(pageQuestions);

        given(questionMapper.questionsToQuestionResponseDtos(
                Mockito.anyList(),
                Mockito.any(QuestionCommentMapper.class)
        )).willReturn(responses);

        //when
        String keyword = "";
        String filter = "all";
        String sortedBy = "questionId";
        String order = "descending";

        ResultActions actions = mockMvc.perform(
                get("/questions?page={page}&size={size}&keyword={keyword}&filter={filter}&sortedBy={sortedBy}&order={order}",
                        page, size, keyword, filter, sortedBy, order)
                        .accept(MediaType.APPLICATION_JSON)
        );

        //then
        MvcResult result = actions
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").isArray())
                .andExpect(jsonPath("$.pageInfo.page").value(page))
                .andExpect(jsonPath("$.pageInfo.size").value(size))
                .andDo(document(
                        "get-questions",
                        preprocessResponse(prettyPrint()),
                        requestParameters(
                                parameterWithName("page").description("출력할 페이지"),
                                parameterWithName("size").description("페이지당 게시물 수"),
                                parameterWithName("keyword").description("검색어"),
                                parameterWithName("filter").description("필터"),
                                parameterWithName("sortedBy").description("정렬 기준"),
                                parameterWithName("order").description("내림차순 또는 오름차순")
                        ),
                        responseFields(
                                List.of(
                                        fieldWithPath("data").type(JsonFieldType.ARRAY).description("결과 데이터"),
                                        fieldWithPath("data[*].questionId").type(JsonFieldType.NUMBER).description("질문 식별자"),
                                        fieldWithPath("data[*].title").type(JsonFieldType.STRING).description("질문 제목"),
                                        fieldWithPath("data[*].content").type(JsonFieldType.STRING).description("질문 내용"),
                                        fieldWithPath("data[*].auditableResponseDto").type(JsonFieldType.OBJECT).description("질문 시간 정보"),
                                        fieldWithPath("data[*].auditableResponseDto.createdAt").type(JsonFieldType.STRING).description("질문 생성일자"),
                                        fieldWithPath("data[*].auditableResponseDto.modifiedAt").type(JsonFieldType.STRING).description("질문 수정일자"),
                                        fieldWithPath("data[*].memberId").type(JsonFieldType.NUMBER).description("질문 작성자 식별자"),
                                        fieldWithPath("data[*].memberName").type(JsonFieldType.STRING).description("질문 작성자 이름"),
                                        fieldWithPath("data[*].tagResponseDtos").type(JsonFieldType.ARRAY).description("사용한 태그들 정보"),
                                        fieldWithPath("data[*].tagResponseDtos[*].tagId").type(JsonFieldType.NUMBER).description("태그 식별자"),
                                        fieldWithPath("data[*].tagResponseDtos[*].category").type(JsonFieldType.STRING).description("태그 이름"),
                                        fieldWithPath("data[*].tagResponseDtos[*].questionsCount").type(JsonFieldType.NUMBER).description("태그를 사용한 질문 수 (미구현)"),
                                        fieldWithPath("data[*].answerCount").type(JsonFieldType.NUMBER).description("질문에 달린 답변 수"),
                                        fieldWithPath("data[*].voteCount").type(JsonFieldType.NUMBER).description("질문에 달린 추천 수"),
                                        fieldWithPath("data[*].commentResponseDtos").type(JsonFieldType.ARRAY).description("질문에 달린 댓글들 정보"),
                                        fieldWithPath("data[*].commentResponseDtos[*].commentId").type(JsonFieldType.NUMBER).description("댓글 식별자"),
                                        fieldWithPath("data[*].commentResponseDtos[*].questionId").type(JsonFieldType.NUMBER).description("댓글이 달린 질문의 식별자"),
                                        fieldWithPath("data[*].commentResponseDtos[*].memberId").type(JsonFieldType.NUMBER).description("댓글을 작성한 회원의 식별자"),
                                        fieldWithPath("data[*].commentResponseDtos[*].memberName").type(JsonFieldType.STRING).description("댓글을 작성한 회원의 이름"),
                                        fieldWithPath("data[*].commentResponseDtos[*].content").type(JsonFieldType.STRING).description("댓글 내용"),
                                        fieldWithPath("data[*].commentResponseDtos[*].auditableResponseDto").type(JsonFieldType.OBJECT).description("댓글을 작성한 시간 정보"),
                                        fieldWithPath("data[*].commentResponseDtos[*].auditableResponseDto.createdAt").type(JsonFieldType.STRING).description("댓글을 작성한 시간"),
                                        fieldWithPath("data[*].commentResponseDtos[*].auditableResponseDto.modifiedAt").type(JsonFieldType.STRING).description("댓글을 수정한 시간"),
                                        fieldWithPath("pageInfo").type(JsonFieldType.OBJECT).description("페이지 정보"),
                                        fieldWithPath("pageInfo.page").type(JsonFieldType.NUMBER).description("현재 페이지"),
                                        fieldWithPath("pageInfo.size").type(JsonFieldType.NUMBER).description("한 페이지에 노출할 데이터 갯수"),
                                        fieldWithPath("pageInfo.totalElements").type(JsonFieldType.NUMBER).description("총 데이터 갯수"),
                                        fieldWithPath("pageInfo.totalPages").type(JsonFieldType.NUMBER).description("총 페이지 갯수")
                                )
                        )

                ))
                .andReturn();

        System.out.println("\nresult = " + result.getResponse().getContentAsString() + "\n");
    }
}
