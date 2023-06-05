import React, { Component } from 'react';
import { Button, Form, Stack } from 'react-bootstrap';
import Account from './login_form/account';
import Password from './login_form/password';

class LoginForm extends Component {

    render() {
        
        const {values} = this.props;

        return (
            <Stack as={Form} gap={4} onSubmit={this.onSubmit} noValidate validated={values.validated} >
                <Account value={values.account} setter={(val, onSet) => this.setter('account', val, onSet)} />
                <Password value={values.password} setter={(val, onSet) => this.setter('password', val, onSet)} />
                <Stack className='justify-content-center'>
                    <div className='mx-auto'>
                        <Button type='submit' variant='outline-primary'>登入</Button>
                    </div>
                </Stack>
            </Stack>
        );
    }

    // on
    onSubmit = (event) => {

        const {fctn} = this.props;

        event.preventDefault();
        this.setter('validated', true, () => {

            if(event.target.checkValidity() === true){
    
                fctn.login();
            }
        });
    }

    // setter
    setter = (colName, colVal, onSet) => {

        const {setter, values} = this.props;
        setter({
            ...values,
            [colName] : colVal
        }, onSet);
    };
}

export default LoginForm;