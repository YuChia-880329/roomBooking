import React, { Component } from 'react';
import SimpleFormInput from '../../../../hoc/form/simple-form-input';

class SingleBedNum extends Component {

    render() {
        
        return (
            <SimpleFormInput id='form_singleBed' text='單人床數' type='number' min={0} />
        );
    }
}

export default SingleBedNum;