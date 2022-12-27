import React from "react";
import Header from "../component/header";
import Nav from "../component/nav";
import Users from "../component/user/Users";
import Footer from "../component/footer";
import styled from "styled-components";


const ContentDiv = styled.div`
  display: flex;
  width: 100vw; // 전체넓이 지정함
  background-color: beige;
`;



const UserPage = () => {
  return (
    <>
      <Header />
      <ContentDiv>
        <Nav />
        <Users />
      </ContentDiv>
      <Footer />
    </>
  );
};

export default UserPage;
