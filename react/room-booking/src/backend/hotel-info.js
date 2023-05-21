import React, { Component } from 'react';
import { Container } from 'react-bootstrap';
import BorderForm from '../hoc/form/border-form';
import InfoForm from './hotel_info/info-form';

class HotelInfo extends Component {
    render() {
        return (
            <Container className='w-75'>
                <BorderForm Content={InfoForm}/>
            </Container>
        );
    }
}

export default HotelInfo;