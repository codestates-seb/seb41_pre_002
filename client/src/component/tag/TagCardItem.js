import React from "react";
import styled from "styled-components";
import { Link } from "react-router-dom";




const TagCardItems = styled.div`
  display: block;
  height: auto;

  .TagDiV {
    display: grid;
    gap: 16px;
 
    grid-template-columns: repeat(4, minmax(0, 1fr));
    gap: 15px;
    margin-top: 15px;
    width: 100%;
    min-width: 150px;
  }

  .tag-button {
    display: inline-block;
    font-size: 13px;
    width: auto;
    color: var(--powder-700);
    cursor: pointer;
    background-color: var(--powder-100);
    border-radius: 3px;
    padding: 4.8px 6px;
    border: none;
    margin: 2px 6px 2px 0px;

    &:hover {
      background-color: #d0e3f1;
      color: #2c5877;
    }
  }

  .tag-content {
    display: inline-block;
    color: #3b4045;
    width: 100%;
    font-size: 13px;
    text-align: left;
    margin-top: 10px;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: normal;
    line-height: 1.4;
    word-wrap: break-word;
    -webkit-box-orient: vertical; 
  }
  .QuestionCount {
    margin: 10px 0px 4px 0px;
    font-size: 13px;
    color: #6a737c;
  }
  .tag {

    color: black;
    font-size: 13px;
    text-align: left;
    padding: 12px;
    border: 1px solid rgb(214, 217, 220);
    border-radius: 2px;
  }
`;



const TagCardItem = ({ tagsAll }) => {

  // const [clicked, setClicked] = useState();
  //   const handleCardClick = (category) => {
  //       setClicked(tagKeyword.find((el) => el.category === category));
  //   };

  return (
    <TagCardItems>
      <div className="TagDiV">
        {tagsAll &&
          tagsAll.map((item) => {
            return (
              <div className="tag" key={item.tagId}>
                <button className="tag-button">
                  <Link to="/QuestionTagPage">{item.category}</Link>
                </button>
                <div className="tag-content">
                  NOTICE: All {item.category} questions must be related to
                  programming; those that aren't will be closed. Use this tag
                  only if your question relates to programming using Linux APIs
                  or...
                  <div className="QuestionCount">
                    {item.questionsCount} questions
                  </div>
                </div>
              </div>
            );
          })}
      </div>
    </TagCardItems>
  );
};

export default TagCardItem;
