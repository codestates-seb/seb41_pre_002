package com.codestates.server.answer.service;

import com.codestates.server.answer.entity.Answer;
import com.codestates.server.answer.repository.AnswerRepository;
import com.codestates.server.exception.BusinessLogicException;
import com.codestates.server.exception.ExceptionCode;
import com.codestates.server.member.entity.Member;
import com.codestates.server.member.repository.MemberRepository;
import com.codestates.server.question.entity.Question;
import com.codestates.server.question.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class AnswerService {

    private final AnswerRepository answerRepository;
    private final MemberRepository memberRepository;
    private final QuestionRepository questionRepository;

    // 답글 생성.
    @Transactional
    public Answer createAnswer(Long questionId,Answer answer) {

        Question findQuestion = verifyQuestion(questionId);
        Member findMember = verifyMember(findQuestion.getMember().getMemberId());

        answer.setMember(findMember);
        answer.setQuestion(findQuestion);

        answerRepository.save(answer);

        // 답변 갯수 반영
        findQuestion.calAnswerCount();
        questionRepository.save(findQuestion);
        return answer;
    }
    // 답글 조회
    public Answer findAnswer(Long answerId) {
        return verifyAnswer(answerId);
    }
    // 답글 전체 조회
    public Page<Answer> findAnswers(int page, int size) {
        return answerRepository.findAll(PageRequest.of(page,size,
                Sort.by("answerId").descending()));
    }

    // 답글 수정

    @Transactional
    public Answer updateAnswer(Long answerId, Answer answer) {
        Answer findAnswer = verifyAnswer(answerId);
        canModifyOrDelete(findAnswer);
        Optional.ofNullable(answer.getContent())
                .ifPresent(content -> findAnswer.setContent(content));

        return answerRepository.save(findAnswer);
    }
    // 답글 삭제
    @Transactional
    public void deleteAnswer(Long answerId) {
        Answer findAnswer = verifyAnswer(answerId);
        canModifyOrDelete(findAnswer);
        answerRepository.deleteById(answerId);

        // 답변 갯수 반영
        Question findQuestion = findAnswer.getQuestion();
        findQuestion.calAnswerCount();
        System.out.println("ㅁ낭만ㅇ"+findQuestion.getAnswers().size());
        questionRepository.save(findQuestion);
    }

    // 멤버 존재 확인
    public Member verifyMember(Long memberId) {
        Optional<Member> optionalMember = memberRepository.findById(memberId);
        Member member = optionalMember.orElseThrow(
                () -> new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND)
        );
        return member;
    }
    // 질문 존재 확인
    public Question verifyQuestion(Long questionId){
        Optional<Question> optionalQuestion = questionRepository.findByQuestionId(questionId);
        Question question = optionalQuestion.orElseThrow(
                () -> new BusinessLogicException(ExceptionCode.QUESTION_NOT_FOUND)
        );
        return question;
    }
    // 답글 존재 확인
    public Answer verifyAnswer(Long answerId) {
        Optional<Answer> optionalAnswer = answerRepository.findById(answerId);
        Answer answer = optionalAnswer.orElseThrow(
                () -> new BusinessLogicException(ExceptionCode.ANSWER_NOT_FOUND)
        );
        return answer;
    }
    // 댓글 삭제,수정 검증
    private void canModifyOrDelete(Answer findAnswer) {
        // 댓글이 존재할 경우 수정 또는 삭제할 수 없음
        if (findAnswer.getAnswerComments().size() > 0) {
            throw new BusinessLogicException(ExceptionCode.REQUEST_FORBIDDEN);
        }
    }
}


