import React from "react";
import styled from "styled-components";
import { Link } from "react-router-dom";
import { useDispatch } from "react-redux";

const QuestionItemdiv = styled.div`
  display: flex;
  flex-direction: column;
  /* border-bottom: 1px solid #e3e6e8; */
  .qo {
    display: flex;
    border-bottom: 1px solid #e3e6e8;
    padding: 30px;
    height: 120px;
  }
`;

const SummaryStatus = styled.div`
  display: flex;
  justify-content: flex-end;
  margin: 0px 30px 4px 0px;
  font-size: 13px;
  color: #6a737c;
`;

const SummaryContent = styled.div`
  width: 1000px;
  font-size: 17px;
  color: blue;
  align-self: start;
  .a {
    text-align: left;
  }
`;

const SummaryMeta = styled.div`
  display: flex;
  justify-content: space-between;
  color: black;
`;
const TagDiV = styled.div`
  display: flex;
  flex-direction: column;
  .tag-button {
    display: flex;
    font-size: 13px;
    width: auto;
    //버튼 사이즈를 버튼 글자의 크기에 따라 조절이 되게끔 구혐
    color: var(--powder-700);
    cursor: pointer;
    background-color: var(--powder-100);
    border-radius: 3px;
    padding: 4.8px 6px;
    border: 1px transparent;
    margin: 2px 6px 2px 0px;
  }
`;

const QuestionTagItem = ({ questionData, tagsAll }) => {
  
  // const showMsg = (event) => {
  //   const msg = event.target.getAttribute('data-msg');
  //   console.log(msg);
  // };
  // console.log(questionTag)
  // const onClickHandler = ({questionTag})
  const dispatch = useDispatch();
  return (
    <QuestionItemdiv>
      {questionData.data &&
        questionData.data.map((item) => {
          const toDO = item.questionId;
          return (
            <div className="qo" key={item.id}>
              <SummaryStatus>{item.voteCount} vote</SummaryStatus>

              <SummaryContent>
                <Link
                  to="/QuesetionRead"
                  onClick={() => {
                    dispatch({ type: "increase", number: toDO });
                    console.log(item.memberId);
                  }}
                >
                  {item.title}
                </Link>
                <SummaryMeta>
                  <TagDiV>
                    <button className="tag-button"  >
                      {item.tagResponseDtos[0].category}
                    </button>
                  </TagDiV>
                  {item.memberName}
                </SummaryMeta>
              </SummaryContent>
            </div>
          );
        })}
    </QuestionItemdiv>
  );
};

export default QuestionTagItem;
