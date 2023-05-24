import React, { Component } from 'react';
import LoginForm from './login/login-form';

class Login extends Component {
    render() {
        return (
            <div className='position-absolute top-50 start-50 translate-middle'>
                <LoginForm />
            </div>
        );
    }
}

export default Login;