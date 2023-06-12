import React, { Component } from 'react';
import { Col, Form, Row } from 'react-bootstrap';

const constant = {
    options : [
        '1人', '2人', '3人', '4人', '5人', '6人', '7人', '8人以上'
    ]
}
class Number extends Component {

    render() {

        return (
            <Form.Group as={Row}>
                <Form.Label column xs='auto'>人數 : </Form.Label>
                <Col>
                    <Form.Control as='select'>
                        {
                            constant.options.map(
                                op => (
                                    <option key={op} value={op}>{op}</option>
                                )
                            )          
                        }
                    </Form.Control>
                </Col>
            </Form.Group>
        );
    }
}

export default Number;