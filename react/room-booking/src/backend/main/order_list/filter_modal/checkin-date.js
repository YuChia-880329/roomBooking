import React, { Component } from 'react';
import { Col, Form, Row } from 'react-bootstrap';

class CheckinDate extends Component {

    render() {
        
        return (
            <Form.Group>
                <Form.Label htmlFor='filter_checkinDateMin'>預定入住日期 : </Form.Label>
                <Row>
                    <Col>
                        <Form.Control id='filter_checkinDateMin' type='date'  />
                    </Col>
                    <Col xs='auto' className='px-3 align-self-center'>
                        <p className='mb-0'>~</p>
                    </Col>
                    <Col>
                        <Form.Control id='filter_checkinDateMax' type='date'  />
                    </Col>
                </Row>
            </Form.Group>
        );
    }
}

export default CheckinDate;