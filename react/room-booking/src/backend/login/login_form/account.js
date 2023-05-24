import React, { Component, createRef } from 'react';
import SimpleFormInput from '../../../hoc/form/simple-form-input';

class Account extends Component {

    ctrlRef = createRef();

    getCtrlVal = () => {

        return this.ctrlRef.current.getCtrlVal();
    }

    render() {

        return (
            <SimpleFormInput ref={this.ctrlRef} id='form_account' text='帳號' size='30' />
        );
    }
}

export default Account;