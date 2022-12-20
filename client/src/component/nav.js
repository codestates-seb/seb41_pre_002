import React from 'react';
import styled from 'styled-components';

const NavDiv = styled.div`
  width: 165vw;
  height: 770px;
  /* background-color: blue; */
  display: flex;
`;

const HomeDiv = styled.div`
  width: 150px;
  height: 250px;
`;

const Nav = () => {
  return (
    <>
      <NavDiv>
        <HomeDiv> Home public Question Tags Companies</HomeDiv>
      </NavDiv>
    </>
  );
};

export default Nav;
