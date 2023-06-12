import React, { Component } from 'react';
import { Col, Form, Row } from 'react-bootstrap';

class Validation extends Component {
    render() {
        return (
            <Form.Group as={Row}>
                <Form.Label column xs='auto' htmlFor='form_validation'>驗證碼 : </Form.Label>
                <Col>
                    <Form.Control id='form_validation' htmlSize='30'  />
                </Col>
                <Form.Label column xs='auto' htmlFor='form_validation'>
                    <span>1234</span>
                </Form.Label>
            </Form.Group>
        );
    }
}

export default Validation;