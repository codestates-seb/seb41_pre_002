import React from "react";
import App from "./App";
import { createRoot } from "react-dom/client";
import { Provider } from "react-redux";
import { persistReducer } from "redux-persist";
import { legacy_createStore as createStore } from "redux";

const container = document.getElementById("root");
const root = createRoot(container);

const num = 5;

function reducer(state = num, action) {
  if (action.type === "id") {
    state = action.number;
    return state;
  } else if (action.type === "decrease") {
    state--;
    return state;
  } else if (action.type === "ADD_TODO") {
    return [];
  }

  return state;
}

let contain = createStore(reducer);

root.render(
  <React.StrictMode>
    <Provider store={contain}>
      <App />
    </Provider>
  </React.StrictMode>
);

App();
