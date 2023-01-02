

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
  color: #ffffff;
  border: none;
  border-radius: 4px;
  box-sizing: border-box;
  box-shadow: rgba(255, 255, 255, 0.4) 0px 1px;
  &:hover {
    color: #ffffff;
    background-color: var(--blue-700);
  }
`;

const StyleLink = styled(Link)`
  color: #ffffff;
  &:hover {
    color: #ffffff;
    background-color: var(--blue-700);
  }
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
  .sort {
    width: 100%;
    display: flex;
    justify-content: flex-end;
    float: right;
    align-items: center;
    min-width: 100px;
    margin-bottom: 15px;

    @media screen and (max-width: 640px) {
      font-size: 15.4px;
      flex-direction: column !important;
      align-items: flex-start;
      gap: 10px;
      margin-bottom: 10px;
    }
    > .question-sort {
      margin-bottom: 12px;
      > button {
        height: 40px;
        width: auto;
        font-size: 13px;
        border: 1px solid hsl(210, 8%, 55%);
        padding: 8px 10px;
        color: hsl(210, 8%, 45%);
        background-color: var(--_bu-outlined-bg);
        @media screen and (max-width: 640px) {
          height: 35.44px;
          padding-left: 0.4em;
          padding-right: 0.4em;
          flex-direction: column-reverse;
        }
        cursor: pointer;
        :first-child {
          border-radius: 3px;
          border-top-right-radius: 0;
          border-bottom-right-radius: 0;
        }
        :last-child {
          border-radius: 3px;
          border-top-left-radius: 0;
          border-bottom-left-radius: 0;
        }
        :not(:last-child) {
          border-right: none;
        }
        :hover {
          background-color: hsl(210, 8%, 97.5%);
        }
        &.is-selected {
          background-color: hsl(210, 8%, 90%);
          color: hsl(210, 8%, 25%);
          border: 1px solid hsl(210, 8%, 55%);
          :not(:last-child) {
            border-right: none;
          }
        }
      }
    }
  }
`;

const Questions = () => {
  const [selected, setSelected] = useState("Interesting");

  const sortClick = (e) => {
    switch (e.target.value) {
      case "Interesting":
        setSelected("Interesting");
        break;
      case "Bountied":
        setSelected("Bountied");
        break;
      case "Hot":
        setSelected("Hot");
        break;
      case "Week":
        setSelected("Week");
        break;
      case "Month":
        setSelected("Month");
        break;
      default:
        break;
    }
  };

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
          <StyleLink to="/QuestionWrite">Ask Question</StyleLink>
        </AskButton>
      </ContentHeader>
      {/* question 관련 버튼 */}
      <ButtonBox>
        <div className="sort">
          <div className="question-sort">
            <button
              onClick={sortClick}
              className={selected === "Interesting" ? "is-selected" : ""}
              value={"Interesting"}
            >
              Interesting
            </button>
            <button
              onClick={sortClick}
              className={selected === "Bountied" ? "is-selected" : ""}
              value={"Bountied"}
            >
              Bountied
            </button>
            <button
              onClick={sortClick}
              className={selected === "Hot" ? "is-selected" : ""}
              value={"Hot"}
            >
              Hot
            </button>
            <button
              onClick={sortClick}
              className={selected === "Week" ? "is-selected" : ""}
              value={"Week"}
            >
              Week
            </button>
            <button
              onClick={sortClick}
              className={selected === "Month" ? "is-selected" : ""}
              value={"Month"}
            >
              Month
            </button>
          </div>
        </div>
      </ButtonBox>
      {/* question을 요약해서 보여주는 하나의 박스 */}

      {questionData && <QuestionList questionData={questionData} />}
      {/* {console.log(questionData)} */}
    </ContentDiv>
  );
};

export default Questions;
