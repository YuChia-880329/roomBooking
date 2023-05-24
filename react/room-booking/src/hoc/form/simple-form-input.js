import React, { Component, createRef } from 'react';
import { Form } from 'react-bootstrap';
import HorizontalFormInput from './horizontal-form-input';

class SimpleFormInput extends Component {

    ctrlRef = createRef();

    constructor(props){

        super(props);
        this.state = {
            ctrlVal : ''
        };
    }

    ctrlOnChange = (event) => {

        this.setState({
            ctrlVal : event.target.value
        });
    }

    getCtrlVal = () => {

        return this.state.ctrlVal;
    }

    Ctrl = () => {

        // state
        const {ctrlVal} = this.state;

        // props
        const {id, type, min, placeholder, size} = this.props;

        return (
            <Form.Control ref={this.ctrlRef} val={ctrlVal} id={id} type={type} min={min} placeholder={placeholder} htmlSize={size} onChange={this.ctrlOnChange} />
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