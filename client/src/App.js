import React from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import DetailsQustion from './component/DetailsQustion';
import QuestionWrite from './pages/QuestionWrite';
import Profile from './component/Profile';
import LoginPage from './pages/LoginPage';
import LogoutPage from './pages/LogoutPage';
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

const Appdiv = styled.div`
  width: 100vw;
  height: auto;
  display: flex;
  flex-direction: row;
`;

function App() {
  const [isLogin, setIsLogin] = useState(() => JSON.parse(window.localStorage.getItem('isLogin')));
  const [memberId, setMemberId] = useState(null);

  useEffect(() => {
    window.localStorage.setItem('isLogin', JSON.stringify(isLogin));
  }, [isLogin]);

  return (
    <>
      <BrowserRouter>
        <Header isLogin={isLogin} />
        <Appdiv>
          <Nav />
          <Routes>
            <Route path="/" element={<Questions />} />
            <Route path="/DetailsQustion" element={<DetailsQustion />} />
            <Route path="/QuestionWrite" element={<QuestionWrite memberId={memberId} />} />
            <Route path="/Profile" element={<Profile />} />
            <Route path="/LoginPage" element={<LoginPage setIsLogin={setIsLogin} setMemberId={setMemberId} />} />
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
