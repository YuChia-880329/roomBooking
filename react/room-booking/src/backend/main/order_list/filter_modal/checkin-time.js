import React, { Component } from 'react';
import { Col, Form, Row } from 'react-bootstrap';

class CheckinTime extends Component {

    render() {

        return (
            <Form.Group>
                <Form.Label htmlFor='filter_checkinTimeMin'>預定入住時辰 : </Form.Label>
                <Row>
                    <Col>
                        <Form.Control id='filter_checkinTimeMin' type='time'  />
                    </Col>
                    <Col xs='auto' className='px-3 align-self-center'>
                        <p className='mb-0'>~</p>
                    </Col>
                    <Col>
                        <Form.Control id='filter_checkinTimeMax' type='time'  />
                    </Col>
                </Row>
            </Form.Group>
        );
    }
}

export default CheckinTime;