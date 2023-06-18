import urls from '../files/urls.json';
import config from '../files/config.json';
import React, { Component, Fragment } from 'react';
import FrontendNavbar from './main/frontend-navbar';
import Home from './main/home';
import HotelPage from './main/hotel-page';
import ShoppingCart from './main/shopping-cart';
import Receipt from './main/receipt';
import { Navigate, Route, Routes, useNavigate } from 'react-router-dom';
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

class MainWrapped extends Component {
    
    render() {
        
        const fctn = {
            home : {
                showInformModal : this.props.fctn.showInformModal,
                closeInformModal : this.props.fctn.closeInformModal
            },
            hotelPage : {
                showInformModal : this.props.fctn.showInformModal,
                closeInformModal : this.props.fctn.closeInformModal,
                showConfirmModal : this.props.fctn.showConfirmModal,
                closeConfirmModal : this.props.fctn.closeConfirmModal,
                checkLogin : this.checkLogin
            },
            shoppingCart : {
                showInformModal : this.props.fctn.showInformModal,
                closeInformModal : this.props.fctn.closeInformModal,
                showConfirmModal : this.props.fctn.showConfirmModal,
                closeConfirmModal : this.props.fctn.closeConfirmModal,
                checkLogin : this.checkLogin
            },
            receipt : {
                showInformModal : this.props.fctn.showInformModal,
                closeInformModal : this.props.fctn.closeInformModal,
                checkLogin : this.checkLogin
            },
            frontendNavbar : {
                showInformModal : this.props.fctn.showInformModal,
                closeInformModal : this.props.fctn.closeInformModal,
                showConfirmModal : this.props.fctn.showConfirmModal,
                closeConfirmModal : this.props.fctn.closeConfirmModal,
                checkLogin : this.checkLoginOnFail
            }
        };

        return (
            <Fragment>
                <FrontendNavbar fctn={fctn.frontendNavbar} />
                <Routes>
                    <Route path='/' element={<Navigate to='./home' />} />
                    <Route path='/home' element={<Home fctn={fctn.home} />} />
                    <Route path='/hotelPage/:hotelId' element={<HotelPage fctn={fctn.hotelPage} />} />
                    <Route path='/shoppingCart' element={<ShoppingCart fctn={fctn.shoppingCart} />} />
                    <Route path='/receipt' element={<Receipt fctn={fctn.receipt} />} />
                </Routes>
            </Fragment>
        );
    }



     // other
    checkLoginOnFail = (onFail, onSuccess) => {

        this.checkLoginFetch(onFail, onSuccess);
    };
    checkLogin = (onSuccess) => {

        const {fctn, navigate} = this.props;

        this.checkLoginOnFail((failMsg) => {

            fctn.showInformModal(failMsg, () => {

                fctn.closeInformModal();
                navigate('/roomBooking/home');
            });
        }, onSuccess);
    };



    // fetch
    checkLoginFetch = async (onFail, onSuccess) => {

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

            this.afterCheckLogin(data, onFail, onSuccess);
        }else if(statusCode===400 || statusCode===500){

            fctn.showInformModal(serverInfo.msg);
        }
    };


    // after fetch
    afterCheckLogin = (data, onFail, onSuccess) => {

        if(!data.login){

            onFail(data.msg);
        }else{

            onSuccess && onSuccess();
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

const Main = props => {

    const navigate = useNavigate();

    return (<MainWrapped {...props} navigate={navigate} />);
};

export default Main;