import React, { Component } from 'react';
import SimpleFormInput from '../../../hoc/simple-form-input';

class Section extends Component {
    render() {
        return (
            <SimpleFormInput id='section' size={20} text='飯店地址區域' />
        );
    }
}

export default Section;