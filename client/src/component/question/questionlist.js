import React from "react";
import styled from "styled-components";
import { useState, useEffect } from "react";
import QuestionItem from "./QuestionItem";
import axios from "axios";
const QusetionListDiv = styled.div`
  /* width: 800px; */
`;
const QuestionLists = styled.div`
  /* position: relative; */
  /* display: flex; */
  /* border-bottom: 1px solid #e3e6e8; */

  /* color: #6A737C; */
  /* &.question-mini-list:last-child {
    border-bottom-width: 0;
  }
  @media (max-width: 980px) {
    flex-direction: column;
  } */
`;

const QuestionList = () => {
  const [questions, setQuestions] = useState("");

  useEffect(() => {
    axios
      .get("/questions/1", {})
      .then((response) => {
        console.log(response.data.data.questionResponseDto.title); //정상 통신 후 응답된 메시지 출력
        setQuestions(response.data.data.questionResponseDto); //정상 통신 후 응답된 메시지 출력
      })
      .catch((error) => {
        console.log(error);
        //오류발생시 실행
      });
  }, []);
  return (
    <QusetionListDiv>
      <QuestionLists>
        <QuestionItem title={questions.title} />
        {/* <QuestionItem/>
      <QuestionItem/>
      <QuestionItem/>
      <QuestionItem/>
      <QuestionItem/> */}
      </QuestionLists>
    </QusetionListDiv>
  );
};

export default QuestionList;
