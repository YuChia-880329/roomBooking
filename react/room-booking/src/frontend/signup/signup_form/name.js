import React, { Component } from 'react';
import { Col, Form, Row } from 'react-bootstrap';

class Name extends Component {

    render() {

        return (
            <Form.Group as={Row}>
                <Form.Label column xs='auto' htmlFor='form_name'>姓名 : </Form.Label>
                <Col>
                    <Form.Control id='form_name' htmlSize='30'  />
                </Col>
            </Form.Group>
        );
    }
}

export default Name;