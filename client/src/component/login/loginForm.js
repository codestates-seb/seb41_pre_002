import React from 'react';
import styled from 'styled-components';
import axios from 'axios';
import { useState } from 'react';

const LoginSection = styled.div`
  label {
    text-align: left;
  }
`;

function LoginForm({ setIsLogin }) {
  const [loginEmail, setLoginEmail] = useState('');
  const [loginPw, setLoginPw] = useState('');

  const loginEmailHandler = (e) => {
    setLoginEmail(e.target.value);
  };

  const loginPwHandler = (e) => {
    setLoginPw(e.target.value);
  };

  const requestLogin = () => {
    if (!loginEmail || !loginPw) {
      alert('아이디와 비밀번호를 입력하세요');
    }
    axios
      .post('/login', {
        username: loginEmail,
        password: loginPw,
      })
      .then((response) => {
        console.log(response.data.accessToken);
        /// token이 필요한 API 요청 시 header Authorization에 token 담아서 보내기
        axios.defaults.headers.common['Authorization'] = `Bearer ${response.data.accessToken}`;
        axios.get('/members/1').then((res) => {
          console.log(res);
          console.log(axios.defaults.headers.common.Authorization);
        });
      })
      .catch((e) => {
        console.log(e.response.data);
      });
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    requestLogin();
    setIsLogin(true);
    window.location.replace('/');
    // alert('로그인 성공!');
  };

  return (
    <LoginSection>
      <div className="mx-auto mb24 p24 wmx3 bg-white bar-lg bs-xl mb24">
        <form className="d-flex fd-column gs12 gsy" onSubmit={handleSubmit}>
          <div className="d-flex fd-column gs4 gsy js-auth-item ">
            <label className="flex--item s-label" htmlFor="email">
              Email
            </label>
            <div className="d-flex ps-relative">
              <input
                className="s-input"
                id="email"
                onChange={loginEmailHandler}
                value={loginEmail}
                type="email"
                size="30"
                maxLength="100"
                name="email"
              />
              <svg
                aria-hidden="true"
                className="s-input-icon js-alert-icon d-none svg-icon iconAlertCircle"
                width="18"
                height="18"
                viewBox="0 0 18 18"
              >
                <path d="M9 17c-4.36 0-8-3.64-8-8 0-4.36 3.64-8 8-8 4.36 0 8 3.64 8 8 0 4.36-3.64 8-8 8ZM8 4v6h2V4H8Zm0 8v2h2v-2H8Z"></path>
              </svg>
            </div>
          </div>
          <div className="d-flex fd-column-reverse gs4 gsy js-auth-item ">
            <div className="d-flex ps-relative js-password">
              <input
                className="flex--item s-input"
                type="password"
                onChange={loginPwHandler}
                value={loginPw}
                autoComplete="off"
                name="password"
                id="password"
              />
              <svg
                aria-hidden="true"
                className="s-input-icon js-alert-icon d-none svg-icon iconAlertCircle"
                width="18"
                height="18"
                viewBox="0 0 18 18"
              >
                <path d="M9 17c-4.36 0-8-3.64-8-8 0-4.36 3.64-8 8-8 4.36 0 8 3.64 8 8 0 4.36-3.64 8-8 8ZM8 4v6h2V4H8Zm0 8v2h2v-2H8Z"></path>
              </svg>
            </div>
            <div className="d-flex ai-center ps-relative jc-space-between">
              <label className="flex--item s-label" htmlFor="password">
                Password
              </label>
              <a className="flex--item s-link fs-caption" href="/">
                Forgot password?
              </a>
            </div>
          </div>
          <div className="d-flex gs4 gsy fd-column js-auth-item ">
            <button className="flex--item s-btn s-btn__primary" type="submit" id="submit-button" name="submit-button">
              Log in
            </button>
          </div>
        </form>
      </div>
    </LoginSection>
  );
}

export default LoginForm;
