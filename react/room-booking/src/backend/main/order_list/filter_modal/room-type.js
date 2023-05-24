import React, { Component } from 'react';
import SelectFormInput from '../../../../hoc/form/select-form-input';

class RoomType extends Component {
    
    render() {

        const options = ['---- 請選擇 ----', '標準雙人房', '標準雙人房'
                , '標準雙人房', '標準雙人房'];

        return (
            <SelectFormInput text='預定房型' options={options} />
        );
    }
}

export default RoomType;