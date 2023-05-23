import React, { Component } from 'react';
import RangeFormInput from '../../../hoc/form/range-form-input';

class UseDay extends Component {

    render() {

        return (
            <RangeFormInput type='number' text='入住天數' id1='filter_useDayMin' id2='filter_useDayMax' min1={0} min2={0} />
        );
    }
}

export default UseDay;