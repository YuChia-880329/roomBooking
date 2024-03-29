import urls from '../files/urls.json';
import config from '../files/config.json';
import React, { Component, Fragment, createRef } from 'react';
import HotelInfo from './main/hotel-info';
import RoomList from './main/room-list';
import RoomCreate from './main/room-create';
import RoomUpdate from './main/room-update';
import BookingOrderList from './main/booking-order-list';
import { Navigate, Route, Routes, useNavigate } from 'react-router-dom';
import BackendNavbar from './main/backend-navbar';
import axios from 'axios';


const constant = {
    fetch : {
        url : {
            checkLogin : urls.backend.checkLogin
        },
        config : {
            timeout : config.fetch.timeout
        }
    }
}
class MainWrapped extends Component {

    backendNavbarRef = createRef();

    render() {

        const refs = {
            backendNavbar : {
                backendNavbarRef : this.backendNavbarRef
            }
        }
        const fctn = {
            backendNavbar : {
                showInformModal : this.props.fctn.showInformModal,
                closeInformModal : this.props.fctn.closeInformModal,
                showConfirmModal : this.props.fctn.showConfirmModal,
                closeConfirmModal : this.props.fctn.closeConfirmModal,
                checkLogin : this.checkLogin
            },
            hotelInfo : {
                showInformModal : this.props.fctn.showInformModal,
                closeInformModal : this.props.fctn.closeInformModal,
                showConfirmModal : this.props.fctn.showConfirmModal,
                closeConfirmModal : this.props.fctn.closeConfirmModal,
                checkLogin : this.checkLogin,
                setNavBarHotelName : name => this.backendNavbarRef.current.setter('hotelName', name)
            },
            roomList : {
                showInformModal : this.props.fctn.showInformModal,
                closeInformModal : this.props.fctn.closeInformModal,
                checkLogin : this.checkLogin
            },
            roomUpdate : {
                showInformModal : this.props.fctn.showInformModal,
                closeInformModal : this.props.fctn.closeInformModal,
                showConfirmModal : this.props.fctn.showConfirmModal,
                closeConfirmModal : this.props.fctn.closeConfirmModal,
                checkLogin : this.checkLogin
            },
            roomCreate : {
                showInformModal : this.props.fctn.showInformModal,
                closeInformModal : this.props.fctn.closeInformModal,
                showConfirmModal : this.props.fctn.showConfirmModal,
                closeConfirmModal : this.props.fctn.closeConfirmModal,
                checkLogin : this.checkLogin
            },
            bookingOrderList : {
                showInformModal : this.props.fctn.showInformModal,
                closeInformModal : this.props.fctn.closeInformModal,
                checkLogin : this.checkLogin
            }
        };
        
        return (
            <Fragment>
                <BackendNavbar fctn={fctn.backendNavbar} refs={refs.backendNavbar} />
                <Routes>
                    <Route path='/' element={<Navigate to='./hotelInfo' />} />
                    <Route path='/hotelInfo' element={<HotelInfo fctn={fctn.hotelInfo} />} />
                    <Route path='/roomList' element={<RoomList fctn={fctn.roomList} />} />
                    <Route path='/roomUpdate' element={<RoomUpdate fctn={fctn.roomUpdate} />} />
                    <Route path='/roomCreate' element={<RoomCreate fctn={fctn.roomCreate} />} />
                    <Route path='/bookingOrderList' element={<BookingOrderList fctn={fctn.bookingOrderList} />} />
                </Routes>
            </Fragment>
        );
    }


    // other
    checkLogin = (onSuccess) => {

        this.checkLoginFetch(onSuccess);
    }


    // fetch
    checkLoginFetch = async (onSuccess) => {

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

            this.afterCheckLogin(data, onSuccess);
        }else if(statusCode===400 || statusCode===500){

            fctn.showInformModal(serverInfo.msg);
        }
    };


    // after fetch
    afterCheckLogin = (data, onSuccess) => {

        const {fctn, navigate} = this.props;
        const {result} = data;

        if(!result.login){

            fctn.showInformModal(result.msg, () => {

                fctn.closeInformModal();
                navigate('/roomBooking/backend/login');
            });
        }else{

            onSuccess && onSuccess();
        }
    }
}

const Main = props => {

    const navigate = useNavigate();
    return (<MainWrapped {...props} navigate={navigate} />);
};

export default Main;