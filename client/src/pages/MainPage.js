import React from "react";
import Header from "./component/header.js";
import Nav from "./component/nav.js";
import Question from "./component/Questions.js";
import Footer from "./component/footer.js";
import styled from "styled-components";

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
        <Question />
      </Maindiv>
      <Footer />
    </>
  );
}

export default MainPage;
