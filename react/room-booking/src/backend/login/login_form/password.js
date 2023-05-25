import React, { Component, createRef } from 'react';
import SimpleFormInput from '../../../hoc/form/simple-form-input';

class Password extends Component {

    ctrlRef = createRef();

    getCtrlVal = () => {

        return this.ctrlRef.current.getCtrlVal();
    }

    render() {

        return (
            <SimpleFormInput ref={this.ctrlRef} id='form_password' text='密碼' type='password' size='30' required={true} feedBackText='請填寫密碼' />
        );
    }
}

export default Password;