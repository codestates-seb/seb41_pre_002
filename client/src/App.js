import { BrowserRouter, Routes, Route } from "react-router-dom";
import MainPage from "./pages/MainPage";
import QuesetionRead from "./pages/QuesetionRead";
import QuestionWrite from "./pages/QuestionWrite";
import MyPage from "./pages/MyPage";
import LoginPage from "./pages/LoginPage";
// import LogoutPage from "./pages/LogoutPage";
import SignInPage from "./pages/SignInPage";
import TagPage from "./pages/TagPage";
import UserPage from "./pages/UserPage";
import QuestionTagPage from "./pages/QuestionTagPage";
import { useState, useEffect } from "react";
import axios from "axios";

function App() {
  const [questions, setQuestions] = useState("");
  const [number, setnumber] = useState(1);

  useEffect(() => {
    axios
      .get(`/questions/${number}`, {})
      .then((response) => {
        // console.log(response.data.data.questionResponseDto.title); //정상 통신 후 응답된 메시지 출력
        setQuestions(response.data.data.questionResponseDto); //정상 통신 후 응답된 메시지 출력
      })
      .catch((error) => {
        console.log(error);
        //오류발생시 실행
      });
  }, []);

  return (
    <>
      <BrowserRouter>
        <div>
          <Routes>
            <Route path="/" element={<MainPage questions={questions} />} />
            <Route
              path="/QuesetionRead"
              element={<QuesetionRead questions={questions} />}
            />
            <Route path="/QuestionWrite" element={<QuestionWrite />} />
            <Route path="/MyPage" element={<MyPage />} />
            <Route path="/LoginPage" element={<LoginPage />} />
            {/* <Route path="/LogoutPage" element={<LogoutPage />} /> */}
            <Route path="/SignInPage" element={<SignInPage />} />
            <Route path="/TagPage" element={<TagPage />} />
            <Route path="/QuestionTagPage" element={<QuestionTagPage questions={questions} />} />
            <Route path="/UserPage" element={<UserPage />} />
          </Routes>
        </div>
      </BrowserRouter>
    </>
  );
}

export default App;
