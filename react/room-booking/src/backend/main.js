import React, { Component, Fragment } from 'react';
import BackendNavbar from './main/backend-navbar';
import { Route, Routes, Navigate } from 'react-router-dom';
import OrderList from './main/order-list';
import RoomCreate from './main/room-create';
import RoomUpdate from './main/room-update';
import RoomList from './main/room-list';
import HotelInfo from './main/hotel-info';

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
                    <Route path='/orderList' element={<OrderList />} />
                </Routes>
            </Fragment>
        );
    }
}

export default Main;