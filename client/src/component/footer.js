import React from "react";
import "../assets/fonts.css";
import styled from "styled-components";
import { createGlobalStyle } from "styled-components";

const GlobalStyle = createGlobalStyle`
div{
  text-align: center;
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
  font-size: 20px;
  color: white;
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

const Namecomponent = styled.div`
  flex-grow: 1;
  height: 400px;
  padding: 60px 12px 24px 0px;
`;
const Namediv = styled.div`
  display: flex;
  margin-left: 20px;
  width: 200px;
  flex-direction: column;
  padding-top: 30px;
  font-size: 20px;
  color: white;
  div {
    position: relative;
    text-align: center;
    margin-top: 10%;
    margin-left: 25%;
    justify-content: space-around;
    width: 100px;
    height: 35px;
    border-radius: 15px;
    border: solid white;
    font-size: 20px;
    color: white;
  }
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
              </svg>
            </a>
          </Imagediv>
          <Namecomponent>
            <a href="https://github.com/samsamgo">
              <i class="fa-brands fa-github fa-8x"></i>
            </a>
            <Namediv>
              장경욱<div>fornt-end</div>
            </Namediv>
          </Namecomponent>
          <Namecomponent>
            <a href="https://github.com/kangseong-sim">
              <i class="fa-brands fa-github fa-8x"></i>
            </a>
            <Namediv>
              강성심<div>fornt-end</div>
            </Namediv>
          </Namecomponent>
          <Namecomponent>
            <a href="https://github.com/hyob12">
              <i class="fa-brands fa-github fa-8x"></i>
            </a>
            <Namediv>
              채효병<div>fornt-end</div>
            </Namediv>
          </Namecomponent>
          <Namecomponent>
            <a href="https://github.com/samsamgo">
              <i class="fa-brands fa-github fa-8x"></i>
            </a>
            <Namediv>
              김시영<div>fornt-end</div>
            </Namediv>
          </Namecomponent>
          <Namecomponent>
            <a href="https://github.com/woojcoding">
              <i class="fa-brands fa-github fa-8x"></i>
            </a>
            <Namediv>
              김정우<div>fornt-end</div>
            </Namediv>
          </Namecomponent>
          <Namecomponent>
            <a href="https://github.com/harin95">
              <i class="fa-brands fa-github fa-8x"></i>
            </a>
            <Namediv>
              정하린<div>fornt-end</div>
            </Namediv>
          </Namecomponent>
        </Footerimagesection>
      </Footersection>
    </>
  );
};

export default Footer;
