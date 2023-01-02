import React from "react";
import styled from "styled-components";
import Notice from "../component/notice";
import QuestionTitle from "../component/questionTitle";
import QuestionContent from "../component/questionContent";
import QuestionTag from "../component/questionTag";
import axios from "axios";
import { useState } from "react";

const Container = styled.form`
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
  const [title, setTitle] = useState("");
  const [content, setContent] = useState("");
  const [tag, setTag] = useState([]);

  const titleHandler = (e) => {
    setTitle(e.target.value);
  };

  const contentHandler = (e) => {
    setContent(e.target.value);
  };

  const tagHandler = (e) => {
    setTag([e.target.value]);
  };

  const addQuestion = () => {
    axios
      .post("/questions", {
        memberId: 4,
        title: title,
        content: content,
        categories: tag,
      })

      .then((res) => {
        console.log(res.data.data);
      });
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    addQuestion();
    window.location.replace("/QuestionWrite");
  };

  return (
    <>
      <Container onSubmit={handleSubmit}>
        <Notice />
        <QuestionTitle titleHandler={titleHandler} title={title} />
        <QuestionContent contentHandler={contentHandler} content={content} />
        <QuestionTag tagHandler={tagHandler} tag={tag} />
        <Submit>
          <button class="s-btn s-btn__primary" type="submit">
            Post your question
          </button>
          <button class="s-btn s-btn__danger" type="button">
            Discard draft
          </button>
        </Submit>
      </Container>
    </>
  );
}

export default QuestionWrite;
