import React, { Component } from 'react';
import { Button, Form, Stack } from 'react-bootstrap';
import Account from './signup_form/account';
import Password from './signup_form/password';
import Name from './signup_form/name';
import Phone from './signup_form/phone';
import Validation from './signup_form/validation';

class SignupForm extends Component {

    render() {

        const setter = {
            name : {
                setName : (colVal, onSet) => this.setter('name', colVal, onSet)
            },
            account : {
                setAccount : (colVal, onSet) => this.setter('account', colVal, onSet)
            },
            password : {
                setPassword : (colVal, onSet) => this.setter('password', colVal, onSet)
            },
            phone : {
                setPhone : (colVal, onSet) => this.setter('phone', colVal, onSet)
            },
            validation : {
                setValidation : (colVal, onSet) => this.setter('validation', colVal, onSet)
            }
        };
        const getter = {
            name : {
                getName : () => this.getter('name')
            },
            account : {
                getAccount : () => this.getter('account')
            },
            password : {
                getPassword : () => this.getter('password')
            },
            phone : {
                getPhone : () => this.getter('phone')
            },
            validation : {
                getValidation : () => this.getter('validation')
            }
        };

        return (
            <Stack as={Form} gap={4} noValidate validated={this.getter('validated')} onSubmit={this.onSubmit}>
                <Name setter={setter.name} getter={getter.name} />
                <Account setter={setter.account} getter={getter.account} />
                <Password setter={setter.password} getter={getter.password} />
                <Phone setter={setter.phone} getter={getter.phone} />
                <Validation setter={setter.validation} getter={getter.validation} />
                <Stack direction='horizontal' className='justify-content-center'>
                    <div>
                        <Button type='send' variant='outline-primary'>註冊</Button>
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

            if(event.target.checkValidity()){

                const validateInput = this.getter('validation').value;
                const validateNumber = this.getter('validation').number;

                if(validateInput !== validateNumber){

                    fctn.showInformModal('驗證碼錯誤');
                }else {

                    fctn.showConfirmModal('確定要註冊 ? ', () => {

                        fctn.closeConfirmModal();
                        fctn.signup();
                    });
                }
            }else {

                fctn.showInformModal('表單未填寫完整');
            }
        });
    };


    // setter getter
    setter = (colName, colVal, onSet) => {

        const {setter, getter} = this.props;

        setter.setSignupForm({
            ...getter.getSignupForm(),
            [colName] : colVal
        }, onSet);
    };
    getter = (colName) => {

        const {getter} = this.props;
        return getter.getSignupForm()[colName];
    }
}

export default SignupForm;