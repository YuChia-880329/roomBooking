import React, { Component } from 'react';
import { Button, Col, Form, Row } from 'react-bootstrap';

class ShoppingCartForm extends Component {

    render() {

        return (
            <Form.Group as={Row}>
                <Form.Label column xs='auto' htmlFor='room_num'>數量 : </Form.Label>
                <Col xs='auto'>
                    <Form.Control id='room_num' type='number' min={0} />
                </Col>
                <Col xs='auto'>
                    <Button variant='outline-primary'>加入購物車</Button>
                </Col>
            </Form.Group>
        );
    }
}

export default ShoppingCartForm;