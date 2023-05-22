import React, { Component } from 'react';
import SimpleFormInput from '../../../hoc/form/simple-form-input';

class Area extends Component {

    render() {
        
        return (
            <SimpleFormInput id='form_area' text='房型面積' type='number' min={0} placeholder='(平方公尺)' />
        );
    }
}

export default Area;