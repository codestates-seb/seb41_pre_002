import React, { useEffect, useState } from "react";
import styled from "styled-components";
import Header from "../component/header";
import Footer from "../component/footer";
import Nav from "../component/nav";
import QuestionsTag from "../component/questionTag/questiontag";
// import QuestionList from '../component/question/questionlist';

import axios from "axios";
import QuestionTag from "../component/questionTag";

const Maindiv = styled.div`
  width: 100vw;
  height: auto;
  display: flex;
  flex-direction: row;
`;

const QuestionTagPage = () => {
  let [questionTag, setQuestionTag] = useState([]);

  const [tagsAll, setTagsAll] = useState([]);
  const [tagsName, setTagsName] = useState([]);
  const [tagsNew, setTagsNew] = useState([]);
  const [category, setCategory] = useState([]);

  useEffect(() => {
    axios
      .all([
        axios.get("/tags"),
        axios.get("/tags?page=1&size=10&keyword=&tab=name"),
        axios.get("/tags?page=1&size=10&keyword=&tab=new"),
        // axios.get("/questions/tagged/{category}"),
      ])
      .then(
        axios.spread((response1, response2, response3, response4) => {
          setTagsAll(response1.data.data);
          setTagsName(response2.data.data);
          setTagsNew(response3.data.data);
          setCategory(response4.data.data);
          console.log(response1.data.data);
          console.log(response2.data.data);
          console.log(response3.data.data);
          console.log(response4.data.data);
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
        {questionTag && <QuestionsTag tagsAll={tagsAll} />}
        {/* <QuestionList /> */}
      </Maindiv>
      <Footer />
    </>
  );
};

export default QuestionTagPage;
