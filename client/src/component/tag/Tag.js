import React, { useState, useEffect } from "react";
import styled from "styled-components";
import TagCardItem from "./TagCardItem";
import axios from "axios";

const TagDIV = styled.div`
  display: block;
  padding: 30px;
  width: 70%;
  min-width: 200px;

  h1 {
    text-align: left;
    font-size: 27px;
    margin: 0px 0px 27px;
    color: black;
    font-weight: 400;
  }
  p {
    color: #232629;
    text-align: left;
    font-size: 15px;
    max-width: 625px;
    margin: 0px 0px 27px;
  }
  .TagSearchDiv {
    width: 200px;
  }

  .ButtonBox {
    display: flex;
    border-color: var(--_bu-outlined-bc-selected);
    border-radius: 10px;
    min-width: 100px;
  }
  .Btn {
    height: 40px;
    width: 60px;
    background-color: var(--_bu-outlined-bg);
    border-color: var(--_bu-outlined-bc-selected);
    color: black;
    font-size: 13px;
    font-weight: 400;
    border: 1px solid rgb(214, 217, 220);
    &:active {
      border-color: rgb(227, 230, 232);
      background-color: rgb(227, 230, 232);
      color: rgb(59, 64, 60);
    }
    &:hover {
      background-color: rgb(242, 244, 245);
    }
  }
  .sort {
    width: 100%;
    display: flex;
    justify-content: flex-end;
    float: right;
    align-items: center;
    min-width: 100px;
    margin-bottom: 15px;

    @media screen and (max-width: 640px) {
      font-size: 15.4px;
      flex-direction: column !important;
      align-items: flex-start;
      gap: 10px;
      margin-bottom: 10px;
    }
    > .question-sort {
      margin-bottom: 12px;
      > button {
        height: 40px;
        width: 60px;
        font-size: 13px;
        border: 1px solid hsl(210, 8%, 55%);
        padding: 8px 10px;
        color: hsl(210, 8%, 45%);
        background-color: var(--_bu-outlined-bg);
        @media screen and (max-width: 640px) {
          height: 35.44px;
          padding-left: 0.4em;
          padding-right: 0.4em;
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

const Tag = () => {
  const [tagsAll, setTagsAll] = useState([]);
  const [tagsName, setTagsName] = useState([]);


  useEffect(() => {
    axios
      .all([
        axios.get("/tags"),
        axios.get("/tags?page=1&size=10&keyword=&tab=name"),
        axios.get("/tags?page=1&size=10&keyword=&tab=new"),
      ])
      .then(
        axios.spread((response1, response2) => {
          setTagsAll(response1.data.data);
          setTagsName(response2.data.data);
        })
      )
      .catch((error) => {
        console.log(error);
      });
  }, []);

  const [selected, setSelected] = useState("Popular");

  const sortClick = (e) => {
    switch (e.target.value) {
      case "Popular":
        setSelected("Popular");
        break;
      case "Name":
        setSelected("Name");
        break;
      case "New":
        setSelected("New");
        break;
      default:
        break;
    }
  };

  return (
    <TagDIV>
      {/* tag 페이지 상단 */}
      <h1>Tags</h1>
      {
        <p className="TagPar">
          A tag is a keyword or label that categorizes your question with other,
          similar questions.<br></br> Using the right tags makes it easier for
          others to find and answer your question.
        </p>
      }
      {/*tag input && buttion div 묶음 */}

      <div className="TagSearchDiv">
        <div className="flex--item ps-relative mb12">
          <input
            id="tagfilter"
            className="s-input s-input__search h100 js-tag-filter"
            autoComplete="off"
            name="tags"
            type="text"
            maxLength="35"
            placeholder="Filter by tag name"
            autoFocus=""
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
            className={selected === "Popular" ? "is-selected" : ""}
            value={"Popular"}
          >
            Popular
          </button>
          <button
            onClick={sortClick}
            className={selected === "Name" ? "is-selected" : ""}
            value={"Name"}
          >
            Name
          </button>
          <button
            onClick={sortClick}
            className={selected === "New" ? "is-selected" : ""}
            value={"New"}
          >
            New
          </button>
        </div>
      </div>

      <TagCardItem tagsAll={tagsAll} tagsName={tagsName} />
    </TagDIV>
  );
};

export default Tag;
