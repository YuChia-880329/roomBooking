import urls from '../../../files/urls.json';
import config from '../../../files/config.json';
import React, { Component } from 'react';
import { Button, Container, Form, Modal, Stack } from 'react-bootstrap';
import Id from './filter_modal/id';
import ClientName from './filter_modal/client-name';
import ClientPhone from './filter_modal/client-phone';
import RoomType from './filter_modal/room-type';
import RoomNum from './filter_modal/room-num';
import Price from './filter_modal/price';
import TotalPrice from './filter_modal/total-price';
import CheckinDateTime from './filter_modal/checkin-date-time';
import CheckoutDate from './filter_modal/checkout-date';
import PayMethod from './filter_modal/payMethod';
import UseDay from './filter_modal/use-day';
import axios from 'axios';


const constant = {
    fetch : {
        url : {
            allPayMethods : urls.backend.bookingOrderList.allPayMethods,
            allRooms : urls.backend.bookingOrderList.allRooms
        },
        config : {
            timeout : config.fetch.timeout
        }
    }
};
class FilterModal extends Component {


    componentDidMount(){

        this.allPayMethods(() => {

            this.allRooms();
        });
    }

    render() {
        
        const {value} = this.props;

        const setter = {
            id : {
                setId : (val, onSet) => this.setter('id', val, onSet)
            },
            clientName : {
                setClientName : (val, onSet) => this.setter('clientName', val, onSet)
            },
            clientPhone : {
                setClientPhone : (val, onSet) => this.setter('clientPhone', val, onSet)
            },
            roomType : {
                setRoomType : (val, onSet) => this.setter('roomType', val, onSet)
            },
            roomNum : {
                setRoomNum : (val, onSet) => this.setter('roomNum', val, onSet)
            },
            price : {
                setPrice : (val, onSet) => this.setter('price', val, onSet)
            },
            payMethod : {
                setPayMethod : (val, onSet) => this.setter('payMethod', val, onSet)
            },
            checkinDateTime : {
                setCheckinDateTime : (val, onSet) => this.setter('checkinDateTime', val, onSet)
            },
            checkoutDate : {
                setCheckoutDate : (val, onSet) => this.setter('checkoutDate', val, onSet)
            },
            useDay : {
                setUseDay : (val, onSet) => this.setter('useDay', val, onSet)
            },
            totalPrice : {
                setTotalPrice : (val, onSet) => this.setter('totalPrice', val, onSet)
            }
        };

        return (
            <Modal show={value.show} onHide={this.onHide} centered>
                <Modal.Header closeButton>
                    <Modal.Title>
                        <h3 className='mb-0'>篩選表單</h3>
                    </Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    <Container as={Form} className='my-3'>
                        <Stack gap={4}>
                            <Id value={value.id} setter={setter.id} />
                            <ClientName value={value.clientName} setter={setter.clientName} />
                            <ClientPhone value={value.clientPhone} setter={setter.clientPhone} />
                            <RoomType value={value.roomType} setter={setter.roomType} />
                            <RoomNum value={value.roomNum} setter={setter.roomNum} />
                            <Price value={value.price} setter={setter.price} />
                            <PayMethod value={value.payMethod} setter={setter.payMethod} />
                            <CheckinDateTime value={value.checkinDateTime} setter={setter.checkinDateTime} />
                            <CheckoutDate value={value.checkoutDate} setter={setter.checkoutDate} />
                            <UseDay value={value.useDay} setter={setter.useDay} />
                            <TotalPrice value={value.totalPrice} setter={setter.totalPrice} />
                        </Stack>
                    </Container>
                </Modal.Body>
                <Modal.Footer>
                    <Button variant="secondary" onClick={e => this.onHide()}>關閉</Button>
                    <Button variant="primary" onClick={this.onClickOkBtn}>篩選</Button>
                </Modal.Footer>
            </Modal>
        );
    }


    // on
    onHide = (event) => {

        this.setter('show', false);
    };
    onClickOkBtn = (event) => {

        const {fctn} = this.props;

        fctn.searchTable();
        this.onHide();
    }


    // other
    allPayMethods = (onSuccess) => {

        this.allPayMethodsFetch(onSuccess);
    };
    allRooms = () => {

        this.allRoomsFetch();
    };


    // fetch
    allPayMethodsFetch = async (onSuccess) => {

        const {fctn} = this.props;
        const {fetch} =  constant;
        const url = fetch.url.allPayMethods;
        const config = fetch.config;

        const {serverInfo, data} = await axios.get(url, {
                timeout : config.timeout
            })
            .then(rs => rs.data)
            .catch(error => console.error(error));

        const statusCode = serverInfo.statusCode;
        if(statusCode === 200){

            this.afterAllPayMethods(data, onSuccess);
        }else if(statusCode===400 || statusCode===500){

            fctn.showInformModal(serverInfo.msg);
        }
    };
    allRoomsFetch = async () => {

        const {fctn} = this.props;
        const {fetch} =  constant;
        const url = fetch.url.allRooms;
        const config = fetch.config;

        const {serverInfo, data} = await axios.get(url, {
                timeout : config.timeout,
                withCredentials: true
            })
            .then(rs => rs.data)
            .catch(error => console.error(error));

        const statusCode = serverInfo.statusCode;
        if(statusCode === 200){

            this.afterAllRooms(data);
        }else if(statusCode===400 || statusCode===500){

            fctn.showInformModal(serverInfo.msg);
        }
    };


    // after fetch
    afterAllPayMethods = (data, onSuccess) => {

        const {value} = this.props;

        this.setter('payMethod', {
            ...value.payMethod,
            options : data.payMethods
        }, () => {

            onSuccess && onSuccess();
        });
    };
    afterAllRooms = (data) => {

        const {value} = this.props;

        this.setter('roomType', {
            ...value.roomType,
            options : data.rooms
        });
    };


    // getter setter
    setter = (colName, colVal, onSet) => {

        const {setter, value} = this.props;
        setter.setFilterModal({
            ...value,
            [colName] : colVal
        }, onSet);
    };
}

export default FilterModal;