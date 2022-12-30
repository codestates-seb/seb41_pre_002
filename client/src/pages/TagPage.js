import React, { useState, useEffect } from "react";
import Header from "../component/header";
import Nav from "../component/nav";
import Footer from "../component/footer";
import Tag from "../component/tag/Tag.js";
import styled from "styled-components";
import axios from "axios";

const ContentDiv = styled.div`
  display: flex;
  /* background-color: beige; */
  height: auto;
  width: 100vw; // 전체 넓이 지정함
`;

const TagPage = () => {
  const [tagsAll, setTagsAll] = useState([]);
  const [tagsName, setTagsName] = useState([]);
  const [tagsNew, setTagsNew] = useState([]);

  useEffect(() => {
    axios
      .all([
        axios.get("/tags"),
        axios.get("/tags?page=1&size=10&keyword=&tab=name"),
        axios.get("/tags?page=1&size=10&keyword=&tab=new"),
      ])
      .then(
        axios.spread((response1, response2, response3) => {
          setTagsAll(response1.data.data);
          setTagsName(response2.data.data);
          setTagsNew(response3.data.data);
          console.log(response1.data.data);
          console.log(response2.data.data);
          console.log(response3.data.data);
        })
      )
      .catch((error) => {
        console.log(error);
      });
  }, []);

  return (
    <>
      <Header />
      <ContentDiv>
        <Nav />
        <Tag tagsAll={tagsAll} tagsName={tagsName} tagsNew={tagsNew}/>
      </ContentDiv>
      <Footer />
    </>
  );
};

export default TagPage;
