import React, { Component } from 'react';
import { Col, Form, Row } from 'react-bootstrap';

class CheckinDate extends Component {

    render() {
        
        const {value} = this.props;

        return (
            <Form.Group>
                <Form.Label htmlFor='filter_checkinDateFrom'>預定入住日期 : </Form.Label>
                <Row>
                    <Col>
                        <Form.Control id='filter_checkinDateFrom' type='date' value={value.valueFrom} 
                                onChange={e => this.onChange(e, 'valueFrom')} />
                    </Col>
                    <Col xs='auto' className='px-3 align-self-center'>
                        <p className='mb-0'>~</p>
                    </Col>
                    <Col>
                        <Form.Control id='filter_checkinDateTo' type='date' value={value.valueTo} 
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
        setter.setCheckinDate({
            ...value,
            [colName] : colVal
        }, onSet);
    };
}

export default CheckinDate;