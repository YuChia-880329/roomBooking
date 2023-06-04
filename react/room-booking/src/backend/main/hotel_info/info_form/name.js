import React, { Component } from 'react';
import { Col, Form, Row } from 'react-bootstrap';

class Name extends Component {

    render() {

        const {value, onChange} = this.props;
        
        return (
            <Form.Group as={Row}>
                <Form.Label column xs='auto' htmlFor='form_name'>飯店名稱 : </Form.Label>
                <Col>
                    <Form.Control id='form_name' value={value} onChange={onChange} />
                </Col>
            </Form.Group>
        );
    }
}

export default Name;