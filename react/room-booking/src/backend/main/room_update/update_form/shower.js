import React, { Component } from 'react';
import CheckboxFormInput from '../../../../hoc/form/checkbox-form-input';

class Shower extends Component {

    render() {

        const checks = ['淋浴設備', '浴缸', '蒸氣室'];

        return (
            <CheckboxFormInput text='沐浴設備' rowColsNum='auto' checks={checks} />
        );
    }
}

export default Shower;