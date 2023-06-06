import React, { Component } from 'react';
import { Col, Form, Row } from 'react-bootstrap';

class Address extends Component {

    render() {
        
        const {value} = this.props;

        return (
            <Form.Group as={Row}>
                <Form.Label column xs='auto' htmlFor='form_address'>飯店地址 : </Form.Label>
                <Col>
                    <Form.Control id='form_address' value={value.value} onChange={this.onChange} />
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
        setter.setAddress({
            ...value,
            [colName] : colVal
        }, onSet);
    };
}

export default Address;