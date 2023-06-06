import React, { Component } from 'react';
import { Form, Stack } from 'react-bootstrap';

class CheckinDateTime extends Component {

    render() {
        
        const {value} = this.props;

        return (
            <Form.Group>
                <Form.Label htmlFor='filter_checkinDateTimeFrom'>預定入住日期 : </Form.Label>
                <Stack>
                    <div>
                        <Form.Control id='filter_checkinDateTimeFrom' type='datetime-local' value={value.valueFrom} 
                                onChange={e => this.onChange(e, 'valueFrom')} />
                    </div>
                    <div xs='auto' className='px-3 align-self-center'>
                        <p className='mb-0'>↓</p>
                    </div>
                    <div>
                        <Form.Control id='filter_checkinDateTimeTo' type='datetime-local' value={value.valueTo} 
                                onChange={e => this.onChange(e, 'valueTo')} />
                    </div>
                </Stack>
            </Form.Group>
        );
    }

    // on
    onChange = (event, colName) => {

        this.setter(colName, event.target.value);
    }

    // setter
    setter = (colName, colVal, onSet) => {

        const {setter, value} = this.props;
        setter.setCheckinDateTime({
            ...value,
            [colName] : colVal
        }, onSet);
    };
}

export default CheckinDateTime;