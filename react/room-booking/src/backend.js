import urls from './files/urls.json';
import config from './files/config.json';
import React, { Component } from 'react';
import { Navigate, Route, Routes } from 'react-router-dom';
import Login from './backend/login';
import Main from './backend/main';
import axios from 'axios';

const constant = {
    fetch : {
        url : {
            checkLogin : urls.backend.login.checkLogin
        },
        config : {
            timeout : config.fetch.timeout
        }
    }
}
class Backend extends Component {

    constructor(props){

        super(props);
        this.state = {
            isLogin : false
        };
    }

    componentDidMount(){

        this.onLoad();
    }
    
    render() {

        const {isLogin} = this.state;
        const fctn = {
            login : {
                setIsLogin : this.setIsLogin
            }
        };
        
        return (
            <Routes>
                {/* <Route path='/backend/login' element={<Login fctn={fctn.login} />} />
                <Route path='/backend/*' element={<Main />} /> */}
                <Route path='/backend/login' element={isLogin ? <Navigate to='/backend/' /> : <Login fctn={fctn.login} />} />
                <Route path='/backend/*' element={isLogin ? <Main /> : <Navigate to='/backend/login' />} />
            </Routes>
        );
    }

    // on
    onLoad = () => {

        this.checkLogin();
    }

    // fetch
    checkLogin = async () => {

        const {fetch} =  constant;
        const url = fetch.url.checkLogin;
        const config = fetch.config;

        const {serverInfo, data} = await axios.get(url, {
                timeout : config.timeout,
                withCredentials: true
            })
            .then(rs => rs.data)
            .catch(error => console.error(error));

        const statusCode = serverInfo.statusCode;
        if(statusCode === 200){

            this.afterCheckLogin(data);
        }
    };


    // after fetch
    afterCheckLogin = (data) => {

        const {result} = data;

        this.setState({
            isLogin : result.login
        });
    }

    // getter setter
    setIsLogin = (isLogin) => {

        this.setState({
            isLogin : isLogin
        });
    };
}


export default Backend;
