import React, { Component } from 'react';
import { Col, Form, Row } from 'react-bootstrap';

class Password extends Component {

    render() {

        return (
            <Form.Group as={Row}>
                <Form.Label column xs='auto' htmlFor='form_account'>密碼 : </Form.Label>
                <Col>
                    <Form.Control id='form_password' type='password' htmlSize='30' value={this.getter('value')}
                            onChange={this.onChange} required />
                    <Form.Control.Feedback type='invalid'>請填寫密碼</Form.Control.Feedback>
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

        setter.setPassword({
            ...getter.getPassword(),
            [colName] : colVal
        }, onSet);
    };
    getter = (colName) => {

        const {getter} = this.props;
        return getter.getPassword()[colName];
    }
}

export default Password;