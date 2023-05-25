import React, { Component } from 'react';
import LoginForm from './login/login-form';

class Login extends Component {

    render() {

        // props
        const {fctn} = this.props;

        return (
            <div className='position-absolute top-50 start-50 translate-middle'>
                <LoginForm fctn={fctn} />
            </div>
        );
    }
}

export default Login;