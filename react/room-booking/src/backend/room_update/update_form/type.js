import React, { Component } from 'react';
import SelectFormInput from '../../../hoc/form/select-form-input';

class Type extends Component {

    render() {

        const options = ['---- 請選擇 ----', '標準雙人房', '標準雙人房', 
                '標準雙人房', '標準雙人房'];

        return (
            <SelectFormInput text='房型選擇' options={options} />
        );
    }
}

export default Type;