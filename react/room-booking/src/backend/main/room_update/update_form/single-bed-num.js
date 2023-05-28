import React, { Component } from 'react';
import { Col, Form, Row } from 'react-bootstrap';

class SingleBedNum extends Component {

    render() {
        
        const {value, onChange} = this.props;
        
        return (
            <Form.Group as={Row}>
                <Form.Label column xs='auto' htmlFor='form_singleBed'>單人床數 : </Form.Label>
                <Col>
                    <Form.Control type='number' id='form_singleBed' value={value || ''} onChange={onChange} min={0} />
                </Col>
            </Form.Group>
        );
    }
}

export default SingleBedNum;