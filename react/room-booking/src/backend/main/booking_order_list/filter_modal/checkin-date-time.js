import React, { Component } from 'react';
import { Col, Form, Row, Stack } from 'react-bootstrap';

class CheckinDateTime extends Component {

    render() {
        
        return (
            <Form.Group>
                <Form.Label htmlFor='filter_checkinDateTimeFrom'>預定入住日期 : </Form.Label>
                <Stack>
                    <div>
                        <Form.Control id='filter_checkinDateTimeFrom' type='datetime-local' />
                    </div>
                    <div xs='auto' className='px-3 align-self-center'>
                        <p className='mb-0'>↓</p>
                    </div>
                    <div>
                        <Form.Control id='filter_checkinDateTimeTo' type='datetime-local' />
                    </div>
                </Stack>
            </Form.Group>
        );
    }
}

export default CheckinDateTime;