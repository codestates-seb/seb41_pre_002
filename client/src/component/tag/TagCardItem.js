import React from 'react'
import styled from 'styled-components'

const TagCardItems = styled.div`
  display: flex;
  flex-direction: column;
  color:  black;
  font-size: 13px;
  /* font-family: ; */
  text-align: left;
  padding: 12px;
  border: 1px solid rgb(214, 217, 220);
  border-radius: 2px;
`

const TagDiV = styled.div`
  font-size: 13px;
  color: black;
  
`

const TagCardItem = () => {
  return (
    <TagCardItems>
      <TagDiV>
        <button></button>
      </TagDiV>
    </TagCardItems>
  )
}

export default TagCardItem;