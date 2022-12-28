import React, { useEffect, useState } from 'react';
import styled from 'styled-components';
import Header from '../component/header';
import Footer from '../component/footer';
import Nav from '../component/nav';
import Questions from '../component/question/Questions';
import axios from 'axios';

const Maindiv = styled.div`
  width: 100vw;
  height: auto;
  display: flex;
  flex-direction: row;
`;

const MainPage = () => {
  // const {} = data;
  const [mainData, setMainData] = useState(null);
  let [questionData, setQuestionData] = useState([]);

  useEffect(() => {
    axios
      .get('/questions', {})
      .then((response) => {
        // const questionData = response.data.data;
        setQuestionData(response.data);
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
      <Maindiv>
        <Nav />
        {questionData && <Questions questionData={questionData} />}
        {console.log('이게 뭐지', questionData.data)}
        {/* <div>
          {questionData.map((item, index) => (
            <QuestionItem key={index} questionData={questionData} />
          ))}
        </div> */}
      </Maindiv>
      <Footer />
    </>
  );
};

export default MainPage;
