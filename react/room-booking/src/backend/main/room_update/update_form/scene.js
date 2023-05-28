import React, { Component } from 'react';
import { Col, Form, Row } from 'react-bootstrap';

class Scene extends Component {

    render() {

        const options = ['---- 請選擇 ----', '市景', '山景', '海景', '無窗', '其他'];

        return (
            <Form.Group as={Row}>
                <Form.Label column xs='auto'>景觀 : </Form.Label>
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

export default Scene;