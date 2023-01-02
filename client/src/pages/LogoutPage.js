import React from 'react';
import Logout from '../component/logout/Logout';

const LogoutPage = ({ setIsLogin }) => {
  return (
    <>
      <Logout setIsLogin={setIsLogin} />
    </>
  );
};

export default LogoutPage;
