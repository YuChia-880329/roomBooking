import urls from '../files/urls.json';
import config from '../files/config.json';
import React, { Component } from 'react';
import LoginForm from './login/login-form';
import axios from 'axios';

const constant = {
    fetch : {
        url : {
            login : urls.backend.login.login,
            checkLogin : urls.backend.checkLogin
        },
        config : {
            timeout : config.fetch.timeout
        },
        req : {
            login : {
                form : {
                    account : '',
                    password : ''
                }
            }
        }
    }
}
class Login extends Component {

    constructor(props){

        super(props);
        this.state = {
            isLogin : false,
            loginForm : {
                validated : false,
                account : {
                    value : ''
                },
                password : {
                    value : ''
                }
            }
        }
    }

    componentDidMount(){

        this.checkLogin();
    }


    render() {

        const fctn = {
            loginForm : {
                setIsLogin : this.setIsLogin,
                login : this.login
            }
        };
        const {loginForm} = this.state;

        return (
            <div className='position-absolute top-50 start-50 translate-middle'>
                <LoginForm values={loginForm} fctn={fctn.loginForm}
                        setter={(val, onSet) => this.setter('loginForm', val, onSet)}  />
            </div>
        );
    }

    // other
    login = () => {

        const {loginForm} = this.state;
        const req = constant.fetch.req.login;
        
        req.form.account = loginForm.account.value;
        req.form.password = loginForm.password.value;

        this.loginFetch(req);
    };
    checkLogin = () => {

        this.checkLoginFetch();
    };
    toMain = () => {

        window.location.href = './';
    };


    // fetch
    loginFetch = async (req) => {

        const {fctn} = this.props;
        const {fetch} =  constant;
        const url = fetch.url.login;
        const config = fetch.config;

        const {serverInfo, data} = await axios.post(url, req, {
                timeout : config.timeout,
                withCredentials: true
            })
            .then(rs => rs.data)
            .catch(error => console.error(error));

        const statusCode = serverInfo.statusCode;
        if(statusCode === 200){

            this.afterLogin(data);
        }else if(statusCode===400 || statusCode===500){

            fctn.showInformModal(serverInfo.msg);
        }
    };
    checkLoginFetch = async () => {

        const {fctn} = this.props;
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
        }else if(statusCode===400 || statusCode===500){

            fctn.showInformModal(serverInfo.msg);
        }
    };



    // after fetch
    afterLogin = (data) => {

        const {fctn} = this.props;
        const result = data.result;

        if(result.result)
            fctn.showInformModal(result.msg, () => {
                
                fctn.closeInformModal();
                this.toMain();
            });
        else
            fctn.showInformModal(result.msg);
    }
    afterCheckLogin = (data) => {

        const {result} = data;

        if(result.login)
            this.toMain();
    }


    // setter
    setter = (colName, colVal, onSet) => {

        this.setState({
            [colName] : colVal
        }, () => {

            onSet && onSet();
        });
    }
}

export default Login;