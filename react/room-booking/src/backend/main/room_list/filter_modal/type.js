import React, { Component } from 'react';
import SimpleFormInput from '../../../../hoc/form/simple-form-input';

class Type extends Component {

    render() {
        
        return (
            <SimpleFormInput id='filter_type' text='房型名稱' />
        );
    }
}

export default Type;