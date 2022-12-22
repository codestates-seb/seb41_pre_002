import React from "react";
import styled from "styled-components";
import "../assets/fonts.css";
import { createGlobalStyle } from "styled-components";

const GlobalStyle = createGlobalStyle`

`;

const PageDiv = styled.div`
  width: 100vw;
  display: flex;
  flex-direction: column;
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
  font-size: 30px;
  height: 937px;
  line-height: 40px;
  min-width: 0px;
`;
const Askbuttondiv = styled.div`
  width: 180px;
  height: 120px;
  background-color: aqua;
  color: black;
`;

const Importmationdiv = styled.div`
  background-color: antiquewhite;
`;

const ImportmationMain = styled.main`
  display: flex;
  padding: 5px 100px 3px 100px;
  flex-direction: row;
  background-color: black;
  color: aqua;
`;

const Contentsdiv = styled.div`
  width: 1000px;
  display: flex;
  flex-direction: row;
`;
const Recomneddiv = styled.div`
  background-color: yellow;
  display: flex;
  flex-direction: column;
  width: 100px;
  color: brown;
`;
const Qustioncontentdiv = styled.div`
  width: 900px;
  padding: 15px 30px 3px 30px;
  background-color: white;
  font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Oxygen,
    Ubuntu, Cantarell, "Open Sans", "Helvetica Neue", sans-serif;
  text-align: left;
  font-size: 20px;
  height: 937px;
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
  background-color: blue;
  width: 550px;
`;

function DetailsQustion() {
  return (
    <PageDiv>
      <PageHeader>
        <Headernamediv>
          How to run "AND" operator with "filter()" without "SyntaxError:
          keyword argument repeated:" error in Django?
          <Importmationdiv>
            Asked today Modified today Viewed 2 times
          </Importmationdiv>
        </Headernamediv>
        <Askbuttondiv />
      </PageHeader>

      <ImportmationMain>
        <Contentsdiv>
          <Recomneddiv>
            <i class="fa-solid fa-caret-up fa-4x"></i>0
            <i class="fa-solid fa-caret-up fa-rotate-180 fa-4x"></i>
            <i class="fa-light fa-bookmark"></i>
            <i class="fa-solid fa-timer"></i>
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
          </Qustioncontentdiv>
        </Contentsdiv>
        <BolgAndReateddiv>sdfsdf</BolgAndReateddiv>
      </ImportmationMain>
    </PageDiv>
  );
}

export default DetailsQustion;
