import React, { Component } from 'react';
import SimpleFormInput from '../../../../hoc/form/simple-form-input';

class Phone extends Component {

    render() {
        
        return (
            <SimpleFormInput id='filter_phone' text='客人手機' />
        );
    }
}

export default Phone;