import React, { Component } from 'react';
import { Col, Form, Row } from 'react-bootstrap';

class ClientName extends Component {

    render() {
        
        const {value} = this.props;

        return (
            <Form.Group as={Row}>
                <Form.Label column xs='auto' htmlFor='filter_clientName'>客人姓名 : </Form.Label>
                <Col>
                    <Form.Control id='filter_clientName' value={value.value} onChange={this.onChange} />
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
        setter.setClientName({
            ...value,
            [colName] : colVal
        }, onSet);
    };
}

export default ClientName;