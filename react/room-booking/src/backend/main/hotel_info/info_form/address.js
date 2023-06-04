import React, { Component } from 'react';
import { Col, Form, Row } from 'react-bootstrap';

class Address extends Component {

    render() {
        
        const {value, onChange} = this.props;

        return (
            <Form.Group as={Row}>
                <Form.Label column xs='auto' htmlFor='form_address'>飯店地址 : </Form.Label>
                <Col>
                    <Form.Control id='form_address' value={value} onChange={onChange} />
                </Col>
            </Form.Group>
        );
    }
}

export default Address;