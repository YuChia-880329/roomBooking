import React, { Component } from 'react';
import SelectFormInput from '../../../../hoc/form/select-form-input';

class Scene extends Component {

    render() {

        const options = ['---- 請選擇 ----', '市景', '山景', '海景', '無窗', '其他'];

        return (
            <SelectFormInput text='景觀' options={options} />
        );
    }
}

export default Scene;