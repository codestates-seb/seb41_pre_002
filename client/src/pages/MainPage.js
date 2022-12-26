import React from "react";
import styled from "styled-components";
import Header from "../component/header";
import Footer from "../component/footer";
import Nav from "../component/nav";
import Questions from "../component/question/Questions";

const Maindiv = styled.div`
  width: 100vw;
  height: auto;
  display: flex;
  flex-direction: row;
`;

function MainPage() {
  return (
    <>
      <Header />
      <Maindiv>
        <Nav />
        <Questions />
      </Maindiv>
      <Footer />
    </>
  );
}

export default MainPage;
