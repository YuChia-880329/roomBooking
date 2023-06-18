import urls from '../files/urls.json';
import config from '../files/config.json';
import React, { Component } from 'react';
import LoginForm from './login/login-form';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

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
        }
    }

    componentDidMount(){

        this.checkLogin();
    }


    render() {

        const setter = {
            loginForm : {
                setLoginForm : (val, onSet) => this.setter('loginForm', val, onSet)
            }
        }
        const fctn = {
            loginForm : {
                login : this.login
            }
        };
        const {loginForm} = this.state;

        return (
            <div className='position-absolute top-50 start-50 translate-middle'>
                <LoginForm value={loginForm} fctn={fctn.loginForm} setter={setter.loginForm}  />
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
        const result = data.result;

        if(result.result)
            fctn.showInformModal(result.msg, () => {
                
                fctn.closeInformModal();
                navigate('/roomBooking/backend/hotelInfo');
            });
        else
            fctn.showInformModal(result.msg);
    }
    afterCheckLogin = (data) => {

        const {navigate} = this.props;
        const {result} = data;

        if(result.login)
            navigate('/roomBooking/backend/hotelInfo');
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

const Login = props => {

    const navigate = useNavigate();
    return (<LoginWrapped {...props} navigate={navigate} />);
};

export default Login;