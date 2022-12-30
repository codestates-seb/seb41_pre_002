import React from "react";
import styled from "styled-components";
import Header from "../component/header";
import Footer from "../component/footer";
import Nav from "../component/nav";

import Question from "../component/DetailsQustion";

const Qustionpagediv = styled.div`
  width: 100vw;
  height: auto;
  display: flex;
  flex-direction: row;
`;

function Quesetionread() {
  return (
    <>
      <Header />
      <Qustionpagediv>
        <Nav />
        <Question />
      </Qustionpagediv>
      <Footer />
    </>
  );
}

export default Quesetionread;
