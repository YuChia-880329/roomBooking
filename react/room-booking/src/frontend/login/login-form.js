import React, { Component } from 'react';
import { Button, Form, Stack } from 'react-bootstrap';
import Account from './login_form/account';
import Password from './login_form/password';

class LoginForm extends Component {

    render() {

        const setter = {
            account : {
                setAccount : (colVal, onSet) => this.setter('account', colVal, onSet)
            },
            password : {
                setPassword : (colVal, onSet) => this.setter('password', colVal, onSet)
            }
        };
        const getter = {
            account : {
                getAccount : () => this.getter('account')
            },
            password : {
                getPassword : () => this.getter('password')
            }
        };

        return (
            <Stack as={Form} gap={4} onSubmit={this.onSubmit} noValidate validated={this.getter('validated')}>
                <Account setter={setter.account} getter={getter.account} />
                <Password setter={setter.password} getter={getter.password} />
                <Stack direction='horizontal' gap={5} className='justify-content-center'>
                    <div>
                        <Button type='send' variant='outline-primary'>登入</Button>
                    </div>
                    <div>
                        <Button variant='outline-primary'>註冊</Button>
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
    };


    // setter getter
    setter = (colName, colVal, onSet) => {

        const {setter, getter} = this.props;

        setter.setLoginForm({
            ...getter.getLoginForm(),
            [colName] : colVal
        }, onSet);
    };
    getter = (colName) => {

        const {getter} = this.props;
        return getter.getLoginForm()[colName];
    }
}

export default LoginForm;