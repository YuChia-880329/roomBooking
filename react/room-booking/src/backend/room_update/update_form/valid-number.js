import React, { Component } from 'react';
import { Form, Row } from 'react-bootstrap';

class ValidNumber extends Component {
    render() {
        return (
           <Form.Group as={Row}>
                <Form.Label column xs='auto' >開放空房數 : </Form.Label>
                <Form.Label column >
                    <span>2</span> 間
                </Form.Label>
           </Form.Group>
        );
    }
}

export default ValidNumber;