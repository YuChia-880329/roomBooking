import React, { Component } from 'react';
import { Col, Form, Row } from 'react-bootstrap';

class TotalRoomNum extends Component {

    render() {

        const {valueMin, valueMax, onChangeMin, onChangeMax} = this.props;
        
        return (
            <Form.Group as={Row}>
                <Form.Label column xs='auto' htmlFor='filter_totalRoomMin'>總房數 : </Form.Label>
                <Col>
                    <Form.Control id='filter_totalRoomMin' type='number' value={valueMin || ''} onChange={onChangeMin} />
                </Col>
                <Col xs='auto' className='px-3 align-self-center'>
                    <p className='mb-0'>~</p>
                </Col>
                <Col>
                    <Form.Control id='filter_totalRoomMax' type='number' value={valueMax || ''} onChange={onChangeMax} />
                </Col>
            </Form.Group>
        );
    }
}

export default TotalRoomNum;