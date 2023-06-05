import React, { Component } from 'react';
import { Col, Form, Row } from 'react-bootstrap';

class Password extends Component {

    render() {

        const {value} = this.props;

        return (
            <Form.Group as={Row}>
                <Form.Label column xs='auto' htmlFor='form_account'>密碼 : </Form.Label>
                <Col>
                    <Form.Control id='form_password' type='password' htmlSize='30' value={value.value} onChange={this.onChange} required />
                    <Form.Control.Feedback type='invalid'>請填寫密碼</Form.Control.Feedback>
                </Col>
            </Form.Group>
       );
    }

    onChange = (event) => {

        this.setter('value', event.target.value);
    };

    // setter
    setter = (colName, colVal, onSet) => {

        const {setter, values} = this.props;
        setter({
            ...values,
            [colName] : colVal
        }, onSet);
    };
}

export default Password;