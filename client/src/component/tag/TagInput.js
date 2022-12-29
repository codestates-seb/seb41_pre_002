import React, {useState, useEffect} from 'react'
import styled from 'styled-components';


const taginput = styled.div`
.TagSearchDiv {
  display: flex;
  justify-content: space-between;
  align-items: flex-start;
  width: 100%;
  height: 50px;
}
`

const TagInput = () => {

  const [inputValue, setInputValue] = useState("");


// useEffect(() => {
//         // useEffect는 비동기적으로 실행된다.
//         // query에 대한 검색 결과가 완료 되었는지를 검사할 변수 필요
//         let completed = false;

//         async function get() {
//             const result = await axios(`/tags?query=${query}`)
//             if(!completed) {
//                 setData(result.data);
//             }
//         }

//         get()
//         return () => {
//             // 다른 비동기 작업이 또 실행되지 않도록
//             completed = true
//         }
//        // 두 번째 파라미터 []는 리액트 랜더링 조건
//        // 배열이 비어있다 -> 검사할 요소가 없다는 것
//        // 즉 이펙트를 실행할지 안 할지를 검사하는 변수
//        // 현재 상황에선 query가 바뀌는 시점이 된다.
//     }, [query])
  //inputvalue 값 추출 -> input 의 value 속성에 추출한 값 할당
  const { tags } = inputValue;
  // const {title, tags} = inputValue;

  const onChangeValue = (e) => {
    setInputValue(e.target.value);
    console.log(inputValue);
  };

  
  return (
    <>
    <div className="TagSearchDiv">
    <div className="flex--item ps-relative mb12">
      <input
        id="tagfilter"
        onChange={onChangeValue}
        defaultValue={tags }
        // value={text}
        className="s-input s-input__search h100 js-tag-filter"
        autoComplete="off"
        name="tags"
        type="text"
        maxLength="35"
        placeholder="Filter by tag name"
        autoFocus=""
      ></input>
      <svg
        aria-hidden="true"
        className="s-input-icon s-input-icon__search svg-icon iconSearch"
        width="18"
        height="18"
        viewBox="0 0 18 18"
      >
        <path d="m18 16.5-5.14-5.18h-.35a7 7 0 1 0-1.19 1.19v.35L16.5 18l1.5-1.5ZM12 7A5 5 0 1 1 2 7a5 5 0 0 1 10 0Z"></path>
      </svg>
    </div>
    </div>
    </>
  )
}

export default TagInput