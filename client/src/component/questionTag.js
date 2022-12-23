import React from 'react';
import styled from 'styled-components';

const Tag = styled.div`
  display: flex;
  margin-bottom: 20px;
  label {
    text-align: left;
  }
`;

function QuestionTag() {
  return (
    <>
      <Tag>
        <div className="flex--item w75 lg:w100 bg-white bar-sm p24 ba bc-black-075 fl-shrink0 js-post-title-section" id="post-tag">
          <div className="d-flex gs4 gsy fd-column js-stacks-validation">
            <div className="d-flex fd-column flex--item">
              <div className="flex--item">
                <label for="tag" className="d-block s-label">
                  Tags
                </label>
              </div>
              <div className="d-flex flex--item md:fd-column">
                <div className="s-description my2">
                  <label for="tag" className="d-block">
                    Add up to 5 tags to describe what your question is about. Start typing to see suggestions.
                  </label>
                </div>
                <div className="flex--item3 s-input-message js-title-text-counter ta-right md:ta-left my2 s-description py2 cool"></div>
              </div>
            </div>
            <div className="d-flex ps-relative">
              <input
                id="tag"
                name="tag"
                type="text"
                maxlength="300"
                placeholder="e.g. (c# php objective-c)"
                className="s-input js-post-title-field ask-title-field"
                value=""
                data-min-length="15"
                data-max-length="150"
              />
              <svg
                aria-hidden="true"
                className="s-input-icon js-title-invalid-alert d-none svg-icon iconAlertCircle"
                width="18"
                height="18"
                viewBox="0 0 18 18"
              >
                <path d="M9 17c-4.36 0-8-3.64-8-8 0-4.36 3.64-8 8-8 4.36 0 8 3.64 8 8 0 4.36-3.64 8-8 8ZM8 4v6h2V4H8Zm0 8v2h2v-2H8Z"></path>
              </svg>
            </div>
            <div className="flex--item s-input-message d-none js-stacks-validation-message"></div>
          </div>
          <button className="flex--item d-block s-btn s-btn__primary mt8 js-next-title js-next-buttons" type="button">
            Next
          </button>
        </div>
      </Tag>
    </>
  );
}

export default QuestionTag;
