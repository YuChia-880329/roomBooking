import React, { Component } from 'react';
import RangeFormInput from '../../../hoc/form/range-form-input';

class TotalPrice extends Component {

    render() {
        
        return (
            <RangeFormInput type='number' text='總金額' id1='filter_totalPriceMin' id2='filter_totalPriceMax' min1={0} min2={0} />
        );
    }
}

export default TotalPrice;