import React, { Component } from 'react';
import SimpleFormInput from '../../../hoc/simple-form-input';

class Address extends Component {
    render() {
        return (
            <div>
                <SimpleFormInput id='address' size={70} text='飯店地址' />
            </div>
        );
    }
}

export default Address;