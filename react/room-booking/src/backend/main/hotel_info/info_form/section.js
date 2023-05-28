import React, { Component } from 'react';
import { Col, Form, Row } from 'react-bootstrap';

class Section extends Component {

    render() {

        const options = ['---- 請選擇 ----', '台北市', '新北市'];

        return (
            <Form.Group as={Row}>
                <Form.Label column xs='auto'>飯店地址區域 : </Form.Label>
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

export default Section;