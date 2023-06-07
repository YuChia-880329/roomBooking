import React, { Component } from 'react';
import { Col, Form, Row } from 'react-bootstrap';

class TotalNum extends Component {

    render() {
        
        const {value} = this.props;

        return (
            <Form.Group as={Row}>
                <Form.Label column xs='auto' htmlFor='form_totalNumber'>總房數 : </Form.Label>
                <Col>
                    <Form.Control type='number' id='form_totalNumber' value={value.value} onChange={this.onChange} min={1} />
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
        setter.setTotalNum({
            ...value,
            [colName] : colVal
        }, onSet);
    };
}

export default TotalNum;