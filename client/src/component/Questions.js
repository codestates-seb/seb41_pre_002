import React from "react";
import styled from "styled-components";
import { Route, Link } from "react-router-dom";

//
const ContentDiv = styled.div``;

const ContentHeader = styled.div`
  display: flex;
  justify-content: space-between;
  padding: 24px 16px;

  h1 {
    font-size: 27px;
    margin: 0px 0px 27px;
    color: black;
    font-weight: 400;
  }
`;

const AskButton = styled.button`
  width: 105px;
  height: 40px;
  font-size: 13px;
  background-color: #0a95ff;
  padding: 10px;
  color: white;
  border: none;
  border-radius: 4px;
  box-sizing: border-box;
  box-shadow: rgba(255, 255, 255, 0.4) 0px 1px;
`;

const ButtonBox = styled.div`
  display: flex;
  justify-content: flex-end;
  margin: 0px 0px 16px;

  button {
    background-color: #ffffff;
    color: #6a737c;
    margin: 0px -1px -1px 0px;
    padding: 10px;
    border: 1px solid;
  }
`;

const QuestionSummary = styled.div`
  position: relative;
  display: flex;
  border-bottom: 1px solid #e3e6e8;
  padding: 16px;
  width: 750px;
  height: 120px;
  /* color: #6A737C; */
  /* &.question-mini-list:last-child {
    border-bottom-width: 0;
  }
  @media (max-width: 980px) {
    flex-direction: column;
  } */
`;

const SummaryStatus = styled.div`
  margin: 0px 16px 4px 0px;
  color: #6a737c;
`;

const SummaryContent = styled.div`
  color: #6a737c;
`;

const Questions = () => {
  return (
    <>
      <ContentDiv>
        {/*question 상단 */}
        <ContentHeader>
          <h1 className="QuestionHeader">Top Questions</h1>
          <AskButton>
            <Link to="/QuestionWrite">Ask Question</Link>
          </AskButton>
        </ContentHeader>
        {/* question 관련 버튼 */}
        <ButtonBox>
          <button>Interesting</button>
          <button>Bountied</button>
          <button>Hot</button> {/*dkjfkldjflk*/}
          <button>Week</button>
          <button>Month</button>
        </ButtonBox>
        {/* question을 요약해서 보여주는 하나의 박스 */}
        <QuestionSummary>
          <SummaryStatus>status</SummaryStatus>
          <SummaryContent>CONTENTS</SummaryContent>
        </QuestionSummary>
      </ContentDiv>
    </>
  );
};

export default Questions;
