import React from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import DetailsQustion from './component/DetailsQustion';
import QuestionWrite from './pages/QuestionWrite';
import Profile from './component/Profile';
import LoginPage from './pages/LoginPage';
// import LogoutPage from "./pages/LogoutPage";
import SignInPage from './pages/SignInPage';
import Tag from './component/tag/Tag.js';
import Users from './component/user/Users';
import QuestionTagPage from './pages/QuestionTagPage';
import { useState, useEffect } from 'react';
import styled from 'styled-components';
import Header from './component/header';
import Questions from './component/question/Questions';
import Footer from './component/footer';
import Nav from './component/nav';
import axios from 'axios';

const Appdiv = styled.div`
  width: 100vw;
  height: auto;
  display: flex;
  flex-direction: row;
`;

function App() {
  const [questions, setQuestions] = useState('');
  const [number, setnumber] = useState(1);
  const [isLogin, setIsLogin] = useState(() => JSON.parse(window.localStorage.getItem('isLogin')));

  useEffect(() => {
    window.localStorage.setItem('isLogin', JSON.stringify(isLogin));
  }, [isLogin]);

  useEffect(() => {
    axios
      .get(`/questions`, {})
      .then((response) => {
        // console.log(response.data.data.questionResponseDto.title); //정상 통신 후 응답된 메시지 출력
        setQuestions(response.data.data.questionResponseDto); //정상 통신 후 응답된 메시지 출력
      })
      .catch((error) => {
        console.log(error);
      });
  }, []);

  return (
    <>
      <BrowserRouter>
        <Appdiv>
          <Header isLogin={isLogin} />
          <Routes>
            <Route path="/" element={<MainPage questions={questions} />} />
            <Route path="/QuesetionRead" element={<QuesetionRead questions={questions} />} />
            <Route path="/QuestionWrite" element={<QuestionWrite />} />
            <Route path="/MyPage" element={<MyPage />} />
            <Route path="/LoginPage" element={<LoginPage isLogin={isLogin} setIsLogin={setIsLogin} />} />
            <Route path="/LogoutPage" element={<LogoutPage setIsLogin={setIsLogin} />} />
            <Route path="/SignInPage" element={<SignInPage />} />
            <Route path="/Tag" element={<Tag />} />
            <Route path="/QuestionTagPage" element={<QuestionTagPage />} />
            <Route path="/Users" element={<Users />} />
          </Routes>
        </Appdiv>
      </BrowserRouter>
      <Footer />
    </>
  );
}

export default App;
