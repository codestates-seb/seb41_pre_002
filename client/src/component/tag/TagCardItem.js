import React, { useEffect, useState } from "react";
import styled from "styled-components";

// import Tag from "./Tag";

const TagCardItems = styled.div`
  display:block;
  height: auto;
  /* min-width: 200px; */
	

  .TagDiV {
    display: grid;
    gap: 16px;
    /* grid-template-rows: repeat(4, 250px); */
    grid-template-columns: repeat(4, minmax(0, 1fr));
    gap: 15px;
    margin-top: 15px;
    width: 100%;
    min-width: 150px;
    
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
    display: flex ;
    flex-direction: column;
    color: #3B4045;
    font-size: 13px;
    margin: 10px 0px 10px 0px;
  }
  .QuestionCount {
    /* display: flex;
    justify-content: flex-end; */
    margin: 10px 0px 4px 0px;
    font-size: 13px;
    color: #6a737c;
  }
  .tag {
    /* width: 100%; */
    color: black;
    font-size: 13px;
    text-align: left;
    padding: 12px;
    border: 1px solid rgb(214, 217, 220);
    border-radius: 2px;
  }
`;

// tag card가 하나씩 들어가는 컴포넌트

const TagCardItem = ({ tagData }) => {
  console.log(tagData)

  // const [clicked, setClicked] = useState();
  //   const handleCardClick = (category) => {
  //       setClicked(tagKeyword.find((el) => el.category === category));
  //   };

  return (
    <TagCardItems>
      <div className="TagDiV">
        {tagData &&
          tagData.map((item) => {
            return (
              <div className="tag" key={item.tagId} >
                <button className="tag-button">
                  {item.category}
                </button>
                <div className="tag-content">
                  {item.category} is a multi-paradigm,
                  dynamically typed, multi-purpose programming language. It is
                  designed to be quick to learn, understand, and use, and
                  enforces
                  <div className="QuestionCount">
                    {item.questionsCount} questions
                  </div>
                </div>
              </div>
            );
          })}
      </div>
      {/* <TagCardItems>
        <div className="TagDiv">
        <button className="tag-button">python</button>
          <div className="tag-content">
          Python is a multi-paradigm, dynamically typed, multi-purpose
          programming language. It is designed to be quick to learn,
          understand, and use, and enforces
          </div>
          </div>
        </TagCardItems> */}
      {/* <TagCardItems>
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
    </TagCardItems>
  );
};

export default TagCardItem;
