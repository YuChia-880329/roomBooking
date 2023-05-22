import React, { Component } from 'react';
import BackendNavbar from './backend/backend-navbar';
import HotelInfo from './backend/hotel-info';
import RoomList from './backend/room-list';
import RoomUpdate from './backend/room-update';
import RoomCreate from './backend/room-create';
import OrderList from './backend/order-list';
import { BrowserRouter, Route, Routes } from 'react-router-dom';


class Backend extends Component {

    render() {

        return (
            <BrowserRouter>
                <div>
                    <BackendNavbar />
                </div>
                <Routes>
                    <Route path='/' element={<HotelInfo />} />
                    <Route path='hotelInfo' element={<HotelInfo />} />
                    <Route path='roomList' element={<RoomList />} />
                    <Route path='roomUpdate' element={<RoomUpdate />} />
                    <Route path='roomCreate' element={<RoomCreate />} />
                    <Route path='orderList' element={<OrderList />} />
                </Routes>
            </BrowserRouter>
        );
    }
}

export default Backend;