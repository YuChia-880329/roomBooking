import React, { Component } from 'react';
import { Form, Stack } from 'react-bootstrap';

class Num extends Component {
    render() {
        return (
            <Stack direction='horizontal' gap={3}>
                <Form.Label className='mb-0'>房間數量 : </Form.Label>
                <div>
                    <Form.Control type='number' min={0} />
                </div>
            </Stack>
        );
    }
}

export default Num;