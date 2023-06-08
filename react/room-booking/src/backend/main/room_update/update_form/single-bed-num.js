import React, { Component } from 'react';
import { Col, Form, Row } from 'react-bootstrap';

class SingleBedNum extends Component {

    render() {
        
        const {value} = this.props;
        
        return (
            <Form.Group as={Row}>
                <Form.Label column xs='auto' htmlFor='form_singleBed'>單人床數 : </Form.Label>
                <Col>
                    <Form.Control type='number' id='form_singleBed' value={value.value} onChange={this.onChange} 
                            disabled={value.disabled} min={0} />
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
        
        setter.setSingleBedNum({
            ...value,
            [colName] : colVal
        }, onSet);
    };
}

export default SingleBedNum;