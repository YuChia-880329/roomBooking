import React, { Component } from 'react';
import RangeFormInput from '../../../../hoc/form/range-form-input';

class UsedRoomNum extends Component {

    render() {
        
        return (
            <RangeFormInput text='使用中房數' type='number' id1='filter_usedRoomMin' id2='filter_usedRoomMax' min1={0} min2={0} />
        );
    }
}

export default UsedRoomNum;