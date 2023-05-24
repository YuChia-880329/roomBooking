import React, { Component } from 'react';
import RangeFormInput from '../../../../hoc/form/range-form-input';

class InvalidRoomNum extends Component {

    render() {
        
        return (
            <RangeFormInput text='不開放房數' type='number' id1='filter_invalidRoomMin' id2='filter_invalidRoomMax' min1={0} min2={0} />
        );
    }
}

export default InvalidRoomNum;