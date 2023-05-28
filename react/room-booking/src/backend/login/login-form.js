import React, { Component } from 'react';
import { Button, Form, Stack } from 'react-bootstrap';
import Account from './login_form/account';
import Password from './login_form/password';

const constant = {
    colName : {
        account : 'account',
        password : 'password'
    }
}

class LoginForm extends Component {

    render() {

        const {colName} = constant;
        const {fctn} = this.props;
        const {validated} = this.props;

        return (
            <Stack as={Form} gap={4} onSubmit={fctn.onSubmit} noValidate validated={validated} >
                <Account value={this.getValue(colName.account)} onChange={(e) => this.ctrlOnChange(colName.account, e)} />
                <Password value={this.getValue(colName.password)} onChange={(e) => this.ctrlOnChange(colName.password, e)} />
                <Stack className='justify-content-center'>
                    <div className='mx-auto'>
                        <Button type='submit' variant='outline-primary'>登入</Button>
                    </div>
                </Stack>
            </Stack>
        );
    }

    // on
    ctrlOnChange = (colName, event) => {

        const {fctn} = this.props;

        fctn.setVal(colName, event.target.value);
    }

    // getter setter
    getValue = (colName) => {

        const {fctn} = this.props;

        return fctn.getVal(colName);
    };
}

export default LoginForm;