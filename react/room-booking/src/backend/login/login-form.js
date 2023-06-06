import React, { Component } from 'react';
import { Button, Form, Stack } from 'react-bootstrap';
import Account from './login_form/account';
import Password from './login_form/password';

class LoginForm extends Component {

    render() {
        
        const setter = {
            account : {
                setAccount : (val, onSet) => this.setter('account', val, onSet)
            },
            password : {
                setPassword : (val, onSet) => this.setter('password', val, onSet)
            }
        };
        const {value} = this.props;

        return (
            <Stack as={Form} gap={4} onSubmit={this.onSubmit} noValidate validated={value.validated} >
                <Account value={value.account} setter={setter.account} />
                <Password value={value.password} setter={setter.password} />
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

        const {setter, value} = this.props;
        setter.setLoginForm({
            ...value,
            [colName] : colVal
        }, onSet);
    };
}

export default LoginForm;