import React from 'react'
import styled from 'styled-components'
import TagCardItem from './TagCardItem'

const TagCardList = styled.div`
  display: grid;
  grid-template-rows: repeat(4, 200px);
  grid-template-columns: repeat(4, 242px);
  gap: 15px;
  margin-top: 15px;
`


const TagCard = () => {
  return (
    <>
      <TagCardList>
        <TagCardItem />
      </TagCardList>
    </>
  )
}

export default TagCard;
