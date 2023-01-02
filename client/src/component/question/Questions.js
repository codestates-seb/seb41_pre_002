import React from 'react';
import styled from 'styled-components';
import { Link } from 'react-router-dom';
import QuestionList from './questionlist';
import { useState, useEffect } from 'react';
import axios from 'axios';

const ContentDiv = styled.div`
  width: 1000px;
  min-width: 100px;
  padding: 24px 16px 0px 30px;
`;

const ContentHeader = styled.div`
  display: flex;
  justify-content: space-between;

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
  border-color: var(--_bu-outlined-bc-selected);
  border-radius: 4px;

  .Btn {
    /* display: flex; */
    height: 40px;
    width: 80px;
    background-color: var(--_bu-outlined-bg);
    border-color: var(--_bu-outlined-bc-selected);
    color: black;
    font-size: 13px;
    font-weight: 400;
    border: 1px solid rgb(214, 217, 220);
    &:active {
      border-color: rgb(227, 230, 232);
      background-color: rgb(227, 230, 232);
      color: rgb(59, 64, 60);
    }
    &:hover {
      background-color: rgb(242, 244, 245);
    }
  }
`;

const Questions = () => {
  const [questionData, setQuestionData] = useState([]);

  useEffect(() => {
    axios
      .get('/questions', {})
      .then((response) => {
        setQuestionData(response.data);
        console.log(response.data); // data& pageinfo
      })
      .catch((error) => {
        console.log(error);
      });
  }, []);

  return (
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
        <button className="Btn">Interesting</button>
        <button className="Btn">Bountied</button>
        <button className="Btn">Hot</button>
        <button className="Btn">Week</button>
        <button className="Btn">Month</button>
      </ButtonBox>
      {/* question을 요약해서 보여주는 하나의 박스 */}

      {questionData && <QuestionList questionData={questionData} />}
      {/* {console.log(questionData)} */}
    </ContentDiv>
  );
};

export default Questions;
