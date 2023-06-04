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
        const {values, onChange, fctn} = this.props;

        return (
            <Form.Group as={Row}>
                <Form.Label column xs='auto'>付款方式 : </Form.Label>
                <Col>
                    <Row xs='auto' className='g-3' style={rowStyle}>
                        {
                            fctn.getAllPayMethods().map(payMethod => (
                                <Col key={payMethod.id}>
                                    <Form.Check type='checkbox' label={payMethod.name} style={checkboxStyle} value={payMethod.id}
                                            checked={values.includes(`${payMethod.id}`)} onChange={onChange} />
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