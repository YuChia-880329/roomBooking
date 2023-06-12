import React, { Component } from 'react';
import SignupForm from './signup/signup-form';

class Signup extends Component {

    render() {
        
        return (
            <div className='position-absolute top-50 start-50 translate-middle'>
                <SignupForm />
            </div>
        );
    }
}

export default Signup;