import React, { Component } from 'react';
import { Col, Form, Row } from 'react-bootstrap';

class Area extends Component {

    render() {
        
        const {value} = this.props;

        return (
            <Form.Group as={Row}>
                <Form.Label column xs='auto' htmlFor='form_area'>房型面積 : </Form.Label>
                <Col>
                    <Form.Control required id='form_area' type='number' value={value.value} onChange={this.onChange} 
                            min={0} placeholder='(平方公尺)' />
                    <Form.Control.Feedback type='invalid'>請輸入房型面積(不可小於0)</Form.Control.Feedback>
                </Col>
            </Form.Group>
        );
    }

    // on
    onChange = (event) => {

        this.setter('value', event.target.value);
    };


    // setter
    setter = (colName, colVal, onSet) => {

        const {setter, value} = this.props;
        
        setter.setArea({
            ...value,
            [colName] : colVal
        }, onSet);
    };
}

export default Area;