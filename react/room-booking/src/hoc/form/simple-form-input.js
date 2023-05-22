import React, { Component } from 'react';
import { Form } from 'react-bootstrap';
import HorizontalFormInput from './horizontal-form-input';

class SimpleFormInput extends Component {

    Ctrl = () => {

        // props
        const {id, type, min, placeholder} = this.props;

        return (
            <Form.Control id={id} type={type} min={min} placeholder={placeholder} />
        );
    };
    render() {

        // props
        const {id, text, AddCtrl} = this.props;

        return (
            <HorizontalFormInput id={id} text={text} Ctrl={this.Ctrl} AddCtrl={AddCtrl} />
        );
    }
}

export default SimpleFormInput;