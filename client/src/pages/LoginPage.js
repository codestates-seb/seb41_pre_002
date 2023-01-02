import React from "react";
import Header from "../component/header";
import styled from "styled-components";
import SocialLogin from "../component/login/socialLogin";
import LoginForm from "../component/login/loginForm";

const Maindiv = styled.div`
  width: 100vw;
  height: 100vh;
  display: flex;
  flex-direction: column;
  background-color: #f1f2f3;
`;

const SofIcon = styled.div`
  margin-top: 60px;
`;

function LoginPage() {
  return (
    <>
      <Maindiv>
        <SofIcon>
          <div className="ta-center fs-title mx-auto mb24">
            <a href="/">
              <svg
                aria-hidden="true"
                className="native svg-icon iconLogoGlyphMd"
                width="32"
                height="37"
                viewBox="0 0 32 37"
              >
                <path d="M26 33v-9h4v13H0V24h4v9h22Z" fill="#BCBBBB"></path>
                <path
                  d="m21.5 0-2.7 2 9.9 13.3 2.7-2L21.5 0ZM26 18.4 13.3 7.8l2.1-2.5 12.7 10.6-2.1 2.5ZM9.1 15.2l15 7 1.4-3-15-7-1.4 3Zm14 10.79.68-2.95-16.1-3.35L7 23l16.1 2.99ZM23 30H7v-3h16v3Z"
                  fill="#F48024"
                ></path>
              </svg>
            </a>
          </div>
        </SofIcon>
        <SocialLogin />
        <LoginForm />
        <div className="mx-auto ta-center fs-body1 p16 pb0 mb24 w100 wmx3">
          Don’t have an account?{" "}
          <a href="/users/signup?ssrc=head&amp;returnurl=https%3a%2f%2fstackoverflow.com%2f">
            Sign up
          </a>
          <div className="mt12">
            Are you an employer?
            <a
              href="https://careers.stackoverflow.com/employer/login"
              name="talent"
            >
              Sign up on Talent
              <svg
                aria-hidden="true"
                className="va-text-bottom sm:d-none svg-icon iconShareSm"
                width="14"
                height="14"
                viewBox="0 0 14 14"
              >
                <path d="M5 1H3a2 2 0 0 0-2 2v8c0 1.1.9 2 2 2h8a2 2 0 0 0 2-2V9h-2v2H3V3h2V1Zm2 0h6v6h-2V4.5L6.5 9 5 7.5 9.5 3H7V1Z"></path>
              </svg>
            </a>
          </div>
        </div>
      </Maindiv>
    </>
  );
}

export default LoginPage;
