import React, { Component } from 'react';
import { Form, Stack } from 'react-bootstrap';

class CardNumber extends Component {

    render() {

        return (
            <Stack>
                <Form.Label htmlFor='card_number1'>信用卡卡號</Form.Label>
                <Stack direction='horizontal' gap={2}>
                    <Form.Control id='card_number1' htmlSize={4} />
                    <div>-</div>
                    <Form.Control id='card_number2' htmlSize={4} />
                    <div>-</div>
                    <Form.Control id='card_number3' htmlSize={4} />
                    <div>-</div>
                    <Form.Control id='card_number4' htmlSize={4} />
                </Stack>
            </Stack>
        );
    }
}

export default CardNumber;