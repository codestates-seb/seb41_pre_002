import React from "react";
import styled from "styled-components";
import Header from "../component/header";
import Footer from "../component/footer";
import Nav from "../component/nav";
import Questions from "../component/Questions";

const Maindiv = styled.div`
  width: 100vw;
  height: auto;
  display: flex;
  flex-direction: row;
`;

function MainPage() {
<<<<<<< Updated upstream
=======
  const [questions, setQuestions] = useState([]);

  useEffect(() => {
    axios
      .get("/questions", {})
      .then((response) => {
        console.log(response.data.data); //정상 통신 후 응답된 메시지 출력
      })
      .catch((error) => {
        console.log(error);
        //오류발생시 실행
      })
      .then((response) => {
        setQuestions(response.data.data); //정상 통신 후 응답된 메시지 출력
      });
  }, []);

>>>>>>> Stashed changes
  return (
    <>
      <Header />
      <Maindiv>
        <Nav />
<<<<<<< Updated upstream
        <Questions />
=======
        <Questions questions={questions} color="black" />
>>>>>>> Stashed changes
      </Maindiv>
      <Footer />
    </>
  );
}

export default MainPage;
