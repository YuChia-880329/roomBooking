import React, { Component } from 'react';
import TextAreaFormInput from '../../../../hoc/form/text-area-form-input';

class Description extends Component {

    render() {
        
        return (
            <TextAreaFormInput id='form_description' text='飯店介紹'/>
        );
    }
}

export default Description;