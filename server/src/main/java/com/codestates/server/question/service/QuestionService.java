package com.codestates.server.question.service;

import com.codestates.server.exception.BusinessLogicException;
import com.codestates.server.exception.ExceptionCode;
import com.codestates.server.member.service.MemberService;
import com.codestates.server.question.entity.Question;
import com.codestates.server.question.repository.QuestionRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;
    private final MemberService memberService;

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

        // 질문이 존재하는지 확인, 수정및삭제 가능 여부를 확인
        canModifyOrDelete(findVerifiedQuestion(question.getQuestionId()));

        question.getQuestionTags().stream().forEach(questionTag -> System.out.println(questionTag.getTag().getCategory()));

        return questionRepository.save(question);
    }

    public Question findQuestion(long questionId) {
        return findVerifiedQuestion(questionId);
    }

    public void deleteQuestion(long questionId) {
        //Todo: 넘어온 멤버아이디와 질문의 멤버아이디가 동일한지 여부 확인

        // 질문이 존재하는지 확인, 수정및삭제 가능 여부를 확인
        canModifyOrDelete(findVerifiedQuestion(questionId));

        // 삭제
        questionRepository.deleteById(questionId);
    }

    private void canModifyOrDelete(Question findQuestion) {
        // 답변이나 댓글이 존재할 경우 수정 또는 삭제할 수 없음
        if (findQuestion.getAnswers().size() > 0 || findQuestion.getComments().size() > 0) {
            throw new BusinessLogicException(ExceptionCode.REQUEST_FORBIDDEN);
        }
    }

    public Page<Question> findQuestions(int page, int size, String keyword, String filter, String sortedBy, String order) {
        // Todo: 필터 구현해야됨
        /**
         * page
         * size
         * keyword - 검색어
         * filter - 모두(기본값=all), 답변없음(noAnswer), 답변있음(answer)
         * sortedBy - questionId(기본값), 추천순, 답변많은순 (규격 외에 questionId로 정렬됨)
         * order - 내림차순(기본값) = descending, 오름차순 = ascending (규격 외에 오름차순 정렬됨)
         * */

        System.out.println("파인드퀘스쳔 메서드 시작===================");

        // 필요한 변수들 선언
        Page<Question> questions;
        Pageable pageable;

        // 정렬기준 설정 (sortedBy)
        if (!sortedBy.equals("questionId") && !sortedBy.equals("voteCount") && !sortedBy.equals("answerCount")) {
            sortedBy = "questionId"; // 기준 외 입력 시
        }

        // 차순 설정 (order)
        if (order.equals("descending")) {
            pageable = PageRequest.of(page, size, Sort.by(sortedBy).descending());
        } else {
            pageable = PageRequest.of(page, size, Sort.by(sortedBy).ascending()); // 기준 외 입력 시
        }

        // 질문 내용 검색
        if (keyword.length() == 0) { // 검색 내용이 없을 경우
            questions = questionRepository.findAll(pageable);
        } else { // 검색 내용이 있을 경우
            questions = questionRepository.findAllByTitleContainsOrContentContains(keyword, keyword, pageable);
        }
        System.out.println("파인드퀘스쳔 메서드 시작===================");
        return questions;
    }

    public Question findVerifiedQuestion(long questionId) {
        Optional<Question> optionalQuestion = questionRepository.findById(questionId);
        Question findQuestion = optionalQuestion.orElseThrow(() -> new BusinessLogicException(ExceptionCode.QUESTION_NOT_FOUND));
        return findQuestion;
    }

}
