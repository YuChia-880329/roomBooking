import React, { Component } from 'react';
import { Button, Col, Form, Row, Stack } from 'react-bootstrap';

class NewImage extends Component {

    render() {
        
        return (
            <Form.Group as={Row}>
                <Form.Label column xs='auto' htmlFor='form_newImage1'>新增照片 : </Form.Label>
                <Col>
                    <Row>
                        <Col xs='auto'>
                            <Stack gap={4}>
                                <Stack direction='horizontal' gap={4}>
                                    <Form.Control type='file' id='form_newImage1' />
                                    <div>
                                        <Button variant='outline-primary' size='sm'>-</Button>
                                    </div>
                                </Stack>
                                <Stack direction='horizontal' gap={4}>
                                    <Form.Control type='file' id='form_newImage2' />
                                    <div>
                                        <Button variant='outline-primary' size='sm'>-</Button>
                                    </div>
                                </Stack>
                                <div>
                                    <Button variant='outline-primary' size='sm'>+</Button>
                                </div>
                            </Stack>
                        </Col>
                    </Row>
                </Col>
            </Form.Group>
        );
    }
}

export default NewImage;