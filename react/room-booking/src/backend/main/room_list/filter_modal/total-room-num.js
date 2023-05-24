import React, { Component } from 'react';
import RangeFormInput from '../../../../hoc/form/range-form-input';

class TotalRoomNum extends Component {

    render() {
        
        return (
            <RangeFormInput text='總房數' type='number' id1='filter_totalRoomMin' id2='filter_totalRoomMax' min1={0} min2={0} />
        );
    }
}

export default TotalRoomNum;