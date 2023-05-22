import React, { Component } from 'react';
import SimpleFormInput from '../../../hoc/form/simple-form-input';

class ClientName extends Component {

    render() {
        
        return (
            <SimpleFormInput id='filter_clientName' text='客人姓名' />
        );
    }
}

export default ClientName;