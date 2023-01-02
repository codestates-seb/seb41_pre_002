import React from "react";
import styled from "styled-components";
import useForceUpdate from "use-force-update";
import { useSelector } from "react-redux";
import "../assets/fonts.css";
import { Link } from "react-router-dom";
import { useState, useEffect } from "react";
import { useDispatch } from "react-redux";
import axios from "axios";


const PageDiv = styled.div`
  display: flex;
  flex-direction: column;
  padding-top: 40px;
`;

const PageHeader = styled.header`
  height: 120px;
  display: flex;
  flex-direction: row;
`;

const Headernamediv = styled.div`
  border: border-box;
  color: rgb(59, 64, 69);
  font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Oxygen,
    Ubuntu, Cantarell, "Open Sans", "Helvetica Neue", sans-serif;
  text-align: left;
  font-size: 30px;
  height: 937px;
  width: 900px;
  line-height: 50px;
`;
const Askbuttondiv = styled.div`
  width: 180px;
  height: 120px;
  padding-top: 20px;
`;

const Importmationdiv = styled.div`
  color: #6a737c;
  font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Oxygen,
    Ubuntu, Cantarell, "Open Sans", "Helvetica Neue", sans-serif;
  text-align: left;
  font-size: 12px;
`;

const Importmationspan = styled.span`
  color: #232629;
  margin: 5px 50px 3px 10px;
`;

const ImportmationMain = styled.main`
  display: flex;
  padding: 30px 100px 3px 100px;
  flex-direction: row;
`;

const Contentsdiv = styled.div`
  display: flex;
  flex-direction: row;
`;
const Recomneddiv = styled.div`
  background-color: white;
  display: flex;
  flex-direction: column;
  width: 70px;
  color: #6a737c;
  i {
    margin-bottom: 10px;
    margin-top: 10px;
  }
`;
const Qustioncontentdiv = styled.div`
  width: 690px;
  padding: 15px 30px 3px 30px;
  background-color: white;
  font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Oxygen,
    Ubuntu, Cantarell, "Open Sans", "Helvetica Neue", sans-serif;
  text-align: left;
  font-size: 15px;
  height: auto;
  line-height: 40px;
  color: black;
`;
const Codediv = styled.div`
  background-color: #f6f6f6;
  font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Oxygen,
    Ubuntu, Cantarell, "Open Sans", "Helvetica Neue", sans-serif;
  text-align: left;
  font-size: 15px;
  height: 937px;
  line-height: 40px;
  margin-top: 60px;
  height: 300px;
  color: black;
`;
const Tagboxdiv = styled.div`
  display: flex;
  flex-direction: row;
  margin-top: 30px;
`;

const Tagsdiv = styled.div`
  background-color: #e1ecf4;
  color: #39739d;
  font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Oxygen,
    Ubuntu, Cantarell, "Open Sans", "Helvetica Neue", sans-serif;
  text-align: center;
  font-size: 10px;
  border-radius: 5px;
  margin: 2px 2px 2px 0;
  padding: 0px 6px 0px 6px;
`;

const BolgAndReateddiv = styled.div`
  background-color: white;
  width: 350px;
  font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Oxygen,
    Ubuntu, Cantarell, "Open Sans", "Helvetica Neue", sans-serif;
  text-align: left;
  font-size: 19px;
  display: flex;
  color: black;
  padding: 30px 40px 0px 60px;
  flex-direction: column;
`;
const Relateddiv = styled.div`
  display: flex;
  flex-direction: row;
  margin-top: 30px;
  font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Oxygen,
    Ubuntu, Cantarell, "Open Sans", "Helvetica Neue", sans-serif;
  font-size: 13px;
  text-align: left;
  color: black;
  cursor: grab;
  &:hover {
    color: blue;
  }
`;

const Relatedboxdiv = styled.div`
  width: 30px;
  height: 20px;
  margin: 0px 10px 0px 0px;
  background-color: ${(props) => (props.color ? props.color : "white")};
  text-align: center;
  font-size: 10px;
  border-radius: 5px;
  padding-top: 3px;
`;

const Questioninput = styled.input`
  box-sizing: border-box;
  width: 630px;
  height: 200px;
  margin: 60px 20px 0px 0px;
  text-align: left;
  border: solid 1px;
  border-radius: 5px;
`;

const Postbuttondiv = styled.div`
  width: 180px;
  height: 120px;
  margin: 10px 0px 0px 480px;
`;

function DetailsQustion() {
  const dispatch = useDispatch();
  const forceUpdate = useForceUpdate();
  const [content, setContent] = useState("");
  const num = useSelector((state) => state);
  const [Number, SetNumber] = useState(0);
  const [Bookmark, SetBookmark] = useState(true);

  const up = () => {
    SetNumber(Number + 1);
  };
  const Down = () => {
    SetNumber(Number - 1);
  };

  const BookmarkHandler = () => {
    SetBookmark(!Bookmark);
  };
  const [questionData, setQuestionData] = useState([]);
  const [questionsstring, setQuestionsstring] = useState("");
  const [questionstitle, setQuestionstitle] = useState("");
  const [questionscreatAt, setQuestionscreatAt] = useState("");
  const [questionsmodifiedAt, setQuestionsmodifiedAt] = useState("");
  const [questionstages, setQuestionstages] = useState([]);
  const [questionsstring1, setQuestionsstring1] = useState("");
  const [questionsstring2, setQuestionsstring2] = useState("");
  const [questionsstring3, setQuestionsstring3] = useState("");

  useEffect(() => {
    axios
      .get(`/questions/${num}`, {})
      .then((response) => {
        setQuestionsstring(response.data.data.questionResponseDto);
        setQuestionstitle(response.data.data.questionResponseDto.title);
        setQuestionscreatAt(
          response.data.data.questionResponseDto.auditableResponseDto.createdAt
        );
        setQuestionsmodifiedAt(
          response.data.data.questionResponseDto.auditableResponseDto.modifiedAt
        );
        setQuestionstages(
          response.data.data.questionResponseDto.tagResponseDtos
        );

        console.log(
          "" +
            response.data.data.questionResponseDto.commentResponseDtos[14]
              .content
        );
      })
      .catch((error) => {
        console.log(error);
        //오류발생시 실행
      });
  }, []);

  const axiosdata = (x) => {
    axios
      .get(`/questions/${num - x}`, {})
      .then((response) => {
        setQuestionsstring1(response.data.data.questionResponseDto.title); //정상 통신 후 응답된 메시지 출력
      })
      .catch((error) => {
        console.log(error);
      });
  };
  const axiosdata1 = (x) => {
    axios
      .get(`/questions/${num - x}`, {})
      .then((response) => {
        setQuestionsstring2(response.data.data.questionResponseDto.title); //정상 통신 후 응답된 메시지 출력
      })
      .catch((error) => {
        console.log(error);
      });
  };
  const axiosdata2 = (x) => {
    axios
      .get(`/questions/${num - x}`, {})
      .then((response) => {
        setQuestionsstring3(response.data.data.questionResponseDto.title); //정상 통신 후 응답된 메시지 출력
      })
      .catch((error) => {
        console.log(error);
      });
  };

  const contentHandler = (e) => {
    setContent(e.target.value);
    return "";
  };

  const addQuestion = () => {
    axios
      .post(`/questions/15/comment  `, {
        memberId: 4,
        commentId: 1,
        content: content,
      })
      .then((response) => {
        console.log(response.data.data);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    addQuestion();
    // window.location.replace("/DetailsQustion");
  };

  const todaynow = new Date();
  const today = (x) => {
    return (
      todaynow.getFullYear() +
      (todaynow.getMonth() + 1) +
      (todaynow.getDate() - x)
    );
  };

  const createdAtnow = new Date(questionscreatAt);
  const createdAtday =
    createdAtnow.getFullYear() +
    (createdAtnow.getMonth() + 1) +
    createdAtnow.getDate();
  // const today = new Date(now.setDate(now.getDate()));
  const RenderingcreatedAt = () => {
    for (let i = 0; i < 31; i++) {
      if (today(i) === createdAtday) {
        if (i === 0) return "today";
        if (i === 1) return "yesterday";
        return `${i}days ago`;
      }
    }
  };
  const modifiedAtnow = new Date(questionsmodifiedAt);
  const modifiedAtday =
    modifiedAtnow.getFullYear() +
    (modifiedAtnow.getMonth() + 1) +
    modifiedAtnow.getDate() -
    2;
  // const today = new Date(now.setDate(now.getDate()));
  const RenderingmodifiedAt = () => {
    for (let i = 0; i < 31; i++) {
      if (today(i) === modifiedAtday) {
        if (i === 0) return "today";
        if (i === 1) return "yesterday";
        return `${i}days ago`;
      }
    }
  };
  // const lisItem = arrybox.map((el) => {
  //   return <Tagsdiv>{arrybox}</Tagsdiv>;
  // });

  return (
    <PageDiv>
      <PageHeader>
        <Headernamediv>
          {questionstitle}
          <Importmationdiv>
            Asked <Importmationspan> {RenderingcreatedAt()}</Importmationspan>{" "}
            Modified
            <Importmationspan>{RenderingmodifiedAt()}</Importmationspan>
            Viewed{"5"}
            <Importmationspan></Importmationspan>
          </Importmationdiv>
        </Headernamediv>
        <Askbuttondiv>
          <Link
            to="/QuestionWrite"
            class="s-topbar--item s-topbar--item__unset ml4 s-btn s-btn__primary"
          >
            Ask Question
          </Link>
        </Askbuttondiv>
      </PageHeader>
      <ImportmationMain>
        <Contentsdiv>
          <Recomneddiv>
            <i class="fa-solid fa-caret-up fa-4x" onClick={up}></i>
            {Number}
            <i
              class="fa-solid fa-caret-up fa-rotate-180 fa-4x"
              onClick={Down}
            ></i>
            {Bookmark ? (
              <i class="fa-regular fa-bookmark" onClick={BookmarkHandler}></i>
            ) : (
              <i class="fa-solid fa-bookmark" onClick={BookmarkHandler}></i>
            )}

            <i class="fa-solid fa-clock-rotate-left"></i>
          </Recomneddiv>
          <Qustioncontentdiv>
            {questionsstring.content}
            <Tagboxdiv>
              {questionstages.map((item) => {
                return <Tagsdiv>{item.category}</Tagsdiv>;
              })}
            </Tagboxdiv>
            <br />
            {content}
            <Questioninput onClick={handleSubmit} />
            <Postbuttondiv>
              <input
                type="button"
                class="s-topbar--item s-topbar--item__unset ml4 s-btn s-btn__primary"
              >
                Post your Answer
              </input>
            </Postbuttondiv>
          </Qustioncontentdiv>
        </Contentsdiv>
        <BolgAndReateddiv>
          Related
          <Relateddiv
            onClick={() => {
              forceUpdate();
              dispatch({ type: "decrease" });
            }}
          >
            <Relatedboxdiv color="#f1f2f3">0</Relatedboxdiv>
            {questionsstring1}
            {axiosdata(1)}
          </Relateddiv>
          <Relateddiv>
            <Relatedboxdiv color="#52ba7D">0</Relatedboxdiv>
            {axiosdata1(2)}
            {questionsstring2}
          </Relateddiv>
          <Relateddiv>
            <Relatedboxdiv color="#f1f2f3">5</Relatedboxdiv>
            {axiosdata2(3)}
            {questionsstring3}
          </Relateddiv>
        </BolgAndReateddiv>
      </ImportmationMain>
    </PageDiv>
  );
}

export default DetailsQustion;
