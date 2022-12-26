import React from "react";
import styled from "styled-components";
import TagCard from "./TagCardList";
import TagPagenation from "./TagPagenation";

const TagDIV = styled.div`
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  padding: 30px ;
  min-width: 200px;
  background-color: aqua;
  /* height: auto; */
  /* box-sizing: border-box; */
  h1 {
    font-size: 27px;
    margin: 0px 0px 27px;
    color: black;
    font-weight: 400;
    
  }
  p {
    color: black;
    font-size: 15px;
    max-width: 625px;
    margin: 0px 0px 27px;
  }
  .TagSearchDiv {
    display: flex;
    justify-content: space-between;
    align-items: flex-start;
    width: 100%;
    height: 50px;
  }
  .ButtonBox {
    display: flex;
    border-color: var(--_bu-outlined-bc-selected);
    border-radius: 10px;
    min-width: 100px;
  }
  .Btn {
    /* display: flex; */
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
`;

const Tag = () => {
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
      <div class="flex--item ps-relative mb12">
        <input
          id="tagfilter"
          class="s-input s-input__search h100 js-tag-filter"
          autocomplete="off"
          name="tagfilter"
          type="text"
          maxlength="35"
          placeholder="Filter by tag name"
          autofocus=""
        ></input>
        <svg
          aria-hidden="true"
          class="s-input-icon s-input-icon__search svg-icon iconSearch"
          width="18"
          height="18"
          viewBox="0 0 18 18"
        >
          <path d="m18 16.5-5.14-5.18h-.35a7 7 0 1 0-1.19 1.19v.35L16.5 18l1.5-1.5ZM12 7A5 5 0 1 1 2 7a5 5 0 0 1 10 0Z"></path>
        </svg>
      </div>
        <div className="ButtonBox">
          <button className="Btn">Popular</button>
          <button className="Btn">Name</button>
          <button className="Btn">New</button>
        </div>
      </div>
      <TagCard />
      <TagPagenation/>
    </TagDIV>
  );
};

export default Tag;
