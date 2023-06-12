import React, { Component } from 'react';
import { Col, Form, Row } from 'react-bootstrap';

class Account extends Component {

    render() {

        return (
            <Form.Group as={Row}>
                <Form.Label column xs='auto' htmlFor='form_account'>帳號 : </Form.Label>
                <Col>
                    <Form.Control id='form_account' htmlSize='30'  />
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
        setter.setAccount({
            ...values,
            [colName] : colVal
        }, onSet);
    };
}

export default Account;