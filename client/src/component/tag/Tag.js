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
  }
  .TagSearchDiv {
    display: flex;
  }
  /* .tag--input-group{
    display: flex;
  } */
`;
// const TagInput = styled.input`
//   display: flex;
// `;

const Tag = () => {
  return (
    <>
      <TagDIV>
        <h1>Tags</h1>
        <p>
          A tag is a keyword or label that categorizes your question with other,
          similar questions. Using the right tags makes it easier for others to
          find and answer your question.
        </p>
        <div className="TagSearchDiv">
          <Taginput/>
          {/*tag 검색창 */}
          {/* <form id="search" class="tag--searchbar" autocomplete="off"> */}
            {/* <div class="tag--input-group">
              <input
                type="text"
                placeholder="Filter by tag name"
                value=""
                autocomplete="off"
                class="tag-input__search"
              />
              <svg
                aria-hidden="true"
                class="s-input-icon s-input-icon__search svg-icon iconSearch"
                width="18"
                height="18"
                viewBox="0 0 18 18"
              >
                <path d="m18 16.5-5.14-5.18h-.35a7 7 0 1 0-1.19 1.19v.35L16.5 18l1.5-1.5ZM12 7A5 5 0 1 1 2 7a5 5 0 0 1 10 0Z"></path>
              </svg>
            </div> */}
          {/* </form> */}
          <button>Popular</button>
          <button>Name</button>
          <button>New</button>
        </div>
        <TagCard/>
      </TagDIV>
    </>
  );
};

export default Tag;
