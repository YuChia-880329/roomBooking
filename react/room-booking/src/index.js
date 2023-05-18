import React from 'react';
import ReactDOM from 'react-dom/client';
import 'bootstrap/dist/css/bootstrap.min.css';
import Test from './test';
import NavBar from './backend/nav-bar';


const root = ReactDOM.createRoot(document.getElementById('root'));

// root.render(<Test />);
root.render(<NavBar />);
