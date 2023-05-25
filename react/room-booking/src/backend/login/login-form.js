import React, { Component, createRef } from 'react';
import { Button, Stack } from 'react-bootstrap';
import Account from './login_form/account';
import Password from './login_form/password';
import axios from 'axios';
import urls from '../../files/urls.json';
import config from '../../files/config.json'


const loginUrls = urls.backend.login;

class LoginForm extends Component {

    accountRef = createRef();
    passwordRef = createRef();

    onclick = () => {

        let form = {
            account : this.accountRef.current.getCtrlVal(),
            password : this.passwordRef.current.getCtrlVal()
        }
        let req = {
            loginForm : form
        }
        this.login(req);
    };

    login = async (req) => {

        let resp = await axios.post(loginUrls.login, req, {timeout : config.fetch.timeout})
            .then(rs => rs.data)
            .catch(error => console.error(error));

        console.log('resp : ', resp);
        this.props.informModalHandle.informModalShow('resp : ' + JSON.stringify(resp));
    }

    render() {

        return (
            <Stack gap={4}>
                <Account ref={this.accountRef} />
                <Password ref={this.passwordRef} />
                <Stack className='justify-content-center'>
                    <div className='mx-auto'>
                        <Button variant='outline-primary' onClick={this.onclick}>登入</Button>
                    </div>
                </Stack>
            </Stack>
        );
    }
}

export default LoginForm;