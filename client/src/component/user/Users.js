import React, { useState } from "react";
import styled from "styled-components";
import UserCardItem from "./UserCardItem";

const UserDiv = styled.div`
  display: block;
  padding: 30px;
  min-width: 200px;
  width: 70%;
  background-color: aqua;

  h1 {
    text-align: left;
    font-size: 27px;
    margin: 0px 0px 27px;
    color: black;
    font-weight: 400;
  }
  .UserInputDiv {
    display: flex;
    justify-content: space-between;
    align-items: flex-start;
    width: 100%;
    height: 50px;
  }
  .SubTab {
    display: flex;
    flex-direction: row;
    justify-content: flex-end;
    width: 100%;
    min-width: 100px;
  }
  .Tab {
    color: #6a737c;
    font-size: 13px;
    padding: 10px;
    &:active {
      color: black;
      font-weight: 700;
      border-bottom: 2px solid orange;
    }
  }
  .sort {
    width: 100%;
    display: flex;
    justify-content: flex-end;
    float: right;
    align-items: center;
    min-width: 100px;
    margin-bottom: 20px;
    @media screen and (max-width: 640px) {
      font-size: 15.4px;
      flex-direction: column !important;
      align-items: flex-start;
      gap: 10px;
      margin-bottom: 10px;
    }
    > .question-sort {
      > button {
        height: 40px;
        width: 80px;
        font-size: 13px;
        border: 1px solid hsl(210, 8%, 55%);
        background-color: var(--_bu-outlined-bg);
        padding: 8px 10px;
        color: hsl(210, 8%, 45%);
        @media screen and (max-width: 640px) {
          flex-direction: column-reverse;
        }
        cursor: pointer;
        :first-child {
          border-radius: 3px;
          border-top-right-radius: 0;
          border-bottom-right-radius: 0;
        }
        :last-child {
          border-radius: 3px;
          border-top-left-radius: 0;
          border-bottom-left-radius: 0;
        }
        :not(:last-child) {
          border-right: none;
        }
        :hover {
          background-color: hsl(210, 8%, 97.5%);
        }
        &.is-selected {
          background-color: hsl(210, 8%, 90%);
          color: hsl(210, 8%, 25%);
          border: 1px solid hsl(210, 8%, 55%);
          :not(:last-child) {
            border-right: none;
          }
        }
      }
    }
  }
`;

const Users = () => {
  const [selected, setSelected] = useState("New users");
  // redux?
  const sortClick = (e) => {
    switch (e.target.value) {
      case "Reputation":
        setSelected("Reputation");
        break;
      case "New users":
        setSelected("New users");
        break;
      case "Voters":
        setSelected("Voters");
        break;
      case "Editors":
        setSelected("Editors");
        break;
      case "Moderators":
        setSelected("Moderators");
        break;
      default:
        break;
    }
  };

  // 빈값으로 초기세팅
  const [inputValue, setInputValue] = useState({
    // title: '',
    users: "",
  });

  //inputvalue 값 추출 -> input 의 value 속성에 추출한 값 할당
  const { users } = inputValue;

  const onChangeValue = (e) => {
    setInputValue({
      ...inputValue,
      [e.target.name]: e.target.value,
    });
    console.log(inputValue);
  };

  return (
    <UserDiv>
      <h1>Users</h1>
      <div className="UserInputDiv">
        <div className="flex--item ps-relative mb12">
          <input
            id="userfilter"
            defaultValue={users}
            className="s-input s-input__search h100 js-tag-filter"
            autoComplete="off"
            name="users"
            type="text"
            maxLength="35"
            placeholder="Filter by user name"
            autoFocus=""
            // onChange={onChangeValue}
          ></input>
          <svg
            aria-hidden="true"
            className="s-input-icon s-input-icon__search svg-icon iconSearch"
            width="18"
            height="18"
            viewBox="0 0 18 18"
          >
            <path d="m18 16.5-5.14-5.18h-.35a7 7 0 1 0-1.19 1.19v.35L16.5 18l1.5-1.5ZM12 7A5 5 0 1 1 2 7a5 5 0 0 1 10 0Z"></path>
          </svg>
        </div>
      </div>
      <div className="sort">
        <div className="question-sort">
          <button
            onClick={sortClick}
            className={selected === "Reputation" ? "is-selected" : ""}
            value={"Reputation"}
          >
            Reputation
          </button>
          <button
            onClick={sortClick}
            className={selected === "New users" ? "is-selected" : ""}
            value={"New users"}
          >
            New users
          </button>
          <button
            onClick={sortClick}
            className={selected === "Voters" ? "is-selected" : ""}
            value={"Voters"}
          >
            Voters
          </button>
          <button
            onClick={sortClick}
            className={selected === "Editors" ? "is-selected" : ""}
            value={"Editors"}
          >
            Editors
          </button>
          <button
            onClick={sortClick}
            className={selected === "Moderators" ? "is-selected" : ""}
            value={"Moderators"}
          >
            Moderators
          </button>
        </div>
      </div>
      <div className="SubTab">
        <div className="Tab">week</div>
        <div className="Tab">month</div>
        <div className="Tab">quarter</div>
        <div className="Tab">year</div>
        <div className="Tab">all</div>
      </div>
      <UserCardItem />
    </UserDiv>
  );
};

export default Users;
