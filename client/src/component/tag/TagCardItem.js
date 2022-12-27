import React, { useEffect, useState } from "react";
import styled from "styled-components";
import dummydata from "../../dummy/dummydata";
// import Tag from "./Tag";

const TagCardItems = styled.div`
  display: flex;
  flex-direction: column;
  color: black;
  font-size: 13px;
  text-align: left;
  padding: 12px;
  border: 1px solid rgb(214, 217, 220);
  border-radius: 2px;

  .TagDiV {
    display: flex;
    flex-direction: column;
  }

  .tag-button {
    display: flex;
    font-size: 13px;
    width: 60px;
    //버튼 사이즈를 버튼 글자의 크기에 따라 조절이 되게끔 구혐
    color: var(--powder-700);
    cursor: pointer;
    background-color: var(--powder-100);
    border-radius: 3px;
    padding: 4.8px 6px;
    border: 1px transparent;
    margin: 2px 6px 2px 0px;
  }

  .tag-content {
    display: flex !important;
    color: black;
    font-size: 13px;
    margin: 10px 0px 10px 0px;
  }
`;

// tag card가 하나씩 들어가는 컴포넌트

const TagCardItem = () => {
  const [tags, setTags] = useState([]);
  useEffect(() => {
    setTags(dummydata);
  }, []);

  console.log(tags);
  // const FilterTag = (tag) => {
  //   Tags.filter((tag) => tag.text.to)
  // }

  return (
    <>
      <TagCardItems>
        <div className="TagDiv">
          {/* {tags.map((dummydata) => 
          key={item.tagId}
          )}; */}
          {/* <button className="tag-button">javascript</button>
          <div className="tag-content">
            For questions about programming in ECMAScript (JavaScript/JS) and
            its different dialects/implementations (except for ActionScript).
            Keep in
          </div> */}
        </div>
      </TagCardItems>

      {/* <TagCardItems>
        <div className="TagDiv">
          <button className="tag-button">python</button>
          <div className="tag-content">
            Python is a multi-paradigm, dynamically typed, multi-purpose
            programming language. It is designed to be quick to learn,
            understand, and use, and enforces
          </div>
        </div>
      </TagCardItems>
      <TagCardItems>
        <div className="TagDiv">
          <button className="tag-button">java</button>
          <div className="tag-content">
            Python is a multi-paradigm, dynamically typed, multi-purpose
            programming language. It is designed to be quick to learn,
            understand, and use, and enforces
          </div>
        </div>
      </TagCardItems>
      <TagCardItems>
        <div className="TagDiv">
          <button className="tag-button">c#</button>
          <div className="tag-content">
            Python is a multi-paradigm, dynamically typed, multi-purpose
            programming language. It is designed to be quick to learn,
            understand, and use, and enforces
          </div>
        </div>
      </TagCardItems> */}
    </>
  );
};

export default TagCardItem;
