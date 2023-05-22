import React, { Component } from 'react';
import SimpleFormInput from '../../../hoc/form/simple-form-input';
    
class Price extends Component {

    render() {
        
        return (
            <SimpleFormInput id='form_price' text='房間單價' type='number' min={0} />
        );
    }
}

export default Price;