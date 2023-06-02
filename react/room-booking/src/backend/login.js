import urls from '../files/urls.json';
import config from '../files/config.json';
import React, { Component } from 'react';
import LoginForm from './login/login-form';
import axios from 'axios';
import InformModal from '../hoc/modal/inform-modal';

const constant = {
    fetch : {
        url : {
            login : urls.backend.login.login
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
            loginForm : {
                value : {
                    account : '',
                    password : ''
                },
                validated : false
            },
            informModal : {
                msg : '',
                show : false, 
                onHide : () => {}
            }
        }
    }

    componentDidMount(){

        const {informModal} = this.state;

        this.setState({
            informModal : {
                ...informModal, 
                onHide : this.informModalOnHide
            }
        });
    }

    render() {

        const fctn = {
            loginForm : {
                getVal : this.getLoginFormVal,
                setVal : this.setLoginFormVal,
                onSubmit : this.loginFormOnSubmit
            }
        };
        const {loginForm, informModal} = this.state;

        return (
            <div className='position-absolute top-50 start-50 translate-middle'>
                <LoginForm fctn={fctn.loginForm} validated={loginForm.validated} />
                <InformModal msg={informModal.msg} show={informModal.show} onHide={informModal.onHide} />
            </div>
        );
    }

    // other
    showInformModal = (msg, onHide) => {

        const {informModal} = this.state;

        this.setState({
            informModal : {
                ...informModal,
                msg : msg,
                show : true,
                onHide : (onHide ? onHide : this.closeInformModal)
            }
        });
    }
    closeInformModal = () => {

        const {informModal} = this.state;

        this.setState({
            informModal : {
                ...informModal,
                show : false
            }
        });
    };

    // on function
    loginFormOnSubmit = (event) => {

        const {fetch} =  constant;
        const {loginForm} = this.state;

        event.preventDefault();
        this.setState({
            loginForm : {
                ...loginForm,
                validated : true
            }
        }, () => {

            const targetForm = event.target;
            if(targetForm.checkValidity() === true){
    
                const req = fetch.req.login;
    
                req.form.account = loginForm.value.account;
                req.form.password = loginForm.value.password;
        
                this.login(req);
            }
        });
    }

    // fetch
    login = async (req) => {

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
        }
    };


    // after fetch
    afterLogin = (data) => {

        const result = data.result;

        if(result.result)
            this.showInformModal(result.msg, () => {
                
                this.props.fctn.setIsLogin(true);
                this.informModalOnHide();
            });
        else
            this.showInformModal(result.msg);
    }

    // getter setter
    getLoginFormVal = (colName) => {

        const {loginForm} = this.state;

        return loginForm.value[colName];
    };
    setLoginFormVal = (colName, colValue, callBack) => {

        const {loginForm} = this.state;

        this.setState({
            loginForm : {
                ...loginForm,
                value : {
                    ...loginForm.value,
                    [colName] : colValue
                }
            }
        }, callBack);
    };
}

export default Login;