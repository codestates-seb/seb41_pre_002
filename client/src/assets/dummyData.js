import axios from "axios";

const dummyquestions = axios
  .get(`/questions/1`, {})
  .then((response) => {
    console.log("da" + response.data.data.questionResponseDto.title); //정상 통신 후 응답된 메시지 출력
    return "" + response.data.data.questionResponseDto.title;
  })
  .catch((error) => {
    console.log(error);
    //오류발생시 실행
  });

export default dummyquestions;
