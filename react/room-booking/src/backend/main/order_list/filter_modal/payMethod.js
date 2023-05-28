import React, { Component } from 'react';
import { Col, Form, Row } from 'react-bootstrap';

class PayMethod extends Component {

    render() {

        const rowStyle = {
            paddingTop : 'calc(.375rem + 1px)'
        };
        const checkboxStyle = {
            margin : '0'
        };
        const checks = ['現金', '信用卡付款'];

        return (
            <Form.Group as={Row}>
                <Form.Label column xs='auto'>付款方式 : </Form.Label>
                <Col>
                    <Row xs='auto' className='g-3' style={rowStyle}>
                        {
                            checks.map((check, index) => (
                                <Col key={index}>
                                    <Form.Check type='checkbox' label={check} style={checkboxStyle} />
                                </Col>
                            ))
                        }
                    </Row>
                </Col>
            </Form.Group>
        );
    }
}

export default PayMethod;