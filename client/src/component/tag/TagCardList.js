import React from 'react'
import styled from 'styled-components'
import TagCardItem from './TagCardItem'

const TagCardLists = styled.div`
  display: grid;
  grid-template-rows: repeat(4, 200px);
  grid-template-columns: repeat(4, 242px);
  gap: 15px;
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
        <TagCardItem />
        <TagCardItem />
        <TagCardItem />
        <TagCardItem />
        <TagCardItem />
        <TagCardItem />
        <TagCardItem />
        <TagCardItem />
      </TagCardLists>
    </>
  )
}

export default TagCardList;
