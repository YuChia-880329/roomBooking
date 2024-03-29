import React, { Component } from 'react';
import { Col, Form, Row } from 'react-bootstrap';

class DoubleBedNum extends Component {

    render() {
        
        const {value} = this.props;
        
        return (
            <Form.Group as={Row}>
                <Form.Label column xs='auto' htmlFor='form_doubleBed'>雙人床數 : </Form.Label>
                <Col>
                    <Form.Control required id='form_doubleBed' type='number' value={value.value} onChange={this.onChange} 
                            min={0} />
                    <Form.Control.Feedback type='invalid'>請輸入雙人床數(不可小於0)</Form.Control.Feedback>
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
        
        setter.setDoubleBedNum({
            ...value,
            [colName] : colVal
        }, onSet);
    };
}

export default DoubleBedNum;