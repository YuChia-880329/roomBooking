import React, { Component } from 'react';
import { Button, Form, Stack } from 'react-bootstrap';
import Account from './signup_form/account';
import Password from './signup_form/password';
import Name from './signup_form/name';
import Phone from './signup_form/phone';
import Validation from './signup_form/validation';

class SignupForm extends Component {

    render() {

        return (
            <Stack as={Form} gap={4}>
                <Name />
                <Account />
                <Password />
                <Phone />
                <Validation />
                <Stack direction='horizontal' className='justify-content-center'>
                    <div>
                        <Button variant='outline-primary'>註冊</Button>
                    </div>
                </Stack>
            </Stack>
        );
    }
}

export default SignupForm;