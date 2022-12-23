import React from "react";
import styled from "styled-components";

const UserCardItems = styled.div`
  display: flex;
  flex-direction: row;
  color: black;
  font-size: 13px;
  text-align: left;
  padding: 12px;
  /* border: 1px solid rgb(214, 217, 220); */

  .ImgDiv {
    /* display: flex */
    margin: 15px;
    
  }
  .UserInfo{
    display: flex;
    flex-direction: column;
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
  return (
    <UserCardItems>
      <div className="ImgDiv">
        <img
          src="https://www.gravatar.com/avatar/ee6e12042dc31b1ef27471482f9ff91f?s=96&amp;d=identicon&amp;r=PG&amp;f=1"
          alt="akrun's user avatar"
          width="48"
          height="48"
          class="bar-sm"
        ></img>
      </div>
        <div className="UserInfo">
          <div className="UserName">akrun {/* 링크 넣기 */}</div>
          <div className="UserTags">r, dplyr, dataframe</div>
        </div>
    </UserCardItems>
  );
};

export default UserCardItem;
