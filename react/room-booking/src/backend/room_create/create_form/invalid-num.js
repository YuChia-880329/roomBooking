import React, { Component } from 'react';
import SelectFormInput from '../../../hoc/form/select-form-input';

class InvalidNum extends Component {

    render() {
        
        const options = ['---- 請選擇 ----', '1', '2', '3', '4'];

        return (
            <SelectFormInput text='不開放房數' options={options} />
        );
    }
}

export default InvalidNum;