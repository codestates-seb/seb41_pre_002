import React from 'react';
import styled from 'styled-components';

const Title = styled.div`
  display: flex;
  margin-bottom: 20px;
  label {
    text-align: left;
  }
`;

function QuestionTitle({ titleHandler, title }) {
  return (
    <>
      <Title>
        <div className="flex--item w75 lg:w100 bg-white bar-sm p24 ba bc-black-075 fl-shrink0 js-post-title-section" id="post-title">
          <div className="d-flex gs4 gsy fd-column js-stacks-validation">
            <div className="d-flex fd-column flex--item">
              <div className="flex--item">
                <label for="title" className="d-block s-label">
                  Title
                </label>
              </div>
              <div className="d-flex flex--item md:fd-column">
                <div className="s-description my2">
                  <label for="title" className="d-block">
                    Be specific and imagine you’re asking a question to another person.
                  </label>
                </div>
                <div className="flex--item3 s-input-message js-title-text-counter ta-right md:ta-left my2 s-description py2 cool"></div>
              </div>
            </div>
            <div className="d-flex ps-relative">
              <input
                id="title"
                name="title"
                type="text"
                maxlength="300"
                placeholder="e.g. Is there an R function for finding the index of an element in a vector?"
                className="s-input js-post-title-field ask-title-field"
                data-min-length="15"
                data-max-length="150"
                value={title}
                onChange={titleHandler}
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
      </Title>
    </>
  );
}

export default QuestionTitle;
