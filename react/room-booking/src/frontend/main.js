import React, { Component, Fragment } from 'react';
import FrontendNavbar from './main/frontend-navbar';
import Home from './main/home';
import HotelPage from './main/hotel-page';
import ShoppingCart from './main/shopping-cart';
import Receipt from './main/receipt';

class Main extends Component {

    render() {
        
        const fctn = {
            home : {
                showInformModal : this.props.fctn.showInformModal,
                closeInformModal : this.props.fctn.closeInformModal
            }
        };

        return (
            <Fragment>
                <FrontendNavbar />
                <Home fctn={fctn.home} />
                {/* <HotelPage /> */}
                {/* <ShoppingCart /> */}
                {/* <Receipt /> */}
            </Fragment>
        );
    }
}

export default Main;