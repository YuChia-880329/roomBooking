import React, { Component } from 'react';
import { Form, Stack } from 'react-bootstrap';

class CheckinTime extends Component {
    render() {
        return (
            <Stack direction='horizontal' gap={3}>
                <Form.Label className='mb-0'>預計入住時辰 : </Form.Label>
                <div>
                    <Form.Control type='time' />
                </div>
            </Stack>
        );
    }
}

export default CheckinTime;