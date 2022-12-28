import React from "react";
import styled from "styled-components";
import { Link } from "react-router-dom";

const QuestionItemdiv = styled.div`
  display: flex;
  flex-direction: column;
  /* border-bottom: 1px solid #e3e6e8; */
`;

const QuestionItems = styled.div`
  display: flex;
  border-bottom: 1px solid #e3e6e8;
  padding: 30px;
  height: 120px;
`;

const SummaryStatus = styled.div`
  display: flex;
  justify-content: flex-end;
  margin: 0px 30px 4px 0px;
  font-size: 13px;
  color: #6a737c;
`;

const SummaryContent = styled.div`
  width: 1000px;
  font-size: 17px;
  color: blue;
  align-self: start;
  .a {
    text-align: left;
  }
`;

const SummaryMeta = styled.div`
  display: flex;
  justify-content: space-between;
  color: black;
`;
const TagDiV = styled.div`
  display: flex;
  flex-direction: column;
  .tag-button {
    display: flex;
    font-size: 13px;
    width: 60px;
    //버튼 사이즈를 버튼 글자의 크기에 따라 조절이 되게끔 구혐
    color: var(--powder-700);
    cursor: pointer;
    background-color: var(--powder-100);
    border-radius: 3px;
    padding: 4.8px 6px;
    border: 1px transparent;
    margin: 2px 6px 2px 0px;
  }
`;

const QuestionItem = () => {
  return (
    <QuestionItemdiv>
      <QuestionItems>
        <SummaryStatus>0 vote 0 answer</SummaryStatus>

        <SummaryContent>
          <Link to="/QuesetionRead">질문상세보기로 연결해주세요</Link>
          <SummaryMeta>
            <TagDiV>
              <button className="tag-button">javascript</button>
            </TagDiV>
            유저이미지 유저정보 div
          </SummaryMeta>
        </SummaryContent>
        
      </QuestionItems>
    </QuestionItemdiv>
  );
};

export default QuestionItem;
