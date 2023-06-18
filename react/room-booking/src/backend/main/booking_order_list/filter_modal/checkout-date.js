import React, { Component } from 'react';
import { Col, Form, Row } from 'react-bootstrap';

class CheckoutDate extends Component {

    render() {
        
        const {value} = this.props;

        return (
            <Form.Group>
                <Form.Label htmlFor='filter_checkoutDateFrom'>預定退房日期 : </Form.Label>
                <Row>
                    <Col>
                        <Form.Control id='filter_checkoutDateFrom' type='date' value={value.valueFrom} 
                                onChange={e => this.onChange(e, 'valueFrom')} />
                    </Col>
                    <Col xs='auto' className='px-3 align-self-center'>
                        <p className='mb-0'>~</p>
                    </Col>
                    <Col>
                        <Form.Control id='filter_checkoutDateTo' type='date' value={value.valueTo} 
                                onChange={e => this.onChange(e, 'valueTo')} />
                    </Col>
                </Row>
            </Form.Group>
        );
    }

    // on
    onChange = (event, colName) => {

        this.setter(colName, event.target.value);
    }

    // setter
    setter = (colName, colVal, onSet) => {

        const {setter, value} = this.props;
        setter.setCheckoutDate({
            ...value,
            [colName] : colVal
        }, onSet);
    };
}

export default CheckoutDate;