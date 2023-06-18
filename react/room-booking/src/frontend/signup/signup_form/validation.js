import React, { Component } from 'react';
import { Col, Form, Row } from 'react-bootstrap';

class Validation extends Component {

    render() {

        return (
            <Form.Group as={Row}>
                <Form.Label column xs='auto' htmlFor='form_validation'>驗證碼 : </Form.Label>
                <Col>
                    <Form.Control id='form_validation' htmlSize='30' value={this.getter('value')}
                            onChange={this.onChange} required />
                    <Form.Control.Feedback type='invalid'>請填寫驗證碼</Form.Control.Feedback>
                </Col>
                <Form.Label column xs='auto' htmlFor='form_validation'>
                    <span>{this.getter('number')}</span>
                </Form.Label>
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

        setter.setValidation({
            ...getter.getValidation(),
            [colName] : colVal
        }, onSet);
    };
    getter = (colName) => {

        const {getter} = this.props;
        return getter.getValidation()[colName];
    }
}

export default Validation;