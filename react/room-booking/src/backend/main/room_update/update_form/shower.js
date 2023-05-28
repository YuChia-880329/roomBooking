import React, { Component } from 'react';
import { Col, Form, Row } from 'react-bootstrap';

class Shower extends Component {

    render() {

        const rowStyle = {
            paddingTop : 'calc(.375rem + 1px)'
        };
        const checkboxStyle = {
            margin : '0'
        };
        
        const checks = ['淋浴設備', '浴缸', '蒸氣室'];

        return (
            <Form.Group as={Row}>
                <Form.Label column xs='auto'>沐浴設備 : </Form.Label>
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

export default Shower;