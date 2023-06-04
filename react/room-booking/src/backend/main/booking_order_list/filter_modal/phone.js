import React, { Component } from 'react';
import { Col, Form, Row } from 'react-bootstrap';

class Phone extends Component {

    render() {
        
        const {value, onChange} = this.props;
        
        return (
            <Form.Group as={Row}>
                <Form.Label column xs='auto' htmlFor='filter_phone'>客人手機 : </Form.Label>
                <Col>
                    <Form.Control id='filter_phone' value={value} onChange={onChange} />
                </Col>
            </Form.Group>
        );
    }
}

export default Phone;