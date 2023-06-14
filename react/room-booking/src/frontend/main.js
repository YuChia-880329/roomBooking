import React, { Component, Fragment } from 'react';
import FrontendNavbar from './main/frontend-navbar';
import Home from './main/home';
import HotelPage from './main/hotel-page';
import ShoppingCart from './main/shopping-cart';
import Receipt from './main/receipt';
import { Navigate, Route, Routes } from 'react-router-dom';

class Main extends Component {
    
    render() {
        
        const fctn = {
            home : {
                showInformModal : this.props.fctn.showInformModal,
                closeInformModal : this.props.fctn.closeInformModal
            },
            hotelPage : {
                showInformModal : this.props.fctn.showInformModal,
                closeInformModal : this.props.fctn.closeInformModal
            }
        };

        return (
            <Fragment>
                <FrontendNavbar />
                <Routes>
                    <Route path='/' element={<Navigate to='./home' />} />
                    <Route path='/home' element={<Home fctn={fctn.home} />} />
                    <Route path='/hotelPage/:hotelId' element={<HotelPage fctn={fctn.hotelPage} />} />
                    <Route path='/shoppingCart' element={<ShoppingCart />} />
                    <Route path='/receipt' element={<Receipt />} />
                </Routes>
            </Fragment>
        );
    }


    // setter getter
    setter = (colName, colVal, onSet) => {

        this.setState({
            [colName] : colVal
        }, () => {

            onSet && onSet();
        });
    };
    getter = (colName) => {

        return this.state[colName];
    };
}

export default Main;