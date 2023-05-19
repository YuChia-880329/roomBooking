import React, { Component } from 'react';
import { Form, Row, Col } from 'react-bootstrap';

class SimpleFormInput extends Component {

    constructor(props){
        super(props);

        this.state = {
            intputId : props.id,
            inputSize : props.size,
            labelText : props.text
        };
    }
    render() {

        // state
        const {intputId, inputSize, labelText} = this.state;

        return (
            <Form.Group as={Row}>
                <Form.Label column xs='auto' htmlFor={intputId}>{labelText} : </Form.Label>
                <Col xs='auto'>
                    <Form.Control id={intputId} htmlSize={inputSize} />
                </Col>
            </Form.Group>
        );
    }
}

export default SimpleFormInput;