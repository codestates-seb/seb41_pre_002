import React from "react";
import styled from "styled-components";
import { Link } from "react-router-dom";

const NavWrapper = styled.nav`
  width: 270px;
  margin: 0;
  padding-top: 24px;
  padding-left: 100px;
  max-height: 100%;
  height: 100vh;
  position: inherit;
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
  /* font-family: -apple-system,BlinkMacSystemFont,Segoe UI,Roboto,Oxygen,Ubuntu,Cantarell,Fira Sans,Droid Sans,Helvetica Neue,sans-serif;; */

  &:hover {
    /* font-weight: bold; */
    /* background: var(--black-050); */
    color: var(--black-900);
    /* border-right: 3px solid var(--theme-primary-color); */
  }

  // 페이지 라우터해서 동적으로 구현해야함
  // 현재 path랑 목록이랑 일치하는지 체크해서 active 넣기!
  &:active {
    /* -webkit-box-align: center; */
    align-items: center;
    /* padding: 4px 8px 4px 0px; */
    font-weight: bold;
    background: var(--black-050);
    color: var(--black-900);
    border-right: 3px solid var(--theme-primary-color);
  }
`;

const Nav = () => {
  return (
    <>
      <NavWrapper>
        <NavDiv>
          <div className="Home">
            <Link to="/">Home</Link> {/*link to || link로 구현 */}
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
              <span>Question</span>
            </QuestionDiv>
            <QuestionList>
              <Link to="/TagPage">Tag</Link>
            </QuestionList>
            <QuestionList>
              <Link to="/UserPage">User</Link>
            </QuestionList>
            <QuestionList>
              <Link to="/">Companies</Link>
            </QuestionList>
            {/* <li>COLLECTIVEIS</li>
          <svg
          width="18"
          height="18"
          viewBox="0 0 18 18"
          fill="none"
          xmlns="http://www.w3.org/2000/svg"
          >
          <path
          fill-rule="evenodd"
          clip-rule="evenodd"
          d="M9.85648 0.889426C9.40354 0.370192 8.59646 0.370191 8.14352 0.889426L7.63826 1.46864C7.33464 1.81669 6.85059 1.9464 6.41362 1.79678L5.68644 1.5478C5.03457 1.3246 4.33562 1.72813 4.20298 2.40427L4.05502 3.15852C3.96611 3.61175 3.61175 3.96611 3.15852 4.05502L2.40427 4.20298C1.72813 4.33562 1.3246 5.03457 1.5478 5.68644L1.79678 6.41362C1.9464 6.85059 1.81669 7.33464 1.46864 7.63826L0.889426 8.14352C0.370192 8.59646 0.370191 9.40353 0.889425 9.85648L1.46864 10.3617C1.81669 10.6654 1.9464 11.1494 1.79678 11.5864L1.5478 12.3136C1.3246 12.9654 1.72813 13.6644 2.40427 13.797L3.15852 13.945C3.61175 14.0339 3.96611 14.3882 4.05502 14.8415L4.20298 15.5957C4.33562 16.2719 5.03457 16.6754 5.68644 16.4522L6.41362 16.2032C6.85059 16.0536 7.33464 16.1833 7.63826 16.5314L8.14352 17.1106C8.59646 17.6298 9.40353 17.6298 9.85648 17.1106L10.3617 16.5314C10.6654 16.1833 11.1494 16.0536 11.5864 16.2032L12.3136 16.4522C12.9654 16.6754 13.6644 16.2719 13.797 15.5957L13.945 14.8415C14.0339 14.3882 14.3882 14.0339 14.8415 13.945L15.5957 13.797C16.2719 13.6644 16.6754 12.9654 16.4522 12.3136L16.2032 11.5864C16.0536 11.1494 16.1833 10.6654 16.5314 10.3617L17.1106 9.85648C17.6298 9.40353 17.6298 8.59646 17.1106 8.14352L16.5314 7.63826C16.1833 7.33464 16.0536 6.85059 16.2032 6.41362L16.4522 5.68644C16.6754 5.03457 16.2719 4.33562 15.5957 4.20298L14.8415 4.05502C14.3882 3.96611 14.0339 3.61175 13.945 3.15852L13.797 2.40427C13.6644 1.72813 12.9654 1.3246 12.3136 1.5478L11.5864 1.79678C11.1494 1.9464 10.6654 1.81669 10.3617 1.46864L9.85648 0.889426ZM9.37119 3.56497L10.5875 6.5938C10.6447 6.73628 10.7784 6.83344 10.9316 6.84382L14.1881 7.06463C14.5478 7.08902 14.6942 7.53949 14.4175 7.77067L11.9127 9.8634C11.7949 9.96185 11.7438 10.119 11.7813 10.2679L12.5776 13.4332C12.6656 13.7829 12.2824 14.0613 11.977 13.8696L9.21268 12.1341C9.08265 12.0525 8.91735 12.0525 8.78732 12.1341L6.02301 13.8696C5.71764 14.0613 5.33445 13.7829 5.42241 13.4332L6.21871 10.2679C6.25617 10.119 6.20509 9.96185 6.08727 9.8634L3.58253 7.77067C3.30584 7.53949 3.4522 7.08902 3.81194 7.06463L7.06839 6.84382C7.22157 6.83344 7.3553 6.73628 7.41252 6.5938L8.62881 3.56496C8.76317 3.23038 9.23683 3.23038 9.37119 3.56497Z"
          fill="orange"
          />
          </svg>
        <li>Explore Colletives</li> */}
          </SubNav>
          {/* <ul>
            <li>teams</li>
            <svg
            aria-hidden="true"
            class="svg-icon iconBriefcaseSm"
            fill="orange"
            width="14"
            height="14"
            viewBox="0 0 14 14"
            >
            <path d="M4 3a1 1 0 0 1 1-1h4a1 1 0 0 1 1 1v1h.5c.83 0 1.5.67 1.5 1.5v5c0 .83-.67 1.5-1.5 1.5h-7A1.5 1.5 0 0 1 2 10.5v-5C2 4.67 2.67 4 3.5 4H4V3Zm5 1V3H5v1h4Z"></path>
            </svg>
            <li>create free team</li>
          </ul> */}
        </NavDiv>
      </NavWrapper>
    </>
  );
};

export default Nav;
