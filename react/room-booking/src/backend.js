import React, { Component } from 'react';
import { Navigate, Route, Routes } from 'react-router-dom';
import Login from './backend/login';
import Main from './backend/main';
import axios from 'axios';
import urls from './files/urls.json';
import config from './files/config.json'

const checkLoginUrl = urls.backend.login.checkLogin;

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

    checkLogin = async () => {

        const fetchConfig = config.fetch;
        const {serverInfo, data} = await axios.get(checkLoginUrl, {
                timeout : fetchConfig.timeout, 
                withCredentials: true
            })
            .then(rs => rs.data)
            .catch(error => console.error(error));

        const statusCode = serverInfo.statusCode;
        if(statusCode === 200){

            this.afterCheckLogin(data);
        }
    }
    afterCheckLogin = (data) => {

        const {checkLoginResult} = data;
        this.setState({
            isLogin : checkLoginResult.login
        });
    }


    componentDidMount(){

        // this.checkLogin();
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
