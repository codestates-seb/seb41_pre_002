import React, {useState , useEffect} from "react";
import Header from "../component/header";
import Nav from "../component/nav";
import Footer from "../component/footer";
import Tag from "../component/tag/Tag";
import styled from "styled-components";
import axios from "axios";


const ContentDiv = styled.div`
  display: flex;
  background-color: beige;
  height: auto; 
  width: 90vw; // 전체 넓이 지정함
  /* height: auto; */
  /* flex-direction: row; */
`;



const TagPage = () => {

  const [tagData, setTagData] = useState([]);

  useEffect(() => {
    axios
      .get('/tags', {})
      .then((response) => {
        // const questionData = response.data.data;
        setTagData(response.data.data);
        // console.log(data); //전체데이터
        console.log(response.data.data); // data& pageinfo
        // console.log(response.data.data[0]); // questionid 7의 정보
        // console.log(response.data.pageInfo);
        // console.log(questionData); // pageinfo 관련
      })
      .catch((error) => {
        console.log(error);
        //오류발생시 실행
      });
  }, []);
  return (
    <>
      <Header />
      <ContentDiv>
        <Nav />
        <Tag tagData ={tagData} />
      </ContentDiv>
      <Footer />
    </>
  );
};

export default TagPage;
