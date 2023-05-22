import React, { Component } from 'react';
import RangeFormInput from '../../../hoc/form/range-form-input';

class RoomNum extends Component {

    render() {
        
        return (
            <RangeFormInput type='number' text='預定房間數' id1='filter_roomNumMin' id2='filter_roomNumMax' min1={0} min2={0} />
        );
    }
}

export default RoomNum;