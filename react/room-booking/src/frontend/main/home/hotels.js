import React, { Component } from 'react';
import { Col, Row } from 'react-bootstrap';
import Hotel from './hotel/hotel';

class Hotels extends Component {
    render() {
        return (
            <Row xs={1} className='g-4'>
                <Col>
                    <Hotel />
                </Col>
                <Col>
                    <Hotel />
                </Col>
                <Col>
                    <Hotel />
                </Col>
            </Row>
        );
    }
}

export default Hotels;