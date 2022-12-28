import React from 'react'
import styled from 'styled-components'
import TagCardItem from './TagCardItem'

const TagCardLists = styled.div`
  display: grid;
  grid-template-columns: repeat(4, minmax(0, 1fr));
  gap: 15px;
  margin-top: 15px;
  max-width: 950px; // 전체넓이 지정함
`



// 태그 인풋 아래에 있는 tag card를 전체로 넣은 컴포넌트

const TagCardList = () => {
  return (
    <>
      <TagCardLists>
        <TagCardItem />
        <TagCardItem />
        <TagCardItem />
        <TagCardItem />
        {/* <TagCardItem />
        <TagCardItem />
        <TagCardItem />
        <TagCardItem />
        <TagCardItem />
        <TagCardItem />
        <TagCardItem />
        <TagCardItem />
        <TagCardItem />
        <TagCardItem />
        <TagCardItem />
        <TagCardItem /> */}
      </TagCardLists>
    </>
  )
}

export default TagCardList;
