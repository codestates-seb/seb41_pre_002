import React from "react";
import styled from "styled-components";
import UserCardItem from "./UserCardItem";

const UserCardList = styled.div`
  display: grid;
  grid-template-columns: repeat(4, minmax(0, 1fr));
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
