import React, { Component } from 'react';
import { Col, Form, Row } from 'react-bootstrap';

class ClientName extends Component {

    render() {
        
        const {value, onChange} = this.props;

        return (
            <Form.Group as={Row}>
                <Form.Label column xs='auto' htmlFor='filter_clientName'>客人姓名 : </Form.Label>
                <Col>
                    <Form.Control id='filter_clientName' value={value} onChange={onChange} />
                </Col>
            </Form.Group>
        );
    }
}

export default ClientName;