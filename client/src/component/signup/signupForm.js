import React from 'react';
import styled from 'styled-components';
import { useState } from 'react';
import axios from 'axios';

const LoginSection = styled.div`
  label {
    text-align: left;
  }
`;

function SignUpForm() {
  const [email, setEmail] = useState('');
  const [memberName, setMemberName] = useState('');
  const [memberPassword, setMemberPassword] = useState('');

  const emailHandler = (e) => {
    setEmail(e.target.value);
  };

  const memberNameHandler = (e) => {
    setMemberName(e.target.value);
  };

  const memberPasswordHandler = (e) => {
    setMemberPassword(e.target.value);
  };

  const addMember = () => {
    axios
      .post('/signUp', {
        email: email,
        memberName: memberName,
        memberPassword: memberPassword,
      })
      .then((res) => {
        console.log(res.data);
      });
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    addMember();
    window.location.replace('/LoginPage');
  };

  return (
    <LoginSection>
      <div className="mx-auto mb24 p24 wmx3 bg-white bar-lg bs-xl mb24">
        <form className="d-flex fd-column gs12 gsy" onSubmit={handleSubmit}>
          <div className="d-flex fd-column gs4 gsy js-auth-item ">
            <label className="flex--item s-label" htmlFor="display-name">
              Display name
            </label>
            <div className="d-flex ps-relative">
              <input
                className="s-input"
                id="display-name"
                type="text"
                size="30"
                maxLength="100"
                name="display-name"
                value={memberName}
                onChange={memberNameHandler}
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
          <div className="d-flex fd-column gs4 gsy js-auth-item ">
            <label className="flex--item s-label" htmlFor="email">
              Email
            </label>
            <div className="d-flex ps-relative">
              <input className="s-input" id="email" type="email" size="30" maxLength="100" name="email" value={email} onChange={emailHandler} />
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
                autoComplete="off"
                name="password"
                id="password"
                value={memberPassword}
                onChange={memberPasswordHandler}
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
            </div>
          </div>
          <div className="d-flex gs4 gsy fd-column js-auth-item ">
            <button className="flex--item s-btn s-btn__primary" type="submit" id="submit-button" name="submit-button">
              Sign up
            </button>
          </div>
        </form>
      </div>
    </LoginSection>
  );
}

export default SignUpForm;
