import React, { Component } from 'react';
import SimpleFormInput from '../../../hoc/simple-form-input';

class Name extends Component {
    render() {
        return (
            <SimpleFormInput id='name' size={50} text='飯店名稱' />
        );
    }
}

export default Name;