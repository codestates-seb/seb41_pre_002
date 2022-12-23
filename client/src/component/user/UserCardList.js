import React from "react";
import styled from "styled-components";
import UserCardItem from "./UserCardItem";

const UserCardList = styled.div`
  display: grid;
  grid-template-rows: repeat(4, 100px);
  grid-template-columns: repeat(4, 250px);
  gap: 15px;
  margin-top: 15px;
`;

const UserCard = () => {
  return (
    <>
      <UserCardList>
        <UserCardItem />
        <UserCardItem />
        <UserCardItem />
        <UserCardItem />
        <UserCardItem />
        <UserCardItem />
        <UserCardItem />
        <UserCardItem />
        <UserCardItem />
        <UserCardItem />
        <UserCardItem />
        <UserCardItem />
        <UserCardItem />
        <UserCardItem />
        <UserCardItem />
        <UserCardItem />
      </UserCardList>
    </>
  );
};

export default UserCard;
