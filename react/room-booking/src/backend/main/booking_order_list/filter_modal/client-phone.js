import React, { Component } from 'react';
import { Col, Form, Row } from 'react-bootstrap';

class ClientPhone extends Component {

    render() {
        
        const {value} = this.props;
        
        return (
            <Form.Group as={Row}>
                <Form.Label column xs='auto' htmlFor='filter_phone'>客人手機 : </Form.Label>
                <Col>
                    <Form.Control id='filter_phone' value={value.value} onChange={this.onChange} />
                </Col>
            </Form.Group>
        );
    }

     // on
     onChange = (event) => {

        this.setter('value', event.target.value);
    }


    // setter
    setter = (colName, colVal, onSet) => {

        const {setter, value} = this.props;
        setter.setClientPhone({
            ...value,
            [colName] : colVal
        }, onSet);
    };
}

export default ClientPhone;