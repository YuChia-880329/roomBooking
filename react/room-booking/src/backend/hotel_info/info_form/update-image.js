import React, { Component } from 'react';
import { Form, Row, Col, Button } from 'react-bootstrap';
import HorizontalFormInput from '../../../hoc/form/horizontal-form-input';

class UpdateImage extends Component {

    ctrl = () => {
        return (
            <Row>
                <Col xs='auto'>
                    <Form.Control id='updateImage' type='file' />
                </Col>
                <Col xs='auto' className='ms-4 align-self-center'>
                    <Button variant='outline-primary' size='sm'>更新</Button>
                </Col>
            </Row>
        );
    };
    render() {
        return (
            <HorizontalFormInput text='更新照片' Ctrl={this.ctrl} />
        );
    }
}

export default UpdateImage;