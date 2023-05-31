import React, { Component } from 'react';
import { Form, Stack } from 'react-bootstrap';

class CheckinDateTime extends Component {

    render() {
        
        const {valueFrom, valueTo, onChangeFrom, onChangeTo} = this.props;

        return (
            <Form.Group>
                <Form.Label htmlFor='filter_checkinDateTimeFrom'>預定入住日期 : </Form.Label>
                <Stack>
                    <div>
                        <Form.Control id='filter_checkinDateTimeFrom' type='datetime-local' 
                                value={valueFrom} onChange={onChangeFrom} />
                    </div>
                    <div xs='auto' className='px-3 align-self-center'>
                        <p className='mb-0'>↓</p>
                    </div>
                    <div>
                        <Form.Control id='filter_checkinDateTimeTo' type='datetime-local' 
                                value={valueTo} onChange={onChangeTo} />
                    </div>
                </Stack>
            </Form.Group>
        );
    }
}

export default CheckinDateTime;