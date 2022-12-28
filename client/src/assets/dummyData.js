import axios from "axios";

const dummyquestions = axios
  .get(
    "/questions?page=1&size=10&keyword=&filter=all&sortedBy=questionId&order=descending",
    {}
  )
  .then((response) => {
    console.log(response.data.data); //정상 통신 후 응답된 메시지 출력
  })
  .catch((error) => {
    console.log(error);
    //오류발생시 실행
  })
  .then((response) => {
    return response.data.data.json();
  });

export default dummyquestions;
