// eslint-disable-next-line

import React, { useState } from "react";
import styled from "styled-components";
import { Link } from "react-router-dom";

const NavWrapper = styled.nav`
  width: 270px;
  margin: 0;
  padding-top: 24px;
  padding-left: 100px;
  max-height: 100%;
  height: 100vh;
  position: sticky;
  color: #525960;
  font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Oxygen,
    Ubuntu, Cantarell, "Open Sans", "Helvetica Neue", sans-serif;
  top: 0;
  border-right: 1px solid rgb(214, 217, 220);
`;

const NavDiv = styled.div`
  display: flex;
  flex-direction: column;
  color: #525960;

  .Home {
    display: flex;
    align-items: flex-end;
    color: #525960;
    font-size: 13px;
    height: 25px;
    /* padding-left: 8px; */
  }
  .Public {
    display: flex;
    color: #6a737c;
    font-size: 11px;
    height: 15px;
    text-align: left;
    align-items: flex-end;
    margin: 16px 0px 4px 0px;
  }
`;

const SubNav = styled.div`
  font-size: 13px;
  color: #525960;
  width: 165px;
  list-style: none;
  padding: 0;
  margin: 0;
`;

const QuestionDiv = styled.div`
  display: flex;
  align-items: center;
  color: #525960;
  font-size: 13px;
  width: 165px;
  height: 35px;
  padding: 4px 8px 4px 0px;

  span {
    padding-left: 10px;
  }
`;

const QuestionList = styled.div`
  display: flex;
  align-items: center;
  padding: 4px 4px 4px 30px;
  color: #525960;
  font-size: 13px;
  border-right: 3px;
  width: 165px;
  height: 35px;
  &:hover {
    font-weight: bold;
    color: var(--black-900);
  }
  &.active {
    align-items: center;
    font-weight: bold;
    background: var(--black-050);
    color: var(--black-900);
    border-right: 3px solid var(--theme-primary-color);
  }
  &.active .Link {
    font-weight: bold;
    background-color: hsl(210, 8%, 95%);
    color: #222;
  }
`;
const StyledLink = styled(Link)`
  &:hover {
    font-weight: bold;
    color: var(--black-900);
  }
`;

const Nav = () => {
  const [active, setActive] = useState("");

  return (
    <NavWrapper>
      <NavDiv>
        <div className="Home">
          <StyledLink to="/">Home</StyledLink> 
        </div>
        <SubNav>
          <div className="Public">PUBLIC</div>
          <QuestionDiv>
            <svg
              width="18"
              height="18"
              viewBox="0 0 18 18"
              fill="none"
              xmlns="http://www.w3.org/2000/svg"
            >
              <path
                d="M9 1C4.64267 1 1 4.64267 1 9C1 13.3573 4.64266 17 9 17C13.3573 17 17 13.3573 17 9C17 4.64266 13.3573 1 9 1ZM8 15.32C6.26864 15.0438 4.68393 14.0332 3.70319 12.58C2.72245 11.1267 2.37828 9.27893 2.77 7.57L7 11.68V12.48C7 13.36 7.12 13.8 8 13.8V15.32ZM13.72 13.32C13.52 12.66 12.72 12 12 12H11V10C11 9.56 10.44 9 10 9H6V7H7C7.44 7 8 6.44 8 6V5H10C10.88 5 11.4 4.28 11.4 3.4V3.07C13.3216 3.85114 14.7733 5.56167 15.2317 7.5847C15.69 9.60773 15.1173 11.7769 13.72 13.31V13.32Z"
                fill="#525960"
              />
            </svg>
            <span>
              <StyledLink to="/">Question</StyledLink>
            </span>
          </QuestionDiv>

          <QuestionList
            className={"TagPag" === active ? "active" : ""}
            onClick={() => setActive("TagPag")}
          >
            <StyledLink to="/Tag">Tag</StyledLink>
          </QuestionList>
          <QuestionList
            className={"UserPage" === active ? "active" : ""}
            onClick={() => setActive("UserPage")}
          >
            <StyledLink to="/Users">User</StyledLink>
          </QuestionList>
          <QuestionList
            className={"Companies" === active ? "active" : ""}
            onClick={() => setActive("Companies")}
          >
            Companies
          </QuestionList>
        </SubNav>
      </NavDiv>
    </NavWrapper>
  );
};

export default Nav;
