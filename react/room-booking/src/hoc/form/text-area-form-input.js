import React, { Component } from 'react';
import { Form } from 'react-bootstrap';
import HorizontalFormInput from './horizontal-form-input';

class TextAreaFormInput extends Component {

    ctrl = () => {

        // props
        const {id} = this.props;

        return (
            <Form.Control as='textarea' id={id} />
        );
    };
    render() {

        // props
        const {id, text, AddCtrl} = this.props;

        return (
            <HorizontalFormInput id={id} text={text} Ctrl={this.ctrl} AddCtrl={AddCtrl} />
        );
    }
}

export default TextAreaFormInput;