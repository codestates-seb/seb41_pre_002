import React from 'react'
import styled from 'styled-components';
import QuestionItem from './QuestionItem';

const QusetionListDiv = styled.div`
  /* width: 800px; */
`
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
  return (
    <QusetionListDiv>
    <QuestionLists>
      <QuestionItem/>
      {/* <QuestionItem/>
      <QuestionItem/>
      <QuestionItem/>
      <QuestionItem/>
      <QuestionItem/> */}
    </QuestionLists>
    </QusetionListDiv>
  )
}

export default QuestionList;