import React, { useState, useEffect } from "react";
import styled from "styled-components";
import axios from "axios";

const UserCardItems = styled.div`
  display: block;
  height: auto;

  .TagDiV {
    display: grid;
    gap: 16px;
    grid-template-columns: repeat(4, minmax(0, 1fr));
    gap: 15px;
    margin-top: 15px;
    width: 100%;
    min-width: 150px;
  }
  .ImgDiv {
    margin: 15px;
  }
  .UserInfo {
    margin: 12px 0px 0px 20px;
  }
  .UserName {
    color: #0074cc;
    font-size: 15px;
  }
  .UserTags {
    color: #0074cc;
    font-size: 12px;
    margin-top: 12px;
  }
`;

const UserCardItem = () => {
  let [questionData, setQuestionData] = useState([]);

  useEffect(() => {
    axios
      .get(`/questions`, {})
      .then((response) => {
        setQuestionData(response.data.data);
      })
      .catch((error) => {
        console.log(error);
      });
  }, []);

  return (
    <UserCardItems>
      <div className="TagDiV">
        {questionData &&
          questionData.map((item) => {
            return (
              <div className="UserInfo" key={item.tagId}>
                <div className="ImgDiv">
                  <img
                    src="https://item.kakaocdn.net/do/07bb1aba0886fcbb13e65c7a0b712e627f9f127ae3ca5dc7f0f6349aebcdb3c4"
                    width="60"
                    height="60"
                    alt="user avatar"
                  ></img>
                </div>
                <div className="UserName"> {item.memberName}</div>
                <div className="UserTags">
                  {item.tagResponseDtos[0].category}, javascript, java, git, github
                </div>
              </div>
            );
          })}
      </div>
    </UserCardItems>
  );
};

export default UserCardItem;
