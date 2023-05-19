import React, { Component } from 'react';
import BackendNavbar from './backend/backend-navbar';
import HotelInfo from './backend/hotel-info';
import { Container } from 'react-bootstrap';

class Backend extends Component {

    state = {
        titleText : '飯店資料'
    };
    render() {

        // state
        const {titleText} = this.state;

        // style
        const containerStyle = {
            marginTop : '10rem'
        };
        const titleStyle = {
            marginBottom : '4rem'
        };

        return (
            <div>
                <div>
                    <BackendNavbar />
                </div>
                <Container className='mb-5' style={containerStyle}>
                    <div class='border-bottom border-2 text-secondary pb-3' style={titleStyle}>
                        <h2>{titleText}</h2>
                    </div>
                    <HotelInfo />
                </Container>
            </div>
        );
    }
}

export default Backend;