import React, { Component } from 'react';
import RangeFormInput from '../../../hoc/form/range-form-input';

class Id extends Component {

    render() {
        
        return (
            <RangeFormInput text='訂單編號' type='number' id1='filter_idMin' id2='filter_idMax' min1={0} min2={0} />
        );
    }
}

export default Id;