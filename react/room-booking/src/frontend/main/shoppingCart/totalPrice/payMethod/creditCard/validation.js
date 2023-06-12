import React, { Component } from 'react';
import { Form, Stack } from 'react-bootstrap';

class Validation extends Component {

    render() {

        return (
            <Stack direction='horizontal' gap={3}>
                <Form.Label className='mb-0'>信用卡檢核碼 : </Form.Label>
                <div>
                    <Form.Control htmlSize={3}></Form.Control>
                </div>
            </Stack>
        );
    }
}

export default Validation;