import React, { Component } from 'react';
import { Col, Form, Row } from 'react-bootstrap';

class Type extends Component {

    render() {

        const options = ['---- 請選擇 ----', '標準雙人房', '標準雙人房', 
                '標準雙人房', '標準雙人房'];

        return (
            <Form.Group as={Row}>
                <Form.Label column xs='auto'>房型選擇 : </Form.Label>
                <Col>
                    <Form.Select>
                        {options.map(
                            opt => (
                                <option key={opt}>{opt}</option>
                            )
                        )}
                    </Form.Select>
                </Col>
            </Form.Group>
        );
    }
}

export default Type;