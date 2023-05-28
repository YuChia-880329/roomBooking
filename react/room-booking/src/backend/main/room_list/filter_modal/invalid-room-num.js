import React, { Component } from 'react';
import { Col, Form, Row } from 'react-bootstrap';

class InvalidRoomNum extends Component {

    render() {
        
        const {valueMin, valueMax, onChangeMin, onChangeMax} = this.props;
        
        return (
            <Form.Group as={Row}>
                <Form.Label column xs='auto' htmlFor='filter_invalidRoomMin'>不開放房數 : </Form.Label>
                <Col>
                    <Form.Control id='filter_invalidRoomMin' type='number' value={valueMin || ''} onChange={onChangeMin} />
                </Col>
                <Col xs='auto' className='px-3 align-self-center'>
                    <p className='mb-0'>~</p>
                </Col>
                <Col>
                    <Form.Control id='filter_invalidRoomMax' type='number' value={valueMax || ''} onChange={onChangeMax} />
                </Col>
            </Form.Group>
        );
    }
}

export default InvalidRoomNum;