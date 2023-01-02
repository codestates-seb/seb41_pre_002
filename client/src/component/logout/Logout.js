import React from 'react';
import styled from 'styled-components';
import { SiAskubuntu } from 'react-icons/si';
import StackExchange from './stackexchangeSvg';
import StackOverflow from './stackoverflowsvg';
import StackApp from './stackapp';
import ServerFault from './sverfalutsvg';
import MathoverFlow from './mathoverflowsvg';
import axios from 'axios';

const Container = styled.div`
  background-color: #f1f2f3;
  width: 100vw;
  height: auto;
  min-height: 750px;
`;
const ContentDiv = styled.div`
  padding: 100px 25px 25px 25px;

  .LogoutHeader {
    font-size: 21px;
    margin-bottom: 40px;
    text-align: center;
    margin-left: auto;
    margin-right: auto;
  }
  .flex--item--severfalut {
    padding-left: 10px;
  }
  .flex--item--askubuntu {
    padding-left: 15px;
  }
`;

const Logout = ({ setIsLogin }) => {
  const logoutHandler = async () => {
    axios.defaults.headers.common['Authorization'] = '';
    setIsLogin(false).then((res) => {
      alert('로그아웃');
      window.location.replace('/');
    });
  };

  return (
    <>
      <Container>
        <ContentDiv>
          <div className="LogoutHeader">Clicking "Log out" will log you out of the following domains on this device:</div>
          {/* 로그아웃 창 */}
          <div className="Links">
            <form class="wmx3 mx-auto mb24 p24 bg-white bar-lg bs-xl">
              <ul class="list-reset fs-body2 d-flex fd-column gs8 gsy mb16 bb bc-black-100 pb12">
                <li class="flex--item">
                  <a href="https://askubuntu.com" class="d-flex ai-center gs8">
                    <SiAskubuntu color="#F48024" />
                    <div class="flex--item--askubuntu">askubuntu.com</div>
                  </a>
                </li>
                <li class="flex--item">
                  <a href="https://mathoverflow.net" class="d-flex ai-center gs8">
                    <div class="flex--item">
                      <MathoverFlow />
                    </div>
                    <div class="flex--item">mathoverflow.net</div>
                  </a>
                </li>
                <li class="flex--item">
                  <a href="https://serverfault.com" class="d-flex ai-center gs8">
                    <ServerFault />
                    <div class="flex--item--severfalut">serverfault.com</div>
                  </a>
                </li>
                <li class="flex--item">
                  <a href="https://stackapps.com" class="d-flex ai-center gs8">
                    <div class="flex--item">
                      <StackApp />
                    </div>
                    <div class="flex--item">stackapps.com</div>
                  </a>
                </li>
                <li class="flex--item">
                  <a href="https://stackexchange.com" class="d-flex ai-center gs8">
                    <div class="flex--item">
                      <StackExchange />
                    </div>
                    <div class="flex--item">stackexchange.com</div>
                  </a>
                </li>
                <li class="flex--item">
                  <a href="https://stackoverflow.com" class="d-flex ai-center gs8">
                    <div class="flex--item">
                      <StackOverflow />
                    </div>
                    <div class="flex--item">stackoverflow.com</div>
                  </a>
                </li>
                <li class="flex--item">
                  <a href="https://superuser.com" class="d-flex ai-center gs8">
                    <div class="flex--item">
                      <img src="https://cdn.sstatic.net/Sites/superuser/Img/icon-48.png" alt="Super User" width={18}></img>
                    </div>
                    <div class="flex--item">superuser.com</div>
                  </a>
                </li>
              </ul>
              <div class="d-flex mb16">
                <div class="flex--item mr4">
                  <input type="checkbox" name="everywhere" id="everywhere" class="s-checkbox"></input>
                </div>
                <div class="flex--item pt2">
                  <label for="everywhere" class="s-label fw-normal fs-caption px0">
                    Log out on all devices
                  </label>
                </div>
              </div>
              <div class="d-flex gs4">
                <button class="flex--item s-btn s-btn__primary" onClick={logoutHandler}>
                  Log out
                </button>
                <a class="flex--item s-btn" href="/">
                  Cancel
                </a>
              </div>

              <div class="fs-caption fc-light ta-left mt32">
                If you’re on a shared computer, remember to log out of your Open ID provider (Facebook, Google, Stack Exchange, etc.) as well.
              </div>
            </form>
          </div>
        </ContentDiv>
      </Container>
    </>
  );
};

export default Logout;
