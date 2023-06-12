import React, { Component } from 'react';
import { Col, Form, Row, Stack } from 'react-bootstrap';

class Date extends Component {

    render() {

        return (
            <Form.Group as={Stack}>
                <Row>
                    <Form.Label column xs='auto' className='me-auto ms-2' htmlFor='filter_checkinDate'>入住日期</Form.Label>
                    <Form.Label column xs='auto' className='me-2' htmlFor='filter_checkoutDate'>退房日期</Form.Label>
                </Row>
                <Row>
                    <Col>
                        <Form.Control id='filter_checkinDate' type='date' />
                    </Col>
                    <Col xs='auto' className='px-3 align-self-center'>
                        <p className='mb-0'>~</p>
                    </Col>
                    <Col>
                        <Form.Control id='filter_checkoutDate' type='date' />
                    </Col>
                </Row>
            </Form.Group>
        );
    }
}

export default Date;