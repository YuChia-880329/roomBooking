import React, { Component } from 'react';
import { Col, Form, Row, Stack } from 'react-bootstrap';

class HorizontalFormInput extends Component {

    render() {

        // props
        const {id, text, Ctrl, AddCtrl} = this.props;

        return (
            <Form.Group as={Row}>
                <Form.Label column xs='auto' htmlFor={id}>{text} : </Form.Label>
                <Col>
                    <Stack gap={4}>
                        <Ctrl />
                        {AddCtrl ? <AddCtrl /> : null }
                    </Stack>
                </Col>
            </Form.Group>
        );
    }
}

export default HorizontalFormInput;