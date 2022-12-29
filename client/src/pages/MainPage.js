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
  
  let [questionData, setQuestionData] = useState([]);

  useEffect(() => {
    axios
      .get(`/questions`, {})
      .then((response) => {
        setQuestionData(response.data);
        console.log(response.data); // data& pageinfo
      })
      .catch((error) => {
        console.log(error);

      });
  }, []);

  return (
    <>
      <Header />
      <Maindiv>
        <Nav />
        {questionData && <Questions questionData={questionData} />}
        {/* {console.log('이게 뭐지', questionData.data)} */}
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
