import React, { Component, createRef } from 'react';
import { Button, Stack } from 'react-bootstrap';
import Account from './login_form/account';
import Password from './login_form/password';

class LoginForm extends Component {

    accountRef = createRef();
    passwordRef = createRef();

    onclick = () => {

        const form = {
            account : this.accountRef.current.getCtrlVal(),
            password : this.passwordRef.current.getCtrlVal()
        }
        console.log('form : ', form);
    };

    login = (data) => {

        
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