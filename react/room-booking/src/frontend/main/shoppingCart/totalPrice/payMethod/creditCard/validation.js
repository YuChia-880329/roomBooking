import React, { Component, createRef } from 'react';
import { Form, Stack } from 'react-bootstrap';

class Validation extends Component {

    controllerRef = createRef();

    render() {

        return (
            <Stack direction='horizontal' gap={3}>
                <Form.Label className='mb-0'>信用卡檢核碼 : </Form.Label>
                <div>
                    <Form.Control htmlSize={3} value={this.getter('value')} onChange={this.onChange} ref={this.controllerRef} />
                </div>
            </Stack>
        );
    }


    // on
    onChange = (event) => {

        const value = event.target.value;

        this.setter('value', value, () => {

            if(value.length >= 3)
                this.controllerRef.current.blur();
        });
    }


    // setter getter
    setter = (colName, colVal, onSet) => {

        const {setter, getter} = this.props;

        setter.setValidation({
            ...getter.getValidation(),
            [colName] : colVal
        }, onSet);
    };
    getter = (colName) => {

        const {getter} = this.props;
        return getter.getValidation()[colName];
    }
}

export default Validation;