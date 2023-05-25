import React, { Component, Fragment, createRef } from 'react';
import { Button, Form, Stack } from 'react-bootstrap';
import Account from './login_form/account';
import Password from './login_form/password';
import InformModal from '../../hoc/modal/inform-modal'
import axios from 'axios';
import urls from '../../files/urls.json';
import config from '../../files/config.json'


const loginUrls = urls.backend.login;

class LoginForm extends Component {

    accountRef = createRef();
    passwordRef = createRef();
    informModalRef = createRef();

    constructor(props){

        super(props);

        this.state = {
            form : {
                isValidated : false
            },
            informModal : {
                msg : '',
                okBtnOnClick : () => {}
            }
        };
    }

    onSubmit = (event) => {

        event.preventDefault();
        this.setState({
            form : {
                isValidated : true
            }
        });
        const form = event.currentTarget;
        if (form.checkValidity() === true) {

            const form = {
                account : this.accountRef.current.getCtrlVal(),
                password : this.passwordRef.current.getCtrlVal()
            }
            const req = {
                loginForm : form
            }
            this.login(req);
        }
    }
    

    login = async (req) => {

        const fetchConfig =  config.fetch;

        const {serverInfo, data} = await axios.post(loginUrls.login, req, {timeout : fetchConfig.timeout})
            .then(rs => rs.data)
            .catch(error => console.error(error));

        const statusCode = serverInfo.statusCode;
        if(statusCode === 200){

            this.afterLogin(data);
        }
    }

    afterLogin = (data) => {

        // props
        const {fctn} = this.props;

        const loginResult = data.loginResult;

        if(loginResult.result)
            this.informModalShow(loginResult.msg, () => {

                this.informModalClose();
                fctn.setIsLogin(true);
                console.log("fctn.setIsLogin : ", fctn.setIsLogin);
            });
        else
            this.informModalShow(loginResult.msg, null);
    };

    informModalShow = (msg, okBtnOnClick) => {

        this.setState({
            informModal : {
                msg : msg,
                okBtnOnClick : okBtnOnClick
            }
        });
        this.informModalRef.current.handleShow();
    }
    
    informModalClose = () => {

        this.informModalRef.current.handleClose();
    }

    render() {

        // state
        const {form, informModal} = this.state;

        return (
            <Fragment>
                <Stack as={Form} gap={4} noValidate validated={form.isValidated} onSubmit={this.onSubmit}>
                    <Account ref={this.accountRef} />
                    <Password ref={this.passwordRef} />
                    <Stack className='justify-content-center'>
                        <div className='mx-auto'>
                            <Button type='submit' variant='outline-primary'>登入</Button>
                        </div>
                    </Stack>
                </Stack>
                <InformModal ref={this.informModalRef} msg={informModal.msg} okBtnOnClick={informModal.okBtnOnClick} />
            </Fragment>
        );
    }
}

export default LoginForm;