import React from "react";
import styled from "styled-components";
import Header from "../component/header";
import Footer from "../component/footer";
import Nav from "../component/nav";
import Profile from "../component/Profile";

const Mypagediv = styled.div`
  width: 100vw;
  height: auto;
  display: flex;
  flex-direction: row;
`;

function MyPage() {
  return (
    <>
      <Header />
      <Mypagediv>
        <Nav />
        <Profile />
      </Mypagediv>
      <Footer />
    </>
  );
}

export default MyPage;
