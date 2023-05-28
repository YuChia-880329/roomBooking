import '../../../../css/custom.css';
import React, { Component } from 'react';
import { Form, Row, Col, Button, Stack } from 'react-bootstrap';

class Feature extends Component {

    render() {

        const rowStyle = {
            paddingTop : 'calc(.375rem + 1px)'
        };
        const checkboxStyle = {
            margin : '0'
        };

        const checks = ['房內免費Wi-Fi', '停車場', '可寄放行李', '房內免費Wi-Fi', 
                '停車場', '可寄放行李', '房內免費Wi-Fi', '停車場', '可寄放行李'];

        return (
            <Form.Group as={Row}>
                <Form.Label column xs='auto' htmlFor='form_description'>飯店特色 : </Form.Label>
                <Col>
                    <Stack gap={5}>
                        <Row xs={4} className='g-3' style={rowStyle}>
                            {
                                checks.map((check, index) => (
                                    <Col key={index}>
                                        <Form.Check type='checkbox' label={check} style={checkboxStyle} />
                                    </Col>
                                ))
                            }
                        </Row>
                        <Row xs={3} className='g-3' style={rowStyle}>
                            {
                                checks.map((check, index) => (
                                    <Col key={index}>
                                        <Stack direction='horizontal' gap={4}>
                                            <Form.Check type='checkbox' label={check} style={checkboxStyle} />
                                            <div>
                                                <Button variant='outline-primary' size='sm' className='little-btn'>-</Button>
                                            </div>
                                        </Stack>
                                    </Col>
                                ))
                            }
                        </Row>
                        <Row>
                            <Form.Label column xs='auto' htmlFor='form_newFeature'>新增選項 : </Form.Label>
                            <Col xs='auto'>
                                <Form.Control id='form_newFeature' htmlSize={15} />
                            </Col>
                            <Col xs='auto' className='align-self-center'>
                                <Button variant='outline-primary' size='sm'>+</Button>
                            </Col>
                        </Row>
                    </Stack>
                </Col>
            </Form.Group>
        );
    }
}

export default Feature;