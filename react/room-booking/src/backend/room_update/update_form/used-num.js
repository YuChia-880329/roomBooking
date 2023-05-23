import React, { Component } from 'react';
import SelectFormInput from '../../../hoc/form/select-form-input';

class UsedNum extends Component {
    
    render() {

        const options = ['---- 請選擇 ----', '1', '2', '3', '4'];

        return (
            <SelectFormInput text='使用中房數' options={options} />
        );
    }
}

export default UsedNum;