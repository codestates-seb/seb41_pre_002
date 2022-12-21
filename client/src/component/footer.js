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
  height: 30px;
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
            <Namediv>최효병</Namediv>
            <Rounddiv>fornt-end</Rounddiv>
          </Chidiv>
          <Shidiv>
            <a href="https://github.com/samsamgo">
              <i class="fa-brands fa-github fa-8x"></i>
            </a>
            <Namediv>김시형</Namediv>
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
      {/* <footer id="footer" class="site-footer js-footer" role="contentinfo">
        <div class="site-footer--container">
                <div class="site-footer--logo">

                    <a href="https://stackoverflow.com" aria-label="Stack Overflow"><svg aria-hidden="true" class="native svg-icon iconLogoGlyphMd" width="32" height="37" viewBox="0 0 32 37"><path d="M26 33v-9h4v13H0V24h4v9h22Z" fill="#BCBBBB"></path><path d="m21.5 0-2.7 2 9.9 13.3 2.7-2L21.5 0ZM26 18.4 13.3 7.8l2.1-2.5 12.7 10.6-2.1 2.5ZM9.1 15.2l15 7 1.4-3-15-7-1.4 3Zm14 10.79.68-2.95-16.1-3.35L7 23l16.1 2.99ZM23 30H7v-3h16v3Z" fill="#F48024"></path></svg></a>
                </div>
            <nav class="site-footer--nav">
                    <div class="site-footer--col">
                        <h5 class="-title"><a href="https://stackoverflow.com" class="js-gps-track" data-gps-track="footer.click({ location: 1, link: 15})">Stack Overflow</a></h5>
                        <ul class="-list js-primary-footer-links">
                            <li><a href="/questions" class="js-gps-track -link" data-gps-track="footer.click({ location: 1, link: 16})">Questions</a></li>
                                <li><a href="/help" class="js-gps-track -link" data-gps-track="footer.click({ location: 1, link: 3 })">Help</a></li>
                        </ul>
                    </div>
                    <div class="site-footer--col">
                        <h5 class="-title"><a href="https://stackoverflow.co/" class="js-gps-track" data-gps-track="footer.click({ location: 1, link: 19 })">Products</a></h5>
                        <ul class="-list">
                            <li><a href="https://stackoverflow.co/teams" class="js-gps-track -link" data-ga="[&quot;teams traffic&quot;,&quot;footer - site nav&quot;,&quot;stackoverflow.com/teams&quot;,null,{&quot;dimension4&quot;:&quot;teams&quot;}]" data-gps-track="footer.click({ location: 1, link: 29 })">Teams</a></li>
                            <li><a href="https://stackoverflow.co/advertising" class="js-gps-track -link" data-gps-track="footer.click({ location: 1, link: 21 })">Advertising</a></li>
                            <li><a href="https://stackoverflow.co/collectives" class="js-gps-track -link" data-gps-track="footer.click({ location: 1, link: 40 })">Collectives</a></li>
                            <li><a href="https://stackoverflow.co/talent" class="js-gps-track -link" data-gps-track="footer.click({ location: 1, link: 20 })">Talent</a></li>
                        </ul>
                    </div>
                <div class="site-footer--col">
                    <h5 class="-title"><a class="js-gps-track" data-gps-track="footer.click({ location: 1, link: 1 })" href="https://stackoverflow.co/">Company</a></h5>
                    <ul class="-list">
                            <li><a class="js-gps-track -link" data-gps-track="footer.click({ location: 1, link: 1 })" href="https://stackoverflow.co/">About</a></li>
                        <li><a class="js-gps-track -link" data-gps-track="footer.click({ location: 1, link: 27 })" href="https://stackoverflow.co/company/press">Press</a></li>
                            <li><a class="js-gps-track -link" data-gps-track="footer.click({ location: 1, link: 9 })" href="https://stackoverflow.co/company/work-here">Work Here</a></li>
                        <li><a class="js-gps-track -link" data-gps-track="footer.click({ location: 1, link: 7 })" href="https://stackoverflow.com/legal">Legal</a></li>
                        <li><a class="js-gps-track -link" data-gps-track="footer.click({ location: 1, link: 8 })" href="https://stackoverflow.com/legal/privacy-policy">Privacy Policy</a></li>
                        <li><a class="js-gps-track -link" data-gps-track="footer.click({ location: 1, link: 37 })" href="https://stackoverflow.com/legal/terms-of-service">Terms of Service</a></li>
                            <li><a class="js-gps-track -link" data-gps-track="footer.click({ location: 1, link: 13 })" href="https://stackoverflow.co/company/contact">Contact Us</a></li>
                            <li class="" id="consent-footer-link"><a class="js-gps-track -link js-cookie-settings" data-gps-track="footer.click({ location: 1, link: 38 })" href="#" data-consent-popup-loader="footer">Cookie Settings</a></li>
                        <li><a class="js-gps-track -link" data-gps-track="footer.click({ location: 1, link: 39 })" href="https://stackoverflow.com/legal/cookie-policy">Cookie Policy</a></li>
                    </ul>
                </div>
                <div class="site-footer--col site-footer--categories-nav">
                    <div>
                        <h5 class="-title"><a href="https://stackexchange.com" data-gps-track="footer.click({ location: 1, link: 30 })">Stack Exchange Network</a></h5>
                        <ul class="-list">
                            <li>
                                <a href="https://stackexchange.com/sites#technology" class="-link js-gps-track" data-gps-track="footer.click({ location: 1, link: 24 })">
                                    Technology
                                </a>
                            </li>
                            <li>
                                <a href="https://stackexchange.com/sites#culturerecreation" class="-link js-gps-track" data-gps-track="footer.click({ location: 1, link: 24 })">
                                    Culture &amp; recreation
                                </a>
                            </li>
                            <li>
                                <a href="https://stackexchange.com/sites#lifearts" class="-link js-gps-track" data-gps-track="footer.click({ location: 1, link: 24 })">
                                    Life &amp; arts
                                </a>
                            </li>
                            <li>
                                <a href="https://stackexchange.com/sites#science" class="-link js-gps-track" data-gps-track="footer.click({ location: 1, link: 24 })">
                                    Science
                                </a>
                            </li>
                            <li>
                                <a href="https://stackexchange.com/sites#professional" class="-link js-gps-track" data-gps-track="footer.click({ location: 1, link: 24 })">
                                    Professional
                                </a>
                            </li>
                            <li>
                                <a href="https://stackexchange.com/sites#business" class="-link js-gps-track" data-gps-track="footer.click({ location: 1, link: 24 })">
                                    Business
                                </a>
                            </li>

                            <li class="mt16 md:mt0">
                                <a href="https://api.stackexchange.com/" class="-link js-gps-track" data-gps-track="footer.click({ location: 1, link: 24 })">
                                    API
                                </a>
                            </li>

                            <li>
                                <a href="https://data.stackexchange.com/" class="-link js-gps-track" data-gps-track="footer.click({ location: 1, link: 24 })">
                                    Data
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
            <div class="site-footer--copyright fs-fine md:mt24">
                <ul class="-list -social md:mb8">
                    <li><a class="js-gps-track -link" data-gps-track="footer.click({ location: 1, link:4 })" href="https://stackoverflow.blog?blb=1">Blog</a></li>
                    <li><a href="https://www.facebook.com/officialstackoverflow/" class="-link js-gps-track" data-gps-track="footer.click({ location: 1, link: 31 })">Facebook</a></li>
                    <li><a href="https://twitter.com/stackoverflow" class="-link js-gps-track" data-gps-track="footer.click({ location: 1, link: 32 })">Twitter</a></li>
                    <li><a href="https://linkedin.com/company/stack-overflow" class="-link js-gps-track" data-gps-track="footer.click({ location: 1, link: 33 })">LinkedIn</a></li>
                    <li><a href="https://www.instagram.com/thestackoverflow" class="-link js-gps-track" data-gps-track="footer.click({ location: 1, link: 36 })">Instagram</a></li>
                </ul>

                <p class="md:mb0">
Site design / logo © 2022 Stack Exchange Inc; user contributions licensed under <span class="td-underline"><a href="https://stackoverflow.com/help/licensing">CC BY-SA</a></span>.                    <span id="svnrev">rev&nbsp;2022.12.19.43125</span>
                </p>
            </div>
        </div>

    </footer> */}
    </>
  );
};

export default Footer;
