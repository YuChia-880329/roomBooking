import React, { Component } from 'react';
import { Form, Row, Col, Button } from 'react-bootstrap';

class UpdateImage extends Component {
    render() {
        return (
            <Form.Group as={Row}>
                <Form.Label column xs='auto' htmlFor='updateImage'>更新照片  : </Form.Label>
                <Col xs='auto'>
                    <Form.Control id='updateImage' type='file' />
                </Col>
                <Col xs='auto' className='ms-4 align-self-center'>
                    <Button variant='outline-primary' size='sm'>更新</Button>
                </Col>
            </Form.Group>
        );
    }
}

export default UpdateImage;