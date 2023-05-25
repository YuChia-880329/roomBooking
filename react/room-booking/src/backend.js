import React, { Component } from 'react';
import { Navigate, Route, Routes } from 'react-router-dom';
import Login from './backend/login';
import Main from './backend/main';

class Backend extends Component {
    
    constructor(props){

        super(props);
        this.state = {
            isLogin : false
        };
    }

    setIsLogin = (isLogin) => {

        this.setState({
            isLogin : isLogin
        });
    }

    render() {

        // state
        const {isLogin} = this.state;

        const fctn = {
            setIsLogin : this.setIsLogin
        }
        
        return (
            <Routes>
                <Route path='/backend/login' element={<Login fctn={fctn} />} />
                <Route path='/backend/*' element={<Main />} />
                {/* <Route path='/backend/login' element={isLogin ? <Navigate to='/backend/' /> : <Login fctn={fctn} />} />
                <Route path='/backend/*' element={isLogin ? <Main /> : <Navigate to='/backend/login' />} /> */}
            </Routes>
        );
    }
}


export default Backend;
