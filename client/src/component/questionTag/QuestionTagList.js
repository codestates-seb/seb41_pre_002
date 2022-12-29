import styled from "styled-components";
import QuestionTagItem from "./QuestionTagItem";
const QusetionListDiv = styled.div`
  /* width: 800px; */
`;
const QuestionLists = styled.div`
  /* position: relative; */
  /* display: flex; */
  /* border-bottom: 1px solid #e3e6e8; */

  /* color: #6A737C; */
  /* &.question-mini-list:last-child {
    border-bottom-width: 0;
  }
  @media (max-width: 980px) {
    flex-direction: column;
  } */
  .qo {
    color: black;
  }
`;

const QuestionTagList = ({ questionData , questionTag }) => {
  return (
    <QusetionListDiv>
      <QuestionLists>
        {/* {questionData.data &&
        questionData.data.map((item) => {
          return <div className="qo"> {item.title}</div>;
        })} */}
        {questionData && <QuestionTagItem questionData={questionData} questionTag={questionTag}/>}
        {/* {console.log(questionData)} */}
      </QuestionLists>
    </QusetionListDiv>
  );
};

export default QuestionTagList;
