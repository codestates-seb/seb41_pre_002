import React from "react";
import Header from "../component/header";
import Nav from "../component/nav";
import Footer from "../component/footer";
import Tag from "../component/tag/Tag";
import styled from "styled-components";

const ContentDiv = styled.div`
  display: flex;
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
