import React, { useState } from "react";
import styled from "styled-components";
import "../assets/fonts.css";
import { createGlobalStyle } from "styled-components";

const GlobalStyle = createGlobalStyle`

`;

const PageDiv = styled.div`
  width: 100vw;
  display: flex;
  flex-direction: column;
  padding-top: 40px;
`;

const PageHeader = styled.header`
  height: 120px;
  display: flex;
  flex-direction: row;
`;

const Headernamediv = styled.div`
  border: border-box;
  color: rgb(59, 64, 69);
  font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Oxygen,
    Ubuntu, Cantarell, "Open Sans", "Helvetica Neue", sans-serif;
  text-align: left;
  font-size: 40px;
  height: 937px;
  width: 1265px;
  line-height: 50px;
  min-width: 0px;
`;
const Askbuttondiv = styled.div`
  width: 180px;
  height: 120px;
  padding-top: 20px;
`;

const Importmationdiv = styled.div`
  color: #6a737c;
  font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Oxygen,
    Ubuntu, Cantarell, "Open Sans", "Helvetica Neue", sans-serif;
  text-align: left;
  font-size: 12px;
`;

const Importmationspan = styled.span`
  color: #232629;
  margin: 5px 50px 3px 10px;
`;

const ImportmationMain = styled.main`
  display: flex;
  padding: 30px 100px 3px 100px;
  flex-direction: row;
`;

const Contentsdiv = styled.div`
  width: 1000px;
  display: flex;
  flex-direction: row;
`;
const Recomneddiv = styled.div`
  background-color: white;
  display: flex;
  flex-direction: column;
  width: 100px;
  color: #6a737c;
  i {
    margin-bottom: 10px;
    margin-top: 10px;
  }
`;
const Qustioncontentdiv = styled.div`
  width: 900px;
  padding: 15px 30px 3px 30px;
  background-color: white;
  font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Oxygen,
    Ubuntu, Cantarell, "Open Sans", "Helvetica Neue", sans-serif;
  text-align: left;
  font-size: 20px;
  height: auto;
  line-height: 40px;
  color: black;
`;
const Codediv = styled.div`
  background-color: #f6f6f6;
  font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Oxygen,
    Ubuntu, Cantarell, "Open Sans", "Helvetica Neue", sans-serif;
  text-align: left;
  font-size: 20px;
  height: 937px;
  line-height: 40px;
  margin-top: 60px;
  height: 300px;
  color: black;
`;
const Tagboxdiv = styled.div`
  display: flex;
  flex-direction: row;
  margin-top: 30px;
`;

const Tagsdiv = styled.div`
  background-color: #e1ecf4;
  color: #39739d;
  font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Oxygen,
    Ubuntu, Cantarell, "Open Sans", "Helvetica Neue", sans-serif;
  text-align: center;
  font-size: 15px;
  border-radius: 5px;
  margin: 2px 2px 2px 0;
  padding: 0 6px 0px 6px;
`;

const BolgAndReateddiv = styled.div`
  background-color: white;
  width: 550px;
  font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Oxygen,
    Ubuntu, Cantarell, "Open Sans", "Helvetica Neue", sans-serif;
  text-align: left;
  font-size: 23px;
  display: flex;
  color: black;
  padding: 30px 40px 0px 60px;
  flex-direction: column;
`;
const Relateddiv = styled.div`
  display: flex;
  flex-direction: row;
  margin-top: 30px;
  font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Oxygen,
    Ubuntu, Cantarell, "Open Sans", "Helvetica Neue", sans-serif;
  font-size: 20px;
  text-align: left;
  color: #00f4cc;
`;

const Relatedboxdiv = styled.div`
  width: 60px;
  height: 30px;
  margin: 0px 20px 0px 0px;
  background-color: ${(props) => (props.color ? props.color : "white")};
  text-align: center;
  border-radius: 5px;
`;

const Questioninput = styled.input`
  box-sizing: border-box;
  width: 840px;
  height: 300px;
  margin: 60px 20px 0px 0px;
  text-align: left;
  border: solid 1px;
  border-radius: 5px;
`;

const Postbuttondiv = styled.div`
  width: 180px;
  height: 120px;
  margin: 10px 0px 0px 690px;
`;

function DetailsQustion() {
  const [Number, SetNumber] = useState(0);
  const [Bookmark, SetBookmark] = useState(true);

  const up = () => {
    SetNumber(Number + 1);
  };
  const Down = () => {
    SetNumber(Number - 1);
  };

  const BookmarkHandler = () => {
    SetBookmark(!Bookmark);
  };

  return (
    <PageDiv>
      <PageHeader>
        <Headernamediv>
          How to run "AND" operator with "filter()" without "SyntaxError:
          keyword argument repeated:" error in Django?
          <Importmationdiv>
            Asked <Importmationspan>today</Importmationspan> Modified{" "}
            <Importmationspan>today</Importmationspan>
            Viewed <Importmationspan>2 times</Importmationspan>
          </Importmationdiv>
        </Headernamediv>
        <Askbuttondiv>
          <a
            href="…"
            class="s-topbar--item s-topbar--item__unset ml4 s-btn s-btn__primary"
          >
            Ask Question
          </a>
        </Askbuttondiv>
      </PageHeader>
      <ImportmationMain>
        <Contentsdiv>
          <Recomneddiv>
            <i class="fa-solid fa-caret-up fa-4x" onClick={up}></i>
            {Number}
            <i
              class="fa-solid fa-caret-up fa-rotate-180 fa-4x"
              onClick={Down}
            ></i>
            {Bookmark ? (
              <i class="fa-regular fa-bookmark" onClick={BookmarkHandler}></i>
            ) : (
              <i class="fa-solid fa-bookmark" onClick={BookmarkHandler}></i>
            )}

            <i class="fa-solid fa-clock-rotate-left"></i>
          </Recomneddiv>
          <Qustioncontentdiv>
            I want to print the details of the packets that is capture using
            pyshark. I want the details of the packet like info of packet,
            source-ip, destination-ip, protocol(like, unp, tcp, imp, arp, dns
            etc). <br />
            <br />I use the code below.
            <Codediv>
              import pyshark import time capture =
              pyshark.LiveCapture(interface='eth0') capture.sniff(timeout=5) for
              packet in capture.sniff_continuously(): localtime =
              time.asctime(time.localtime(time.time())) protocol =
              packet.transport_layer src_addr = packet.ip.src src_port =
              packet[packet.transport_layer].srcport dst_addr = packet.ip.dst
              dst_port = packet[packet.transport_layer].dstport info =
              packet.info print (info, localtime,"\t",protocol,"\t",
              src_addr,"\t", src_port,"\t", dst_addr) # print (packet.show())
            </Codediv>
            <Tagboxdiv>
              <Tagsdiv>python</Tagsdiv>
              <Tagsdiv>tcp</Tagsdiv>
              <Tagsdiv>protocols</Tagsdiv>
              <Tagsdiv>arp</Tagsdiv>
              <Tagsdiv>icmp</Tagsdiv>
            </Tagboxdiv>
            <Questioninput />
            <Postbuttondiv>
              <a
                href="…"
                class="s-topbar--item s-topbar--item__unset ml4 s-btn s-btn__primary"
              >
                Post your Answer
              </a>
            </Postbuttondiv>
          </Qustioncontentdiv>
        </Contentsdiv>
        <BolgAndReateddiv>
          Related
          <Relateddiv>
            <Relatedboxdiv color="#f1f2f3">0</Relatedboxdiv>
            <a
              href="https://stackoverflow.com/questions/5805269/why-does-this-connection-keep-closing-syn-syn-ack-ack-rst-ack?rq=1"
              class="question-hyperlink"
            >
              Why does this connection keep closing -
              SYN-&gt;SYN,ACK-&gt;ACK-&gt;RST,ACK
            </a>
          </Relateddiv>
          <Relateddiv>
            <Relatedboxdiv color="#52ba7D">0</Relatedboxdiv>
            <a
              href="https://stackoverflow.com/questions/5805269/why-does-this-connection-keep-closing-syn-syn-ack-ack-rst-ack?rq=1"
              class="question-hyperlink"
            >
              Why does this connection keep closing -
              SYN-&gt;SYN,ACK-&gt;ACK-&gt;RST,ACK
            </a>
          </Relateddiv>
          <Relateddiv>
            <Relatedboxdiv color="#f1f2f3">5</Relatedboxdiv>
            <a
              href="https://stackoverflow.com/questions/5805269/why-does-this-connection-keep-closing-syn-syn-ack-ack-rst-ack?rq=1"
              class="question-hyperlink"
            >
              Why does this connection keep closing -
              SYN-&gt;SYN,ACK-&gt;ACK-&gt;RST,ACK
            </a>
          </Relateddiv>
        </BolgAndReateddiv>
      </ImportmationMain>
    </PageDiv>
  );
}

export default DetailsQustion;
