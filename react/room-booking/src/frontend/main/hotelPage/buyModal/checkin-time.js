import React, { Component } from 'react';
import { Form, Stack } from 'react-bootstrap';

class CheckinTime extends Component {

    render() {

        return (
            <Stack direction='horizontal' gap={3}>
                <Form.Label className='mb-0'>預計入住時辰 : </Form.Label>
                <div>
                    <Form.Control type='time' value={this.getter('value')} onChange={this.onChange} required />
                    <Form.Control.Feedback type='invalid'>請選擇預計入住時辰</Form.Control.Feedback>
                </div>
            </Stack>
        );
    }


    // on
    onChange = (event) => {

        this.setter('value', event.target.value);
    };


    // setter getter
    setter = (colName, colVal, onSet) => {

        const {setter, getter} = this.props;

        setter.setCheckinTime({
            ...getter.getCheckinTime(),
            [colName] : colVal
        }, onSet);
    };
    getter = (colName) => {

        const {getter} = this.props;
        return getter.getCheckinTime()[colName];
    }
}

export default CheckinTime;