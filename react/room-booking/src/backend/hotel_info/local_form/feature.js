import React, { Component } from 'react';
import { Form, Row, Col, Button } from 'react-bootstrap';


class Feature extends Component {
    render() {

        // style
        const checkboxStyle = {
            marginBottom : 0
        };
        const featureStyle = {
            paddingTop : 'calc(.375rem + 1px)'
        };
        
        return (
            <Form.Group>
                <Row>
                    <Form.Label column xs={2}>飯店特色  : </Form.Label>
                    
                    <Col xs={10} style={featureStyle}>
                        <Row xs={4} className='g-3'>
                            <Col>
                                <Form.Check type='checkbox' label='房內免費Wi-Fi' style={checkboxStyle} inline />
                            </Col>
                            <Col>
                                <Form.Check type='checkbox' label='停車場' style={checkboxStyle} inline />
                            </Col>
                            <Col>
                                <Form.Check type='checkbox' label='可寄放行李' style={checkboxStyle} inline />
                            </Col>
                            <Col>
                                <Form.Check type='checkbox' label='房內免費Wi-Fi' style={checkboxStyle} inline />
                            </Col>
                            <Col>
                                <Form.Check type='checkbox' label='停車場' style={checkboxStyle} inline />
                            </Col>
                            <Col>
                                <Form.Check type='checkbox' label='房內免費Wi-Fi' style={checkboxStyle} inline />
                            </Col>
                            <Col>
                                <Form.Check type='checkbox' label='停車場' style={checkboxStyle} inline />
                            </Col>
                            <Col>
                                <Form.Check type='checkbox' label='可寄放行李' style={checkboxStyle} inline />
                            </Col>
                            <Col>
                                <Form.Check type='checkbox' label='房內免費Wi-Fi' style={checkboxStyle} inline />
                            </Col>
                            <Col>
                                <Form.Check type='checkbox' label='停車場' style={checkboxStyle} inline />
                            </Col>
                        </Row>
                    </Col>
                </Row>
                <Row className='mt-4'>
                    <Col xs={{offset : 2}}>
                        <Form>
                            <Form.Group as={Row}>
                                <Form.Label column xs='auto' htmlFor='newFeature'>新增選項 : </Form.Label>
                                <Col xs='auto'>
                                    <Form.Control  id='newFeature' htmlSize={15} />
                                </Col>
                                <Col xs='auto' className='align-self-center'>
                                    <Button variant='outline-primary' size='sm'>+</Button>
                                </Col>
                            </Form.Group>
                        </Form>
                    </Col>
                </Row>
            </Form.Group>
        );
    }
}

export default Feature;