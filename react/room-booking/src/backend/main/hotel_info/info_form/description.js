import React, { Component } from 'react';
import { Col, Form, Row } from 'react-bootstrap';

class Description extends Component {

    render() {
        
        const {value, onChange} = this.props;
        
        return (
            <Form.Group as={Row}>
                <Form.Label column xs='auto' htmlFor='form_description'>飯店介紹 : </Form.Label>
                <Col>
                    <Form.Control as='textarea' id='form_description' value={value || ''} onChange={onChange} />
                </Col>
            </Form.Group>
        );
    }
}

export default Description;