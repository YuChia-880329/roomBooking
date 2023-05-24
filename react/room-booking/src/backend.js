import React, { Component } from 'react';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Login from './backend/login';
import Main from './backend/main';


class Backend extends Component {

    render() {
        
        return (
            <BrowserRouter>
                <Routes>
                    <Route path='/backend/login' element={<Login />} />
                    <Route path='/backend/*' element={<Main />} />
                </Routes>
            </BrowserRouter>
        );
    }
}

export default Backend;