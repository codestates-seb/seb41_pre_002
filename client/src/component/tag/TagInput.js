import React from "react";

// 태그 검색 

const Taginput = () => {
  return (
    <>
      <div class="flex--item ps-relative mb12">
        <input
          id="tagfilter"
          class="s-input s-input__search h100 js-tag-filter"
          autocomplete="off"
          name="tagfilter"
          type="text"
          maxlength="35"
          placeholder="Filter by tag name"
          autofocus=""
        ></input>
        <svg
          aria-hidden="true"
          class="s-input-icon s-input-icon__search svg-icon iconSearch"
          width="18"
          height="18"
          viewBox="0 0 18 18"
        >
          <path d="m18 16.5-5.14-5.18h-.35a7 7 0 1 0-1.19 1.19v.35L16.5 18l1.5-1.5ZM12 7A5 5 0 1 1 2 7a5 5 0 0 1 10 0Z"></path>
        </svg>
      </div>
    </>
  );
};

export default Taginput;