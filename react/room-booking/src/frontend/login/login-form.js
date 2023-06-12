import React, { Component } from 'react';
import { Button, Form, Stack } from 'react-bootstrap';
import Account from './login_form/account';
import Password from './login_form/password';

class LoginForm extends Component {

    render() {

        return (
            <Stack as={Form} gap={4}>
                <Account />
                <Password />
                <Stack direction='horizontal' gap={5} className='justify-content-center'>
                    <div>
                        <Button variant='outline-primary'>登入</Button>
                    </div>
                    <div>
                        <Button variant='outline-primary'>註冊</Button>
                    </div>
                </Stack>
            </Stack>
        );
    }
}

export default LoginForm;