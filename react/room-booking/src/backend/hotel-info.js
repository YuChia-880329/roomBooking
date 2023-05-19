import React, { Component } from 'react';
import { Container } from 'react-bootstrap';
import LocalForm from './hotel_info/local-form';

class HotelInfo extends Component {
    render() {
        return (
            <Container className='w-75'>
                <LocalForm />
            </Container>
        );
    }
}

export default HotelInfo;