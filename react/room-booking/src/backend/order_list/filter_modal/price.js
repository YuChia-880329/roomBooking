import React, { Component } from 'react';
import RangeFormInput from '../../../hoc/form/range-form-input';

class Price extends Component {

    render() {
        
        return (
            <RangeFormInput type='number' text='房型單價' id1='filter_priceMin' id2='filter_priceMax' min1={0} min2={0} />
        );
    }
}

export default Price;