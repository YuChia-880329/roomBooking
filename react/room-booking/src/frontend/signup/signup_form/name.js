import React, { Component } from 'react';
import { Col, Form, Row } from 'react-bootstrap';

class Name extends Component {

    render() {

        return (
            <Form.Group as={Row}>
                <Form.Label column xs='auto' htmlFor='form_name'>姓名 : </Form.Label>
                <Col>
                    <Form.Control id='form_name' htmlSize='30' value={this.getter('value')}
                            onChange={this.onChange} required />
                    <Form.Control.Feedback type='invalid'>請填寫姓名</Form.Control.Feedback>
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

        setter.setName({
            ...getter.getName(),
            [colName] : colVal
        }, onSet);
    };
    getter = (colName) => {

        const {getter} = this.props;
        return getter.getName()[colName];
    }
}

export default Name;