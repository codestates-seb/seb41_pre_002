import React from "react";
import styled from "styled-components";
import Taginput from "./TagInput";
import TagCard from "./TagCardList";

const TagDIV = styled.div`
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  padding: 24px 16px;

  h1 {
    font-size: 27px;
    margin: 0px 0px 27px;
    color: black;
    font-weight: 400;
  }
  p {
    /* display: flex; */
    color: black;
    font-size: 15px;
    max-width: 625px;
  }
  .TagSearchDiv {
    display: flex;
    justify-content: space-between;
    align-items: flex-start;
    width: 1050px;
    height: 50px;
  }
  .ButtonBox {
    display: flex;
    border-color: var(--_bu-outlined-bc-selected);
    border-radius: 4px;
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
    <>
      <TagDIV>
        {/* tag 페이지 상단 */}
        <h1>Tags</h1>
        {
          <p className="TagPar">
            A tag is a keyword or label that categorizes your question with
            other, similar questions.<br></br> Using the right tags makes it
            easier for others to find and answer your question.
          </p>
        }
        {/*tag input && buttion div 묶음 */}
        <div className="TagSearchDiv">
          <Taginput />
          <div className="ButtonBox">
            <button className="Btn">Popular</button>
            <button className="Btn">Name</button>
            <button className="Btn">New</button>
          </div>
        </div>
        <TagCard />
      </TagDIV>
    </>
  );
};

export default Tag;
