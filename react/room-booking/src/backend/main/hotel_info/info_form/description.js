import React, { Component } from 'react';
import { Col, Form, Row } from 'react-bootstrap';

class Description extends Component {

    render() {
        
        const {value} = this.props;
        
        return (
            <Form.Group as={Row}>
                <Form.Label column xs='auto' htmlFor='form_description'>飯店介紹 : </Form.Label>
                <Col>
                    <Form.Control as='textarea' id='form_description' value={value.value} onChange={this.onChange} />
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
        setter.setDescription({
            ...value,
            [colName] : colVal
        }, onSet);
    };
}

export default Description;