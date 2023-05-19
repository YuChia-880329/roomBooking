import React, { Component } from 'react';
import { Container } from 'react-bootstrap';
import LocalForm from './hotel_info/local-form';

class HotelInfo extends Component {
    render() {
        return (
            <div>
                <Container className='w-75'>
                    <LocalForm />
                </Container>
            </div>
        );
    }
}

export default HotelInfo;