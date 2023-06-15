import urls from '../files/urls.json';
import config from '../files/config.json';
import React, { Component, Fragment } from 'react';
import FrontendNavbar from './main/frontend-navbar';
import Home from './main/home';
import HotelPage from './main/hotel-page';
import ShoppingCart from './main/shopping-cart';
import Receipt from './main/receipt';
import { Navigate, Route, Routes } from 'react-router-dom';
import axios from 'axios';


const constant = {
    fetch : {
        url : {
            checkLogin : urls.frontend.checkLogin
        },
        config : {
            timeout : config.fetch.timeout
        }
    }
}

class Main extends Component {
    
    render() {
        
        const fctn = {
            home : {
                showInformModal : this.props.fctn.showInformModal,
                closeInformModal : this.props.fctn.closeInformModal
            },
            hotelPage : {
                showInformModal : this.props.fctn.showInformModal,
                closeInformModal : this.props.fctn.closeInformModal,
                checkLogin : this.checkLogin
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



     // other
    checkLogin = () => {

        this.checkLoginFetch();
    };



    // fetch
    checkLoginFetch = async () => {

        const {fctn} = this.props;
        const {fetch} =  constant;
        const url = fetch.url.checkLogin;
        const config = fetch.config;

        const {serverInfo, data} = await axios.get(url, {
                timeout : config.timeout,
                withCredentials: true
            })
            .then(rs => rs.data)
            .catch(error => console.error(error));

        const statusCode = serverInfo.statusCode;
        if(statusCode === 200){

            this.afterCheckLogin(data);
        }else if(statusCode===400 || statusCode===500){

            fctn.showInformModal(serverInfo.msg);
        }
    };


    // after fetch
    afterCheckLogin = (data) => {

        const {fctn, navigate} = this.props;

        if(!data.login){

            fctn.showInformModal(data.msg, () => {

                navigate('../login');
            });
        }
    };



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