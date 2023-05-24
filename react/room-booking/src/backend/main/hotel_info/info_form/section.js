import React, { Component } from 'react';
import SelectFormInput from '../../../../hoc/form/select-form-input';

class Section extends Component {

    render() {

        const options = ['---- 請選擇 ----', '台北市', '新北市'];

        return (
            <SelectFormInput text='飯店地址區域' options={options} />
        );
    }
}

export default Section;