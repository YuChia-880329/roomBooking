import React, { Component } from 'react';
import CheckboxFormInput from '../../../../hoc/form/checkbox-form-input';

class PayMethod extends Component {

    render() {

        const checks = ['現金', '信用卡付款'];

        return (
            <CheckboxFormInput text='付款方式' rowColsNum='auto' checks={checks} />
        );
    }
}

export default PayMethod;