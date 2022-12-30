import React, { useState, useEffect } from "react";
import styled from "styled-components";
import axios from "axios";

const taginput = styled.div`
  .TagSearchDiv {
    display: flex;
    justify-content: space-between;
    align-items: flex-start;
    width: 100%;
    height: 50px;
  }
`;

const TagInput = () => {
  // input 창에 값 뜨게
  

 

  const [tagData, setTagData] = useState([]);
  const [searchTerm, setSearchTerm] = useState("");
  const [copy, setCopy] = useState([]);

  useEffect(() => {
    axios
      .get("/tags", {})
      .then((response) => {
        setTagData(response.data.data);
        setCopy(response.data.data);
        console.log(response.data.data); // data& pageinfo
      })
      .catch((error) => {
        console.log(error);
        //오류발생시 실행
      });
  }, []);

  const handleInputChange = (e) => {
    setSearchTerm(e.target.value);
  };

  useEffect(() => {
    setTagData(
      copy.filter((e) =>
        e.category.toLowerCase().includes(searchTerm.toLowerCase())
      )
    );
  }, [searchTerm, copy]);

  return (
    <>
      <div className="TagSearchDiv">
        <div className="flex--item ps-relative mb12">
          <input
            id="tagfilter"
            onChange={handleInputChange}
            // defaultValue={tags}
            // value="text"
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
  );
};

export default TagInput;
