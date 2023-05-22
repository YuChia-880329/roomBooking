import React, { Component } from 'react';
import RangeFormInput from '../../../hoc/form/range-form-input';

class ValidRoomNum extends Component {
    render() {
        return (
            <RangeFormInput text='開放空房數' type='number' id1='filter_validRoomMin' id2='filter_validRoomMax' min1={0} min2={0} />
        );
    }
}

export default ValidRoomNum;