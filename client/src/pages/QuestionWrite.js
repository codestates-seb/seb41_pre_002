import React from 'react';
import Header from '../component/header';
import Footer from '../component/footer';
import styled from 'styled-components';
import Notice from '../component/notice';
import QuestionTitle from '../component/questionTitle';
import QuestionContent from '../component/questionContent';
import QuestionTag from '../component/questionTag';

const Container = styled.div`
  padding: 30px 100px;
  background-color: #f8f9f9;
`;

const Submit = styled.div`
  display: flex;
  button {
    margin-right: 10px;
  }
`;

function QuestionWrite() {
  return (
    <>
      <Header />
      <Container>
        <Notice />
        <QuestionTitle />
        <QuestionContent />
        <QuestionTag />
        <Submit>
          <button class="s-btn s-btn__primary" type="button">
            Post your question
          </button>
          <button class="s-btn s-btn__danger" type="button">
            Discard draft
          </button>
        </Submit>
      </Container>
      <Footer />
    </>
  );
}

export default QuestionWrite;
