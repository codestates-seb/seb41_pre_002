import React, { useEffect, useState } from "react";
import styled from "styled-components";
import Header from "../component/header";
import Footer from "../component/footer";
import Nav from "../component/nav";
import QuestionsTag from "../component/questionTag/QuestionsTag";
import axios from "axios";
// import QuestionList from '../component/question/questionlist';



const Maindiv = styled.div`
  width: 100vw;
  height: auto;
  display: flex;
  flex-direction: row;
`;

const QuestionTagPage = () => {

  const [questionTag, setQuestionTag] = useState([]);  //전체 데이터
  const [tagsAll, setTagsAll] = useState([]); // 태그 관련 전체 데이터
  const [tagsName, setTagsName] = useState([]); // 태그 이름순 정렬
  const [tagsNew, setTagsNew] = useState([]); // 태그 새로운 순서 정렬


  useEffect(() => {
    axios
      .all([
        axios.get("/tags"),
        axios.get("/questions"),
        axios.get("/tags?page=1&size=10&keyword=&tab=name"),
        axios.get("/tags?page=1&size=10&keyword=&tab=new"),
        // axios.get("/questions/tagged/{category}"),
      ])
      .then(
        axios.spread((response1, response2, response3, response4) => {
          setTagsAll(response1.data.data);
          setQuestionTag(response2.data.data);
          setTagsName(response4.data.data);
          setTagsNew(response3.data.data);
          
          // console.log(response1.data.data);
          // console.log(response2.data.data);
          // console.log(response3.data.data);
          // console.log(response4.data.data);
        })
      )
      .catch((error) => {
        console.log(error);
      });
  }, []);
  // 두개 같이 써보자



  return (
    <>
      <Header />
      <Maindiv>
        <Nav />
        {tagsAll && <QuestionsTag tagsAll={tagsAll} questionTag={questionTag} />}
        {/* <QuestionList /> */}
      </Maindiv>
      <Footer />
    </>
  );
};

export default QuestionTagPage;
