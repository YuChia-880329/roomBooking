import React, { Component, Fragment } from 'react';
import FrontendNavbar from './main/frontend-navbar';
import Home from './main/home';
import HotelPage from './main/hotel-page';
import ShoppingCart from './main/shopping-cart';

class Main extends Component {

    render() {
        
        return (
            <Fragment>
                <FrontendNavbar />
                {/* <Home /> */}
                {/* <HotelPage /> */}
                <ShoppingCart />
            </Fragment>
        );
    }
}

export default Main;