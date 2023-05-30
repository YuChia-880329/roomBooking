import React, { Component, Fragment } from 'react';
import HotelInfo from './main/hotel-info';
import RoomList from './main/room-list';
import RoomCreate from './main/room-create';
import RoomUpdate from './main/room-update';
import BookingOrderList from './main/booking-order-list';
import { Navigate, Route, Routes } from 'react-router-dom';
import BackendNavbar from './main/backend-navbar';


class Main extends Component {

    render() {
        
        return (
            <Fragment>
                <div>
                    <BackendNavbar />
                </div>
                <Routes>
                    <Route path='/' element={<Navigate to='./hotelInfo' />} />
                    <Route path='/hotelInfo' element={<HotelInfo />} />
                    <Route path='/roomList' element={<RoomList />} />
                    <Route path='/roomUpdate' element={<RoomUpdate />} />
                    <Route path='/roomCreate' element={<RoomCreate />} />
                    <Route path='/orderList' element={<BookingOrderList />} />
                </Routes>
            </Fragment>
        );
    }
}

export default Main;