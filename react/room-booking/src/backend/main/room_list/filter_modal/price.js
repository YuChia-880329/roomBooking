import React, { Component } from 'react';
import RangeFormInput from '../../../../hoc/form/range-form-input';

class Price extends Component {

    render() {
        
        return (
            <RangeFormInput text='房間單價' type='number' id1='filter_priceMin' id2='filter_priceMax' min1={0} min2={0} />
        );
    }
}

export default Price;