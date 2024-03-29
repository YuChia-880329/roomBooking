import React, { Component } from 'react';
import { Form, Row, Col } from 'react-bootstrap';

class UpdateImage extends Component {

    render() {
       
        return (
            <Form.Group as={Row}>
                <Form.Label column xs='auto' htmlFor='form_updateImage'>更新照片 : </Form.Label>
                <Col>
                    <Row>
                        <Col xs='auto'>
                            <Form.Control id='form_updateImage' name='hotelImage' type='file' />
                        </Col>
                    </Row>
                </Col>
            </Form.Group>
        );
    }
}

export default UpdateImage;