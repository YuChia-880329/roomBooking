import React, { Component } from 'react';
import { Form, Row, Col } from 'react-bootstrap';

class Description extends Component {
    render() {
        return (
            <Form.Group as={Row}>
                <Form.Label column xs='auto' htmlFor='description'>飯店介紹  : </Form.Label>
                <Col xs='auto'>
                    <Form.Control id='description' as='textarea' />
                </Col>
            </Form.Group>
        );
    }
}

export default Description;