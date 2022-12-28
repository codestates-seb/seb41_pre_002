import React, { useEffect, useState } from "react";
import styled from "styled-components";
import Header from "../component/header";
import Footer from "../component/footer";
import Nav from "../component/nav";
import Questions from "../component/question/Questions";
import axios from "axios";

const Maindiv = styled.div`
  width: 100vw;
  height: auto;
  display: flex;
  flex-direction: row;
`;

function MainPage() {
  const [questions, setQuestions] = useState([]);

  useEffect(() => {
    axios
      .get("/questions", {
        
      })
      .then((response) => {
        console.log(response.data.data); //정상 통신 후 응답된 메시지 출력
      })
      .catch((error) => {
        console.log(error);
        //오류발생시 실행
      })
      .then((response) => {
        setQuestions(response.data.data); //정상 통신 후 응답된 메시지 출력
      });
  }, []);

  return (
    <>
      <Header />
      <Maindiv>
        <Nav />
        <Questions questions={questions} color="black"/>
      </Maindiv>
      <Footer />
    </>
  );
}

export default MainPage;
