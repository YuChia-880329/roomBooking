import React, { Component } from 'react';
import { Form } from 'react-bootstrap';
import HorizontalFormInput from './horizontal-form-input';

class SelectFormInput extends Component {
    
    ctrl = () => {

        // props
        const {options} = this.props;

        return (
            <Form.Select>
                {options.map(opt => (
                    <option>{opt}</option>
                ))}
            </Form.Select>
        );
    };
    render() {

        // props
        const {text, AddCtrl} = this.props;

        return (
            <HorizontalFormInput text={text} Ctrl={this.ctrl} AddCtrl={AddCtrl} />
        );
    }
}

export default SelectFormInput;