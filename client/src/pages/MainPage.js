import React from "react";
import styled from "styled-components";
import Header from "../component/header";
import Footer from "../component/footer";
import Questions from "../component/question/Questions";
import Nav from "../component/nav";
import { useState, useEffect } from "react";
import axios from "axios";

const Maindiv = styled.div`
  width: 100vw;
  height: auto;
  display: flex;
  flex-direction: row;
`;

function MainPage() {
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
    <>
      <Header />
      <Maindiv>
        <Nav />
        <Questions title={questions.title} color="black" />
      </Maindiv>
      <Footer />
    </>
  );
}

export default MainPage;
