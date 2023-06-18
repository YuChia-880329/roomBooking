import React, { Component } from 'react';
import { Col, Form, Row } from 'react-bootstrap';

class Account extends Component {

    render() {

        return (
            <Form.Group as={Row}>
                <Form.Label column xs='auto' htmlFor='form_account'>帳號 : </Form.Label>
                <Col>
                    <Form.Control id='form_account' htmlSize='30' value={this.getter('value')}
                            onChange={this.onChange} required />
                    <Form.Control.Feedback type='invalid'>請填寫帳號</Form.Control.Feedback>
                </Col>
            </Form.Group>
        );
    }

    // on
    onChange = (event) => {

        this.setter('value', event.target.value);
    };


    // setter getter
    setter = (colName, colVal, onSet) => {

        const {setter, getter} = this.props;

        setter.setAccount({
            ...getter.getAccount(),
            [colName] : colVal
        }, onSet);
    };
    getter = (colName) => {

        const {getter} = this.props;
        return getter.getAccount()[colName];
    }
}

export default Account;