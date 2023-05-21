import React, { Component } from 'react';
import SimpleFormInput from '../../../hoc/form/simple-form-input';

class Address extends Component {

    render() {
        return (
            <SimpleFormInput id='address' text='飯店地址' />
        );
    }
}

export default Address;