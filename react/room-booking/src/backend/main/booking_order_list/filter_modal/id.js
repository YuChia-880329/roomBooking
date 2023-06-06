import React, { Component } from 'react';
import { Col, Form, Row } from 'react-bootstrap';

class Id extends Component {

    render() {
        
        const {value} = this.props;
        
        return (
            <Form.Group as={Row}>
                <Form.Label column xs='auto' htmlFor='filter_idMin'>訂單編號 : </Form.Label>
                <Col>
                    <Form.Control id='filter_idMin' type='number' value={value.valueMin} 
                            onChange={e => this.onChange(e, 'valueMin')} />
                </Col>
                <Col xs='auto' className='px-3 align-self-center'>
                    <p className='mb-0'>~</p>
                </Col>
                <Col>
                    <Form.Control id='filter_idMax' type='number' value={value.valueMax} 
                            onChange={e => this.onChange(e, 'valueMax')} />
                </Col>
            </Form.Group>
        );
    }

    // on
    onChange = (event, colName) => {

        this.setter(colName, event.target.value);
    }

    // setter
    setter = (colName, colVal, onSet) => {

        const {setter, value} = this.props;
        setter.setId({
            ...value,
            [colName] : colVal
        }, onSet);
    };
}

export default Id;