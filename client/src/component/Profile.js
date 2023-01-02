import React from "react";
import styled from "styled-components";
import imgfile from "../assets/1.png";
import { createGlobalStyle } from "styled-components";

const GlobalStyle = createGlobalStyle`
div{
  font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Oxygen,
    Ubuntu, Cantarell, "Open Sans", "Helvetica Neue", sans-serif;
}

`;

const Pagedov = styled.div`
  width: auto;
  height: auto;
  display: flex;
  flex-direction: column;
`;

const ContentHeader = styled.div`
  display: flex;
  flex-direction: row;
  padding: 24px 30px;
  img {
    border-radius: 10px;
    width: 120px;
    height: 120px;
  }
  div {
    width: auto;
    display: flex;
    flex-direction: column;
    color: black;
    text-align: left;
    margin: 15px 30px;
    font-size: 34px;
    div {
      display: flex;
      flex-direction: row;
      margin: 15px 0px 0px -7px;
      font-size: 13px;
      color: #6a737c;
    }
    i {
      margin: 3px 5px 0px 10px;
    }
  }
`;
const Editdiv = styled.div`
  display: flex;

  flex-direction: row;
  position: absolute;
  top: ${(props) => (props.top ? props.top : "50px")};
  right: ${(props) => (props.right ? props.right : "70px")};
`;

const Categoridiv = styled.div`
  background-color: white;
  display: flex;
  flex-direction: row;
`;

const Relatedboxdiv = styled.div`
  width: 60px;
  height: 30px;
  padding: 5px;
  margin: 0px 0px 0px 30px;
  background-color: ${(props) => (props.bkcolor ? props.bkcolor : "white")};
  color: ${(props) => (props.color ? props.color : "#525960")};
  font-size: 14px;
  text-align: center;
  border-radius: 15px;
`;

const Maindiv = styled.div`
  display: flex;
  flex-direction: row;
`;

const Listdiv = styled.div`
  background-color: white;
  width: 10vw;
  height: auto;
  display: flex;
  flex-direction: column;

  div {
    background-color: ${(props) => (props.bkcolor ? props.bkcolor : "white")};
    color: ${(props) => (props.color ? props.color : "#525960")};
    font-size: 16px;
    text-align: left;
    margin: 20px 0px 0px 30px;
  }
`;

const Contentdiv = styled.div`
  height: auto;
  display: flex;
  flex-direction: column;
  div {
    color: black;
    text-align: left;
    padding: 20px;
  }
`;

const Contentsection1 = styled.section`
  background-color: white;
  display: flex;
  flex-direction: row;
  font-size: 16px;
`;
const Contentaside1 = styled.aside`
  background-color: white;
  border-radius: 5px;
  border: 1px solid #525952;
  color: black;
  display: flex;
  margin: 8px 0px 8px 25px;
  width: 390px;
  height: 400px;
  flex-direction: column;
  text-align: center;
  svg {
    margin: 40px 20px 20px 30px;
    margin-left: 170px;
  }
  span {
    font-size: 19px;
    color: "black";
  }
  div {
    font-size: 15px;
    color: "#6A737C";
    text-align: center;
  }
`;
const Contentaside2 = styled(Contentaside1)`
  width: 310px;
  svg {
    margin-left: 130px;
  }
  a {
    padding: 15px 20px;
    font-size: 15px;
    width: 250px;
    margin-top: 30px;
    margin-left: 30px;
  }
`;
const Contentaside3 = styled(Contentaside1)`
  width: 230px;
  svg {
    margin-left: 100px;
  }
`;

const Contentsection2 = styled.section`
  display: flex;
  flex-direction: column;
  font-size: 16px;
  div {
    display: flex;
    flex-direction: row;
  }
  span {
    width: 100px;
    text-align: left;
    margin: 0px 430px 16px 5px;
  }
`;
const ButtonBox = styled.div`
  display: flex;
  flex-direction: row;
  position: absolute;
  top: ${(props) => (props.top ? props.top : "725px")};
  left: ${(props) => (props.left ? props.left : "1558px")};
  bottom: auto;
  right: auto;
  border-radius: 5px;

  div {
    background-color: #ffffff;
    color: #6a737c;
    margin: 0px -1px -1px 0px;
    padding: 5px;
    font-size: 15px;
    border: 1px solid;
  }
`;

const Middleaside = styled.aside`
  border-radius: 5px;
  border: 1px solid #525952;
  color: black;
  display: flex;
  margin: -40px 75px 30px 5px;
  width: 450px;
  height: 80px;
  text-align: center;
`;

const Allaside = styled(Middleaside)`
  margin: 0px 0px 30px 20px;
  width: 985px;
`;

function Profile() {
  return (
    <>
      <GlobalStyle />
      <Pagedov>
        <ContentHeader>
          <img src={imgfile} alt="imagefile" />
          <div>
            kyueng uk jang
            <div>
              <i class="fa-solid fa-cake-candles"></i>Member for 5 days
              <i class="fa-solid fa-clock"></i>Last seen this weekVisited 5
              <i class="fa-solid fa-calendar-days"></i>
              days, 5 consecutive
            </div>
          </div>

          <Editdiv right="220px">
            <a
              class="flex--item s-btn s-btn__outlined s-btn__muted s-btn__icon s-btn__sm"
              href="/users/edit/20813270"
            >
              <svg
                aria-hidden="true"
                class="svg-icon iconPencil"
                width="18"
                height="18"
                viewBox="0 0 18 18"
              >
                <path d="m13.68 2.15 2.17 2.17c.2.2.2.51 0 .71L14.5 6.39l-2.88-2.88 1.35-1.36c.2-.2.51-.2.71 0ZM2 13.13l8.5-8.5 2.88 2.88-8.5 8.5H2v-2.88Z"></path>
              </svg>{" "}
              Edit profile
            </a>
          </Editdiv>
          <Editdiv>
            <a
              href="https://stackexchange.com/users/27295592/kyueng-uk-jang"
              class="d-flex ai-center ws-nowrap s-btn s-btn__outlined s-btn__muted s-btn__icon s-btn__sm d-flex ai-center"
            >
              <svg
                aria-hidden="true"
                class="native mln2 mr2 svg-icon iconLogoSEXxs"
                width="18"
                height="18"
                viewBox="0 0 18 18"
              >
                <path
                  d="M3 4c0-1.1.9-2 2-2h8a2 2 0 0 1 2 2H3Z"
                  fill="#8FD8F7"
                ></path>
                <path
                  d="M15 11H3c0 1.1.9 2 2 2h5v3l3-3a2 2 0 0 0 2-2Z"
                  fill="#155397"
                ></path>
                <path fill="#46A2D9" d="M3 5h12v2H3z"></path>
                <path fill="#2D6DB5" d="M3 8h12v2H3z"></path>
              </svg>
              Network profile
            </a>
          </Editdiv>
        </ContentHeader>
        <Categoridiv>
          <Relatedboxdiv>Profile</Relatedboxdiv>
          <Relatedboxdiv bkcolor="orange" color="white">
            Activity
          </Relatedboxdiv>
          <Relatedboxdiv>Saves</Relatedboxdiv>
          <Relatedboxdiv>Settings</Relatedboxdiv>
        </Categoridiv>
        <Maindiv>
          <Listdiv>
            <div>Summary</div>
            <div>Answer</div>
            <div>Question</div>
            <div>Tags</div>
            <div>Articles</div>
            <div>Badges</div>
            <div>Following</div>
            <div>Bounties</div>
            <div>Reputation</div>
            <div>All action</div>
            <div>Responses</div>
            <div>Votes</div>
          </Listdiv>
          <Contentdiv>
            <div>Summary</div>
            <Contentsection1>
              <Contentaside1>
                <svg
                  aria-hidden="true"
                  class="svg-spot spotReputation"
                  width="60"
                  height="60"
                  viewBox="0 0 48 48"
                >
                  <path
                    d="M32 9a1 1 0 0 1-1 1H6a1 1 0 0 1 0-2h25a1 1 0 0 1 1 1Zm4.25 1.6a1 1 0 0 1 .92-.6H41a1 1 0 1 1 0 2h-3.18l-4.9 11.4a1 1 0 0 1-.92.6h-7.38l-2.73 5.45A1 1 0 0 1 21 30h-6.51l-4.07 9.4a1 1 0 0 1-1.84-.8l4.34-10a1 1 0 0 1 .91-.6h6.55l2.73-5.45A1 1 0 0 1 24 22h7.34l4.9-11.4ZM42 16a1 1 0 1 0 0-2h-2a1 1 0 1 0 0 2h2Zm-24 5a1 1 0 0 1-1 1H6a1 1 0 1 1 0-2h11a1 1 0 0 1 1 1Zm24 1a1 1 0 1 0 0-2h-4a1 1 0 1 0 0 2h4Zm1 11a1 1 0 0 1-1 1H17a1 1 0 1 1 0-2h25a1 1 0 0 1 1 1ZM8 28a1 1 0 1 0 0-2H6a1 1 0 1 0 0 2h2Z"
                    opacity=".2"
                  ></path>
                  <path d="M36.17 8a1 1 0 0 0-.92.6L30.35 20H23a1 1 0 0 0-.9.55L19.39 26h-6.55a1 1 0 0 0-.9.58L6.1 39.08a1 1 0 0 0 1.82.84L13.47 28H20a1 1 0 0 0 .9-.55L23.61 22H31a1 1 0 0 0 .92-.6l4.9-11.4H42a1 1 0 1 0 0-2h-5.83ZM27 16a1 1 0 1 0 0-2H6a1 1 0 1 0 0 2h21Zm16 11a1 1 0 0 1-1 1H28a1 1 0 1 1 0-2h14a1 1 0 0 1 1 1Zm-1 13a1 1 0 1 0 0-2H14a1 1 0 1 0 0 2h28Z"></path>
                </svg>
                <span>Reputation is how the community thanks you</span>
                <div>
                  When users upvote your helpful posts, you'll earn reputation
                  and unlock new privileges.
                </div>
                <p class="flex--item mt8 px8">
                  Learn more about
                  <a
                    href="/help/whats-reputation"
                    class="fc-medium td-underline"
                  >
                    reputation
                  </a>
                  and
                  <a href="/help/privileges" class="fc-medium td-underline">
                    privileges
                  </a>
                </p>
              </Contentaside1>
              <Contentaside2>
                <svg
                  aria-hidden="true"
                  class="svg-spot spotBadge"
                  width="60"
                  height="60"
                  viewBox="0 0 48 48"
                >
                  <path
                    d="M14 6a1 1 0 0 1 1-1h20a1 1 0 1 1 0 2H15a1 1 0 0 1-1-1ZM7 21c0-1.1.9-2 2-2h35a3 3 0 0 1 3 3v10a3 3 0 0 1-3 3H10a3 3 0 0 1-3-3V21Zm27 23a1 1 0 1 0 0-2H14a1 1 0 1 0 0 2h20Z"
                    opacity=".2"
                  ></path>
                  <path d="M8 11a1 1 0 0 1 1-1h31a1 1 0 1 1 0 2H9a1 1 0 0 1-1-1Zm0 13a4 4 0 1 1 8 0 4 4 0 0 1-8 0Zm4-2a2 2 0 1 0 0 4 2 2 0 0 0 0-4Zm-9-4a3 3 0 0 1 3-3h36a3 3 0 0 1 3 3v12a3 3 0 0 1-3 3H6a3 3 0 0 1-3-3V18Zm3-1a1 1 0 0 0-1 1v12a1 1 0 0 0 1 1h36a1 1 0 0 0 1-1V18a1 1 0 0 0-1-1H6Zm34 22a1 1 0 1 0 0-2H9a1 1 0 1 0 0 2h31Z"></path>
                </svg>
                <span>Earn badges for helpful actions</span>
                <div>
                  Badges are bits of digital flair that you get when you
                  participate in especially helpful ways.
                </div>

                <a href="/tour" class="d-inline-flex s-btn s-btn__primary">
                  Take the Tour and earn your first badge
                </a>
              </Contentaside2>
              <Contentaside3>
                <svg
                  aria-hidden="true"
                  class="svg-spot spotAstronaut"
                  width="60"
                  height="60"
                  viewBox="0 0 48 48"
                >
                  <path
                    opacity=".2"
                    d="M39.5 12a.5.5 0 0 1-.5-.5.5.5 0 0 0-.5-.5h-6.1c-.77 0-1.4.63-1.4 1.4v6.2c0 .77.63 1.4 1.4 1.4H38a1 1 0 0 1 1 1 1 1 0 0 0 1 1h3.6c.77 0 1.4-.63 1.4-1.4v-7.2c0-.77-.63-1.4-1.4-1.4h-4.1Z"
                  ></path>
                  <path d="M15.03 5.84c-2.17 0-3.66.42-4.44 1.59-.37.55-.5 1.17-.55 1.73-.05.44-.04.93-.04 1.39v1.8c0 .4.2.7.38.89.18.17.38.29.54.37.34.15.75.25 1.15.32.83.15 1.9.22 2.93.22 1.03 0 2.1-.07 2.93-.22.4-.07.81-.17 1.15-.32.16-.08.36-.2.54-.37.18-.19.38-.49.38-.9V10.5c0-.44 0-.9-.03-1.32a3.68 3.68 0 0 0-.52-1.73c-.76-1.18-2.25-1.6-4.42-1.6ZM12 10.5c0-.45 0-.82.03-1.15.04-.4.12-.65.22-.81.18-.26.7-.7 2.78-.7s2.58.44 2.74.69c.1.15.18.4.21.8.03.32.02.66.02 1.07v1.47l-.43.1c-.67.12-1.6.18-2.57.18a15.59 15.59 0 0 1-3-.28V10.5ZM11 21a1 1 0 0 1 1-1h6a1 1 0 1 1 0 2h-6a1 1 0 0 1-1-1Zm4.03-19c-3.82 0-6.2 1.12-7.57 3-1.31 1.8-1.51 4.08-1.51 6v3.94A4.45 4.45 0 0 0 2 19.5v11C2 32.02 3.13 34 5.47 34c.58 0 1.09-.12 1.53-.33V44a1 1 0 0 0 1 1h5a1 1 0 0 0 1-1V32h2v12a1 1 0 0 0 1 1h5a1 1 0 0 0 1-1V23.3l2.87 2.74 1.97 1.86.16.14V44a1 1 0 1 0 2 0V28.79h.1c.8 0 1.65-.28 2.27-.9.62-.64.88-1.52.88-2.32 0-.79-.26-1.66-.87-2.3L30 20.78V19h6c0 1.1.9 2 2 2h3a3 3 0 0 0 3-3v-6a3 3 0 0 0-3-3h-3.09c-.2-.58-.76-1-1.41-1H30v-.17a3 3 0 1 0-2 0v10.83l-1.24-1.32h-.01l-.34-.36c-.48-.49-.93-.95-1.36-1.3-.3-.25-.64-.47-1.02-.63V11c0-1.9-.18-4.2-1.47-6-1.35-1.88-3.71-3-7.53-3Zm-7.08 9c0-1.86.21-3.57 1.13-4.83C9.94 5 11.6 4 15.03 4s5.06.99 5.9 2.17c.9 1.25 1.1 2.96 1.1 4.83v4.41c-.35.11-.9.22-1.64.32a46.7 46.7 0 0 1-5.4.28c-1.99 0-3.95-.1-5.4-.28a9.4 9.4 0 0 1-1.64-.32V11ZM12 39.34a3.4 3.4 0 0 0-3 0V36h3v3.34Zm-3 3.31c0-.98.71-1.65 1.5-1.65s1.5.67 1.5 1.65V43H9v-.35Zm9 .35v-.35c0-.98.71-1.65 1.5-1.65s1.5.67 1.5 1.65V43h-3Zm1.5-4a3.4 3.4 0 0 0-1.5.34V36h3v3.34a3.4 3.4 0 0 0-1.5-.34ZM9 34v-8h12v8h-3v-3a1 1 0 0 0-1-1h-4a1 1 0 0 0-1 1v3H9Zm-2-3.5c0 .69-.56 1.5-1.53 1.5C4.53 32 4 31.23 4 30.5V29h3v1.5ZM7 27H4v-7.5c0-.88.32-1.51.8-1.93a3 3 0 0 1 1.67-.69l.08.06c.24.17.52.29.78.37.53.17 1.23.3 2 .4 1.57.2 3.62.3 5.66.3 2.03 0 4.09-.1 5.65-.3.78-.1 1.48-.23 2.01-.4.25-.08.52-.19.75-.35l.4.27c.32.27.66.62 1.13 1.1v.01l.38.39L28 21.56v.92l-1.45 1.44-3.64-3.46c-.25-.24-.55-.46-.91-.46a1 1 0 0 0-1 1v3H9v-3a1 1 0 1 0-2 0v6Zm23-.22v-3.1l.93.98h.01c.17.18.31.51.31.91s-.14.73-.3.91a1.19 1.19 0 0 1-.95.3ZM29 4a1 1 0 1 1 0 2 1 1 0 0 1 0-2Zm1 13v-7h6v7h-6Zm8 2v-8h3a1 1 0 0 1 1 1v6a1 1 0 0 1-1 1h-3Z"></path>
                </svg>
                <span>Measure your impact</span>
                <div>
                  Your posts and helpful actions here help hundreds or thousands
                  of people searching for help.
                </div>
              </Contentaside3>
            </Contentsection1>
            <Contentsection2>
              <div>
                <span>Answers</span>
                <ButtonBox left="705px" top="715px">
                  <div>Score</div>
                  <div>Activity</div>
                  <div>Newest</div>
                </ButtonBox>
                <span>Questions</span>
                <ButtonBox left="1190px" top="715px">
                  <div>Score</div>
                  <div>Activity</div>
                  <div>Newest</div>
                  <div>Views</div>
                </ButtonBox>
              </div>
              <div>
                <Middleaside>
                  <div class="d-flex flex__center h100 s-empty-state p24">
                    <p class="wmx4 m0">
                      You have not{" "}
                      <a href="/questions/how-to-answer">answered</a> any
                      questions
                    </p>
                  </div>
                </Middleaside>
                <Middleaside>
                  <div class="d-flex flex__center h100 s-empty-state p24">
                    <p class="wmx4 m0">
                      You have not <a href="/questions/how-to-ask">asked</a> any
                      questions
                    </p>
                  </div>
                </Middleaside>
              </div>
              <div>
                <span>Tags </span>
                <span>Reputation</span>
              </div>
              <div>
                <Middleaside>
                  <div class="d-flex flex__center h100 s-empty-state p24">
                    <p class="wmx4 m0">
                      You have not participated in any <a href="/tags">tags</a>
                    </p>
                  </div>
                </Middleaside>
                <Middleaside>
                  <div class="d-flex flex__center h100 s-empty-state p24">
                    <p class="wmx4 m0">
                      You have no recent{" "}
                      <a href="/help/whats-reputation">reputation changes</a>.{" "}
                    </p>
                  </div>
                </Middleaside>
              </div>
            </Contentsection2>
            <div>Badges</div>
            <Allaside>
              <div class="d-flex flex__center h100 s-empty-state p24">
                <p class="wmx4 m0">
                  You have not earned any <a href="/help/badges">badges</a>
                </p>
              </div>
            </Allaside>
            <div>Followed posts</div>
            <ButtonBox left="1185px" top="1245px">
              <div>Score</div>
              <div>Activity</div>
              <div>Newest</div>
              <div>Added</div>
            </ButtonBox>
            <Allaside>
              <div class="d-flex flex__center h100 s-empty-state p24">
                <p class="wmx4 m0">
                  You are not{" "}
                  <a href="https://meta.stackexchange.com/questions/345661/the-follow-questions-and-answers-feature-is-now-live-across-the-network">
                    following any posts
                  </a>
                  .{" "}
                </p>
              </div>
            </Allaside>
            <div>Accounts</div>
            <Allaside>
              <div class="d-flex ai-center">
                <div class="flex--item mr12">
                  <div
                    class="favicon favicon-stackoverflow favicon"
                    title="Stack Overflow"
                  ></div>
                </div>
                <a
                  class="flex--item s-link fs-body2"
                  href="https://stackoverflow.com/users/20813270/"
                >
                  Stack Overflow
                </a>
              </div>
            </Allaside>
            <div>Active bounties (0)</div>
            <ButtonBox left="1240px" top="1580px">
              <div>Active</div>
              <div>Offered</div>
              <div>Earned</div>
            </ButtonBox>
            <Allaside>
              <div class="d-flex flex__center h100 s-empty-state p24">
                <p class="wmx4 m0">
                  You have no active{" "}
                  <a href="https://stackoverflow.com/help/bounty">bounties</a>{" "}
                </p>
              </div>
            </Allaside>
            <div>Articles</div>
            <ButtonBox left="1190px" top="1750px">
              <div>Score</div>
              <div>Activity</div>
              <div>Newest</div>
              <div>Views</div>
            </ButtonBox>
            <Allaside>
              <div class="d-flex flex__center h100 s-empty-state p24">
                <p class="wmx4 m0">
                  You have not created any{" "}
                  <a href="/help/propose-article">articles</a>.
                </p>
              </div>
            </Allaside>
            <div>Votes cast</div>
            <Allaside>
              <div class="d-flex flex__center h100 s-empty-state p24">
                <p class="wmx4 m0">
                  You have not cast any <a href="/help/why-vote">votes</a>{" "}
                </p>
              </div>
            </Allaside>
          </Contentdiv>
        </Maindiv>
      </Pagedov>
    </>
  );
}

export default Profile;
