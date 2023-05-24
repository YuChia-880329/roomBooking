import React, { Component } from 'react';
import SimpleFormInput from '../../../../hoc/form/simple-form-input';

class Name extends Component {

    render() {
        
        return (
            <SimpleFormInput id='form_name' text='房型名稱' />
        );
    }
}

export default Name;