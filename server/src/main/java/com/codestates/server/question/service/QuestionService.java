package com.codestates.server.question.service;

import com.codestates.server.exception.BusinessLogicException;
import com.codestates.server.exception.ExceptionCode;
import com.codestates.server.member.service.MemberService;
import com.codestates.server.question.entity.Question;
import com.codestates.server.question.repository.QuestionRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuestionService {
    private QuestionRepository questionRepository;
    private MemberService memberService;

    public QuestionService(QuestionRepository questionRepository, MemberService memberService) {
        this.questionRepository = questionRepository;
        this.memberService = memberService;
    }

    public Question createQuestion(Question question) {

        //멤버 유효성검증
        memberService.findVerifiedMember(question.getMember().getMemberId());

        // 생각해볼것 : 같은 제목의 질문을 올리면 어떻게 되는가 ?

        return questionRepository.save(question);
    }

    public Question updateQuestion(Question question) {
        // 하나만 수정하는 식으로 요청하는 것이 아니라 굳이 옵셔널 써야하나 ??

        //멤버 유효성검증 //Todo: 넘어온 멤버아이디와 질문의 멤버아이디가 동일한지 여부 확인
        memberService.findVerifiedMember(question.getMember().getMemberId());

        // 질문이 존재하는지 확인
        findVerifiedQuestion(question.getQuestionId());

        // 수정 가능 여부를 확인
        canModifyOrDelete(question.getQuestionId());

        question.getQuestionTags().stream().forEach(questionTag -> System.out.println(questionTag.getTag().getCategory()));

        return questionRepository.save(question);
    }

    public Question findQuestion(long questionId) {
        return findVerifiedQuestion(questionId);
    }

    public void deleteQuestion(long questionId) {
        //Todo: 넘어온 멤버아이디와 질문의 멤버아이디가 동일한지 여부 확인

        // 질문이 존재하는지 확인
        findVerifiedQuestion(questionId);
        // 수정및삭제 가능 여부를 확인
        canModifyOrDelete(questionId);
        // 삭제
        questionRepository.deleteById(questionId);
    }

    private void canModifyOrDelete(long questionId) {
        Question findQuestion = questionRepository.findById(questionId).get();

        // 답변이나 댓글이 존재할 경우 수정 또는 삭제할 수 없음           //Todo: 댓글 기능 추가 되면 확인 후 주석 해제
        if (findQuestion.getAnswers().size() > 0 /*|| findQuestion.getComment().size() > 0*/) {
            throw new BusinessLogicException(ExceptionCode.REQUEST_FORBIDDEN);
        }
    }

    public Page<Question> findQuestions(int page, int size) {
        return questionRepository.findAll(PageRequest.of(
                page, size, Sort.by("questionId").descending()
        ));
    }

    private Question findVerifiedQuestion(long questionId) {
        Optional<Question> optionalQuestion = questionRepository.findById(questionId);
        Question findQuestion = optionalQuestion.orElseThrow(() -> new BusinessLogicException(ExceptionCode.QUESTION_NOT_FOUND));
        return findQuestion;
    }

}
