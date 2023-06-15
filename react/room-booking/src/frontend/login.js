import urls from '../files/urls.json';
import config from '../files/config.json';
import React, { Component } from 'react';
import LoginForm from './login/login-form';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';


const constant = {
    fetch : {
        url : {
            login : urls.frontend.login.login,
            checkLogin : urls.frontend.checkLogin
        },
        config : {
            timeout : config.fetch.timeout
        },
        req : {
            login : {
                account : '',
                password : ''
            }
        }
    }
}

class LoginWrapped extends Component {

    constructor(props){

        super(props);
        this.state = {
            loginForm : {
                validated : false,
                account : {
                    value : ''
                },
                password : {
                    value : ''
                }
            }
        };
    }


    componentDidMount(){

        this.checkLogin();
    }


    render() {

        const setter = {
            loginForm : {
                setLoginForm : (colVal, onSet) => this.setter('loginForm', colVal, onSet)
            }
        };
        const getter = {
            loginForm : {
                getLoginForm : () => this.getter('loginForm')
            }
        };
        const fctn = {
            loginForm : {
                login : this.login
            }
        };
        
        return (
            <div className='position-absolute top-50 start-50 translate-middle'>
                <LoginForm setter={setter.loginForm} getter={getter.loginForm} fctn={fctn.loginForm} />
            </div>
        );
    }



    // other
    login = () => {

        const {loginForm} = this.state;
        const req = constant.fetch.req.login;
        
        req.account = loginForm.account.value;
        req.password = loginForm.password.value;

        this.loginFetch(req);
    };
    checkLogin = () => {

        this.checkLoginFetch();
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

        const {fctn, navigate} = this.props;

        if(data.success)
            fctn.showInformModal(data.msg, () => {
                
                fctn.closeInformModal();
                navigate('../home');
            });
        else
            fctn.showInformModal(data.msg);
    }
    afterCheckLogin = (data) => {

        const {navigate} = this.props;

        if(data.login)
            navigate('../home');
    };


    // setter getter
    setter = (colName, colVal, onSet) => {

        this.setState({
            [colName] : colVal
        }, () => {

            onSet && onSet();
        });
    };
    getter = (colName) => {

        return this.state[colName];
    };
}

const Login = props => {

    const navigate = useNavigate();

    return (
        <LoginWrapped {...props} navigate={navigate} />
    );
}

export default Login;