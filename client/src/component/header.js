import React from 'react'
import styled from 'styled-components';
import { createGlobalStyle } from "styled-components";

const GlobalStyle = createGlobalStyle`
  input {
    width: 60vw;
  }
`

const Headerdiv = styled.div`
  width: 100vw;
  height: 50px;
`;

const Header = () => {
  return (
    <>
    <GlobalStyle />
    <Headerdiv>
      <header>
        <img href="스택오버플로우로고" alt="로고"/>
        <input type='text' placeholder='Search...' />
      </header>
    </Headerdiv>
    </>
  )
}

export default Header;