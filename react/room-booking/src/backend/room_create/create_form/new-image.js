import React, { Component, Fragment } from 'react';
import { Button, Col, Form, Row, Stack } from 'react-bootstrap';
import HorizontalFormInput from '../../../hoc/form/horizontal-form-input';

class NewImage extends Component {


    render() {
        return (
            <HorizontalFormInput id='newImage1' text='新增照片' Ctrl={this.Ctrl} />
        );
    }

    Ctrl = () => {
        return (
            <Fragment>
                <Row>
                    <Col xs='auto'>
                        <Stack gap={4}>
                            <Stack direction='horizontal' gap={4}>
                                <Form.Control type='file' id='newImage1' />
                                <div>
                                    <Button variant='outline-primary' size='sm'>-</Button>
                                </div>
                            </Stack>
                            <Stack direction='horizontal' gap={4}>
                                <Form.Control type='file' id='newImage2' />
                                <div>
                                    <Button variant='outline-primary' size='sm'>-</Button>
                                </div>
                            </Stack>
                        </Stack>
                    </Col>
                </Row>
                <div>
                    <Button variant='outline-primary' size='sm'>+</Button>
                </div>
                
            </Fragment>
        );
    };
}

export default NewImage;