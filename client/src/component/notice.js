import React from 'react';
import styled from 'styled-components';

const StyledDiv = styled.div`
  height: 130px;
  background-image: url('https://cdn.sstatic.net/Img/ask/background.svg?v=2e9a8205b368');
  background-repeat: no-repeat;
  background-position: right bottom;
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  h1 {
    font-weight: 600;
    font-size: 27px;
    margin: 24px 0 27px;
    line-height: 1.3;
    color: black;
  }
`;

const Container = styled.div`
  display: flex;
  margin-bottom: 20px;
  h2,
  p,
  h5,
  li {
    text-align: left;
  }
`;

function Notice() {
  return (
    <>
      <StyledDiv>
        <h1>Ask a public question</h1>
      </StyledDiv>
      <Container>
        <div className="s-notice s-notice__info w75" role="status">
          <h2>Writing a good question</h2>
          <p>You’re ready to ask a programming-related question and this form will help guide you through the process.</p>
          <p>Looking to ask a non-programming question? See the topics here to find a relevant site.</p>
          <h5>step</h5>
          <ul>
            <li>Summarize your problem in a one-line title.</li>
            <li>Describe your problem in more detail.</li>
            <li>Describe what you tried and what you expected to happen.</li>
            <li>Add “tags” which help surface your question to members of the community.</li>
            <li>Review your question and post it to the site.</li>
          </ul>
        </div>
      </Container>
    </>
  );
}

export default Notice;
