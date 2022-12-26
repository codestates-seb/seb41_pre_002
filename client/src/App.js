import { BrowserRouter, Routes, Route } from "react-router-dom";
import MainPage from "./pages/MainPage";
import QuesetionRead from "./pages/QuesetionRead";
import QuestionWrite from "./pages/QuestionWrite";
import MyPage from "./pages/MyPage";
import LoginPage from "./pages/LoginPage";
import LogoutPage from "./pages/LogoutPage";
import SignInPage from "./pages/SignInPage";
import TagPage from "./pages/TagPage";
import UserPage from "./pages/UserPage";

function App() {
  return (
    <>
      <BrowserRouter>
        <div>
          <Routes>
            <Route path="/" element={<MainPage />} />
            <Route path="/QuesetionRead" element={<QuesetionRead />} />
            <Route path="/QuestionWrite" element={<QuestionWrite />} />
            <Route path="/MyPage" element={<MyPage />} />
            <Route path="/LoginPage" element={<LoginPage />} />
            <Route path="/LogoutPage" element={<LogoutPage />} />
            <Route path="/SignInPage" element={<SignInPage />} />
            <Route path="/TagPage" element={<TagPage />} />
            <Route path="/UserPage" element={<UserPage />} />
          </Routes>
        </div>
      </BrowserRouter>
    </>
  );
}

export default App;
