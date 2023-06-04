import React, { Component } from 'react';
import { Col, Form, Row } from 'react-bootstrap';

class Name extends Component {

    render() {

        const {value, onChange} = this.props;
        
        return (
            <Form.Group as={Row}>
                <Form.Label column xs='auto' htmlFor='filter_name'>房型名稱 : </Form.Label>
                <Col>
                    <Form.Control id='filter_name' value={value} onChange={onChange} />
                </Col>
            </Form.Group>
        );
    }
}

export default Name;