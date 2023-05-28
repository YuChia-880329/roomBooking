import React, { Component } from 'react';
import { Col, Form, Row } from 'react-bootstrap';

class TotalNum extends Component {

    render() {
        
        const {value, onChange} = this.props;

        return (
            <Form.Group as={Row}>
                <Form.Label column xs='auto' htmlFor='form_totalNumber'>總房數 : </Form.Label>
                <Col>
                    <Form.Control type='number' id='form_totalNumber' value={value || ''} onChange={onChange} min={1} />
                </Col>
            </Form.Group>
        );
    }
}

export default TotalNum;