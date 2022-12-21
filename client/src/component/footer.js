import React from "react";
import "../assets/fonts.css";
import styled from "styled-components";
import { createGlobalStyle } from "styled-components";

const GlobalStyle = createGlobalStyle`
div{
 text-align: center;
font-family: 'Jua', sans-serif;
font-size: 20px;
color: white;
};
a{
color: black;
}
`;
const Footersection = styled.section`
  width: 100vw;
  height: 400px;
  background-color: hsl(210, 8%, 15%);
  display: flex;
  flex-direction: column;
`;
const Discriptionsection = styled.section`
  background-color: hsl(210, 8%, 15%);
  margin-top: 40px;
`;

const Footerimagesection = styled.section`
  background-color: hsl(210, 8%, 15%);
  display: flex;
  flex-direction: row;
`;

const Imagediv = styled.div`
  flex-grow: 1;
  margin-top: 160px;
`;

const Jangdiv = styled.div`
  flex-grow: 1;
  height: 400px;
  padding: 60px 12px 24px 0px;
  & {
  }
`;
const Kangdiv = styled.div`
  flex-grow: 1;
  padding: 60px 12px 24px 0px;
  height: 400px;
  color: white;
`;
const Chidiv = styled.div`
  flex-grow: 1;
  height: 400px;
  padding: 60px 12px 24px 0px;
  color: white;
`;
const Shidiv = styled.div`
  flex-grow: 1;
  height: 400px;
  padding: 60px 12px 24px 0px;
  color: white;
`;
const Kimdiv = styled.div`
  flex-grow: 1;
  height: 400px;
  padding: 60px 12px 24px 0px;
  color: white;
`;
const Jungdiv = styled.div`
  flex-grow: 1;
  height: 400px;
  padding: 60px 12px 24px 0px;
  color: white;
`;

const Namediv = styled.div`
  padding-top: 30px;
  color: white;
`;

const Rounddiv = styled.div`
  position: absolute;
  margin-top: 30px;
  margin-left: 87px;
  width: 100px;
  height: 35px;
  border-radius: 15px;
  border: solid white;
  color: white;
`;

const Footer = () => {
  return (
    <>
      <GlobalStyle />
      <Footersection>
        <Discriptionsection>Project Team "2조!!"</Discriptionsection>
        <Footerimagesection>
          <Imagediv>
            <a href="https://stackoverflow.com" aria-label="Stack Overflow">
              <svg
                aria-hidden="true"
                class="native svg-icon iconLogoGlyphMd"
                width="32"
                height="37"
                viewBox="0 0 32 37"
              >
                <path d="M26 33v-9h4v13H0V24h4v9h22Z" fill="#BCBBBB"></path>
                <path
                  d="m21.5 0-2.7 2 9.9 13.3 2.7-2L21.5 0ZM26 18.4 13.3 7.8l2.1-2.5 12.7 10.6-2.1 2.5ZM9.1 15.2l15 7 1.4-3-15-7-1.4 3Zm14 10.79.68-2.95-16.1-3.35L7 23l16.1 2.99ZM23 30H7v-3h16v3Z"
                  fill="#F48024"
                ></path>
                {/*stack overflow 사진*/}
              </svg>
            </a>
          </Imagediv>
          <Jangdiv>
            <a href="https://github.com/samsamgo">
              <i class="fa-brands fa-github fa-8x"></i>
            </a>
            <Namediv>장경욱</Namediv>
            <Rounddiv>fornt-end</Rounddiv>
          </Jangdiv>
          <Kangdiv>
            <a href="https://github.com/kangseong-sim">
              <i class="fa-brands fa-github fa-8x"></i>
            </a>
            <Namediv>강성심</Namediv>
            <Rounddiv>fornt-end</Rounddiv>
          </Kangdiv>
          <Chidiv>
            <a href="https://github.com/hyob12">
              <i class="fa-brands fa-github fa-8x"></i>
            </a>
            <Namediv>채효병</Namediv>
            <Rounddiv>fornt-end</Rounddiv>
          </Chidiv>
          <Shidiv>
            <a href="https://github.com/samsamgo">
              <i class="fa-brands fa-github fa-8x"></i>
            </a>
            <Namediv>김시영</Namediv>
            <Rounddiv> back-end</Rounddiv>
          </Shidiv>
          <Kimdiv>
            <a href="https://github.com/woojcoding">
              <i class="fa-brands fa-github fa-8x"></i>
            </a>
            <Namediv>김정우</Namediv>
            <Rounddiv> back-end</Rounddiv>
          </Kimdiv>
          <Jungdiv>
            <a href="https://github.com/harin95">
              <i class="fa-brands fa-github fa-8x"></i>
            </a>
            <Namediv>정하린</Namediv>
            <Rounddiv> back-end</Rounddiv>
          </Jungdiv>
        </Footerimagesection>
      </Footersection>
    </>
  );
};

export default Footer;
