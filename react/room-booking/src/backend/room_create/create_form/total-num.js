import React, { Component } from 'react';
import SimpleFormInput from '../../../hoc/form/simple-form-input';

class TotalNum extends Component {

    render() {
        return (
            <SimpleFormInput id='totalNumber' text='總房數' type='number' min={1} />
        );
    }
}

export default TotalNum;