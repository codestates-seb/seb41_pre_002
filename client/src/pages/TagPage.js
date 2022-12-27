import React from "react";
import Header from "../component/header";
import Nav from "../component/nav";
import Footer from "../component/footer";
import Tag from "../component/tag/Tag";
import styled from "styled-components";


const ContentDiv = styled.div`
  display: flex;
  background-color: beige;
  height: 100vh; 
  width: 90vw; // 전체 넓이 지정함
  /* height: auto; */
  /* flex-direction: row; */
`;



const TagPage = () => {
  return (
    <>
      <Header />
      <ContentDiv>
        <Nav />
        <Tag />
      </ContentDiv>
      <Footer />
    </>
  );
};

export default TagPage;
