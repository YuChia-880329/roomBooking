import urls from '../files/urls.json';
import config from '../files/config.json';
import React, { Component } from 'react';
import SignupForm from './signup/signup-form';
import axios from 'axios';


const constant = {
    fetch : {
        url : {
            signup : urls.frontend.signup.signup,
            checkLogin : urls.frontend.checkLogin
        },
        config : {
            timeout : config.fetch.timeout
        },
        req : {
            signup : {
                account : '',
                name : '',
                password : '',
                phone : ''
            }
        }
    }
}

class Signup extends Component {

    constructor(props){

        super(props);
        this.state = {
            signupForm : {
                validated : false,
                name : {
                    value : ''
                },
                account : {
                    value : ''
                },
                password : {
                    value : ''
                },
                phone : {
                    value : ''
                },
                validation : {
                    value : '',
                    number : '1234'
                }
            }
        };
    }


    componentDidMount(){

        this.checkLoginFetch();
    }


    render() {
        
        const setter = {
            signupForm : {
                setSignupForm : (colVal, onSet) => this.setter('signupForm', colVal, onSet)
            }
        };
        const getter = {
            signupForm : {
                getSignupForm : () => this.getter('signupForm')
            }
        };
        const fctn = {
            signupForm : {
                showInformModal : this.props.fctn.showInformModal,
                closeInformModal : this.props.fctn.closeInformModal,
                showConfirmModal : this.props.fctn.showConfirmModal,
                closeConfirmModal : this.props.fctn.closeConfirmModal,
                signup : this.signup
            }
        }

        return (
            <div className='position-absolute top-50 start-50 translate-middle'>
                <SignupForm setter={setter.signupForm} getter={getter.signupForm} fctn={fctn.signupForm} />
            </div>
        );
    }


    // other
    signup = () => {

        const req = constant.fetch.req.signup;

        req.name = this.getter('signupForm').name.value;
        req.account = this.getter('signupForm').account.value;
        req.password = this.getter('signupForm').password.value;
        req.phone = this.getter('signupForm').phone.value;
        this.signupFetch(req);
    };
    checkLogin = () => {

        this.checkLoginFetch();
    };


    // fetch
    signupFetch = async (req) => {

        const {fctn} = this.props;
        const {fetch} =  constant;
        const url = fetch.url.signup;
        const config = fetch.config;

        const {serverInfo, data} = await axios.post(url, req, {
                timeout : config.timeout,
                withCredentials: true
            })
            .then(rs => rs.data)
            .catch(error => console.error(error));

        const statusCode = serverInfo.statusCode;
        if(statusCode === 200){

            this.afterSignup(data);
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
    afterSignup = (data) => {

        const {fctn} = this.props;

        if(data.success){

            fctn.showInformModal(data.msg, () => {

                fctn.closeInformModal();
                window.location.href = './login';
            });
        }else {

            fctn.showInformModal(data.msg);
        }
    };
    afterCheckLogin = (data) => {

        if(data.login)
            window.location.href = './home';
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

export default Signup;