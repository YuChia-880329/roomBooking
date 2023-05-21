import React, { Component } from 'react';
import { Button, Col, Form, Row, Stack } from 'react-bootstrap';
import HorizontalFormInput from '../../../hoc/form/horizontal-form-input';

class NewImage extends Component {

    ctrl = () => {

        // style
        const plusBtnStyle = {
            paddingTop : '0.28rem'
        };

        return (
            <Row>
                <Col xs='auto'>
                    <Stack gap={4}>
                        <Form.Control type='file' id='newImage1' />
                        <Form.Control type='file' id='newImage2' />
                    </Stack>
                </Col>
                <Col style={plusBtnStyle}>
                    <Button variant='outline-primary' size='sm'>+</Button>
                </Col>
            </Row>
            
            
        );
    };
    render() {
        return (
            <HorizontalFormInput id='newImage1' text='新增照片' Ctrl={this.ctrl} />
        );
    }
}

export default NewImage;