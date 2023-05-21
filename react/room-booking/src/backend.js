import React, { Component } from 'react';
import { Container } from 'react-bootstrap';
import BackendNavbar from './backend/backend-navbar';
import HotelInfo from './backend/hotel-info';
import RoomList from './backend/room-list';
import RoomUpdate from './backend/room-update';
import RoomCreate from './backend/room-create';
import OrderList from './backend/order-list';


class Backend extends Component {

    state = {
        titleText : '訂房訂單'
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
                    <div className='border-bottom border-2 text-secondary pb-3' style={titleStyle}>
                        <h2>{titleText}</h2>
                    </div>
                    {/* <HotelInfo /> */}
                    {/* <RoomList /> */}
                    {/* <RoomUpdate /> */}
                    {/* <RoomCreate /> */}
                    <OrderList />
                </Container>
            </div>
        );
    }
}

export default Backend;