import React from 'react';
import styled from 'styled-components';

const StyledHeader = styled.header`
  background-color: #f8f9f9;
  box-shadow: 0 2px 2px rgba(0, 0, 0, 0.1);
  display: flex;
  width: 100vw;
`;

const Header = () => {
  return (
    <StyledHeader>
      <img src="" className="logo" alt="로고" />
      <form action="" className="search">
        <input type="text" placeholder="Search..." />
      </form>
      <a href="" className="profile">
        me!
      </a>
    </StyledHeader>
  );
};

export default Header;
