import React, { Component } from 'react';
import { Col, Form, Row, Stack } from 'react-bootstrap';
import CreditCard from './payMethod/credit-card';

const constant = {
    options : ['現金', '信用卡']
};

class PayMethod extends Component {

    render() {

        return (
            <Form.Group as={Stack} gap={4}>
                <Row>
                    <Form.Label column xs='auto'>付款方式 : </Form.Label>
                    <Col>
                        <Form.Control as='select'>
                            <option value=''>---- 請選擇 ----</option>
                            {
                                constant.options.map(
                                    op => (
                                        <option key={op}>{op}</option>
                                    )
                                )
                            }
                        </Form.Control>
                    </Col>
                </Row>
                <CreditCard />
            </Form.Group>
        );
    }
}

export default PayMethod;