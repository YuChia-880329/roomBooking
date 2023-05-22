import React, { Component } from 'react';
import { Col, Form, Row } from 'react-bootstrap';

class CheckouDate extends Component {
    render() {
        return (
            <Form.Group>
                <Form.Label htmlFor='filter_checkoutDateMin'>預定退房日期 : </Form.Label>
                <Row>
                    <Col>
                        <Form.Control id='filter_checkoutDateMin' type='date'  />
                    </Col>
                    <Col xs='auto' className='px-3 align-self-center'>
                        <p className='mb-0'>~</p>
                    </Col>
                    <Col>
                        <Form.Control id='filter_checkoutDateMax' type='date'  />
                    </Col>
                </Row>
            </Form.Group>
        );
    }
}

export default CheckouDate;