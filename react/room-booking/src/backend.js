import React, { Component } from 'react';
import LocalNavbar from './backend/local-navbar';
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
        const navbarStyle = {
            marginBottom : '5rem'
        };
        const titleStyle = {
            marginBottom : '4rem'
        };

        return (
            <div>
                <div style={navbarStyle}>
                    <LocalNavbar />
                </div>
                <Container>
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