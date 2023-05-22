import React, { Component } from 'react';
import SimpleFormInput from '../../../hoc/form/simple-form-input';

class DoubleBedNum extends Component {

    render() {
        return (
            <SimpleFormInput id='doubleBed' text='雙人床數' type='number' min={0} />
        );
    }
}

export default DoubleBedNum;