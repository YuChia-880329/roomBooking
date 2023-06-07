import React, { Component } from 'react';
import { Col, Form, Row } from 'react-bootstrap';
    
class Price extends Component {

    render() {
        
        const {value} = this.props;

        return (
            <Form.Group as={Row}>
                <Form.Label column xs='auto' htmlFor='form_price'>房間單價 : </Form.Label>
                <Col>
                    <Form.Control type='number' id='form_price' value={value.value} onChange={this.onChange} min={0} />
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
        
        setter.setPrice({
            ...value,
            [colName] : colVal
        }, onSet);
    };
}

export default Price;