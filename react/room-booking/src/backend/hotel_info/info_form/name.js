import React, { Component } from 'react';
import SimpleFormInput from '../../../hoc/form/simple-form-input';

class Name extends Component {

    render() {
        return (
            <SimpleFormInput id='name' text='飯店名稱' />
        );
    }
}

export default Name;