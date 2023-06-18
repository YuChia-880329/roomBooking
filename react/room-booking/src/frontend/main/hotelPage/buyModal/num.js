import React, { Component } from 'react';
import { Form, Stack } from 'react-bootstrap';

class Num extends Component {

    render() {

        return (
            <Stack direction='horizontal' gap={3}>
                <Form.Label className='mb-0'>房間數量 : </Form.Label>
                <div>
                    <Form.Control type='number' min={1} value={this.getter('value')} onChange={this.onChange} required />
                    <Form.Control.Feedback type='invalid'>請輸入房間數量</Form.Control.Feedback>
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

        setter.setNum({
            ...getter.getNum(),
            [colName] : colVal
        }, onSet);
    };
    getter = (colName) => {

        const {getter} = this.props;
        return getter.getNum()[colName];
    }
}

export default Num;