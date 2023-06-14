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
                        <Form.Control id='filter_checkinDate' type='date' value={this.getter('valueCheckinDate')} 
                                onChange={e => this.onChange(e, 'valueCheckinDate')} required />
                        <Form.Control.Feedback type='invalid'>請選擇入住日期</Form.Control.Feedback>
                    </Col>
                    <Col xs='auto' className='px-3 align-self-center'>
                        <p className='mb-0'>~</p>
                    </Col>
                    <Col>
                        <Form.Control id='filter_checkoutDate' type='date' value={this.getter('valueCheckoutDate')} 
                                onChange={e => this.onChange(e, 'valueCheckoutDate')} required />
                        <Form.Control.Feedback type='invalid'>請選擇退房日期</Form.Control.Feedback>
                    </Col>
                </Row>
            </Form.Group>
        );
    }


    // on
    onChange = (event, colName) => {

        this.setter(colName, event.target.value);
    };

    // setter getter
    setter = (colName, colVal, onSet) => {

        const {setter, getter} = this.props;

        setter.setDate({
            ...getter.getDate(),
            [colName] : colVal
        }, onSet);
    };
    getter = (colName) => {

        const {getter} = this.props;
        return getter.getDate()[colName];
    }
}

export default Date;