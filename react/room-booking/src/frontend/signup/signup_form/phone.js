import React, { Component } from 'react';
import { Col, Form, Row } from 'react-bootstrap';

class Phone extends Component {

    render() {

        return (
            <Form.Group as={Row}>
                <Form.Label column xs='auto' htmlFor='form_phone'>手機號碼 : </Form.Label>
                <Col>
                    <Form.Control id='form_phone' htmlSize='30' value={this.getter('value')}
                            onChange={this.onChange} required />
                    <Form.Control.Feedback type='invalid'>請填寫手機號碼</Form.Control.Feedback>
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

        setter.setPhone({
            ...getter.getPhone(),
            [colName] : colVal
        }, onSet);
    };
    getter = (colName) => {

        const {getter} = this.props;
        return getter.getPhone()[colName];
    }
}

export default Phone;