import React, { Component } from 'react';
import { Col, Form, Row } from 'react-bootstrap';

class DoubleBedNum extends Component {

    render() {
        
        const {value, onChange} = this.props;
        
        return (
            <Form.Group as={Row}>
                <Form.Label column xs='auto' htmlFor='form_doubleBed'>雙人床數 : </Form.Label>
                <Col>
                    <Form.Control id='form_doubleBed' type='number' value={value || ''} onChange={onChange} min={0} />
                </Col>
            </Form.Group>
        );
    }
}

export default DoubleBedNum;