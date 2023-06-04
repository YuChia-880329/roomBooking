import urls from '../../../files/urls.json';
import config from '../../../files/config.json';
import React, { Component } from 'react';
import { Button, Container, Form, Modal, Stack } from 'react-bootstrap';
import Id from './filter_modal/id';
import ClientName from './filter_modal/client-name';
import Phone from './filter_modal/phone';
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
    },
    filterModal : {
        colName : {
            idMin : 'idMin',
            idMax : 'idMax',
            clientName : 'clientName',
            clientPhone : 'clientPhone',
            roomType : 'roomType',
            roomNumMin : 'roomNumMin',
            roomNumMax : 'roomNumMax',
            priceMin : 'priceMin',
            priceMax : 'priceMax',
            payMethod : 'payMethod',
            checkinDateTimeFrom : 'checkinDateTimeFrom',
            checkinDateTimeTo : 'checkinDateTimeTo',
            checkoutDateFrom : 'checkoutDateFrom',
            checkoutDateTo : 'checkoutDateTo',
            useDayMin : 'useDayMin',
            useDayMax : 'useDayMax',
            totalPriceMin : 'totalPriceMin',
            totalPriceMax : 'totalPriceMax'
        }
    }
};
class FilterModal extends Component {

    constructor(props){

        super(props);
        this.state = {
            payMethod : {
                allPayMethods : []
            },
            roomType : {
                allRooms : []
            }
        };
    }

    componentDidMount(){

        this.allPayMethods(() => {

            this.allRooms();
        });
    }

    render() {
        
        const {filterModal} = constant;
        const {show, onHide} = this.props;
        const fctn = {
            payMethod : {
                getAllPayMethods : this.getAllPayMethods
            },
            roomType : {
                getAllRooms : this.getAllRooms
            }
        }

        return (
            <Modal show={show} onHide={onHide} centered>
                <Modal.Header closeButton>
                    <Modal.Title>
                        <h3 className='mb-0'>篩選表單</h3>
                    </Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    <Container as={Form} className='my-3'>
                        <Stack gap={4}>
                            <Id valueMin={this.getValue(filterModal.colName.idMin)} 
                                    valueMax={this.getValue(filterModal.colName.idMax)} 
                                    onChangeMin={(e) => this.ctrlOnChange(filterModal.colName.idMin, e)} 
                                    onChangeMax={(e) => this.ctrlOnChange(filterModal.colName.idMax, e)} />
                            <ClientName value={this.getValue(filterModal.colName.clientName)} 
                                    onChange={(e) => this.ctrlOnChange(filterModal.colName.clientName, e)} />
                            <Phone value={this.getValue(filterModal.colName.clientPhone)} 
                                    onChange={(e) => this.ctrlOnChange(filterModal.colName.clientPhone, e)} />
                            <RoomType value={this.getValue(filterModal.colName.roomType)} 
                                    onChange={(e) => this.ctrlOnChange(filterModal.colName.roomType, e)}
                                    fctn={fctn.roomType} />
                            <RoomNum valueMin={this.getValue(filterModal.colName.roomNumMin)} 
                                    valueMax={this.getValue(filterModal.colName.roomNumMax)} 
                                    onChangeMin={(e) => this.ctrlOnChange(filterModal.colName.roomNumMin, e)} 
                                    onChangeMax={(e) => this.ctrlOnChange(filterModal.colName.roomNumMax, e)} />
                            <Price valueMin={this.getValue(filterModal.colName.priceMin)} 
                                    valueMax={this.getValue(filterModal.colName.priceMax)} 
                                    onChangeMin={(e) => this.ctrlOnChange(filterModal.colName.priceMin, e)} 
                                    onChangeMax={(e) => this.ctrlOnChange(filterModal.colName.priceMax, e)} />
                            <PayMethod values={this.getValue(filterModal.colName.payMethod)} 
                                    onChange={(e) => this.ctrlCheckOnChange(filterModal.colName.payMethod, e)} 
                                    fctn={fctn.payMethod} />
                            <CheckinDateTime valueFrom={this.getValue(filterModal.colName.checkinDateTimeFrom)} 
                                    valueTo={this.getValue(filterModal.colName.checkinDateTimeTo)} 
                                    onChangeFrom={(e) => this.ctrlOnChange(filterModal.colName.checkinDateTimeFrom, e)} 
                                    onChangeTo={(e) => this.ctrlOnChange(filterModal.colName.checkinDateTimeTo, e)} />
                            <CheckoutDate valueFrom={this.getValue(filterModal.colName.checkoutDateFrom)} 
                                    valueTo={this.getValue(filterModal.colName.checkoutDateTo)} 
                                    onChangeFrom={(e) => this.ctrlOnChange(filterModal.colName.checkoutDateFrom, e)} 
                                    onChangeTo={(e) => this.ctrlOnChange(filterModal.colName.checkoutDateTo, e)} />
                            <UseDay valueMin={this.getValue(filterModal.colName.useDayMin)} 
                                    valueMax={this.getValue(filterModal.colName.useDayMax)} 
                                    onChangeMin={(e) => this.ctrlOnChange(filterModal.colName.useDayMin, e)} 
                                    onChangeMax={(e) => this.ctrlOnChange(filterModal.colName.useDayMax, e)} />
                            <TotalPrice valueMin={this.getValue(filterModal.colName.totalPriceMin)} 
                                    valueMax={this.getValue(filterModal.colName.totalPriceMax)} 
                                    onChangeMin={(e) => this.ctrlOnChange(filterModal.colName.totalPriceMin, e)} 
                                    onChangeMax={(e) => this.ctrlOnChange(filterModal.colName.totalPriceMax, e)} />
                        </Stack>
                    </Container>
                </Modal.Body>
                <Modal.Footer>
                    <Button variant="secondary" onClick={() => onHide()}>關閉</Button>
                    <Button variant="primary" onClick={this.okBtnOnClick}>篩選</Button>
                </Modal.Footer>
            </Modal>
        );
    }

    // other
    allPayMethods = (onSuccess) => {

        this.allPayMethodsFetch(onSuccess);
    };
    allRooms = (onSuccess) => {

        this.allRoomsFetch(onSuccess);
    };


    // on
    ctrlOnChange = (colName, event) => {

        const {fctn} = this.props;

        fctn.setFilterModalVal(colName, event.target.value);
    }
    ctrlCheckOnChange = (colName, event) => {

        const {fctn} = this.props;
        const checks = fctn.getFilterModalVal(colName);
        let newChecks = [];

        if(event.target.checked === true)
            newChecks = [...checks, event.target.value];
        else
            newChecks = checks.filter(element => element!==event.target.value);

        fctn.setFilterModalVal(colName, newChecks);
    };
    okBtnOnClick = () => {

        const {fctn} = this.props;
        const {onHide} = this.props;

        fctn.searchTable();
        onHide();
    }


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
    allRoomsFetch = async (onSuccess) => {

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

            this.afterAllRooms(data, onSuccess);
        }else if(statusCode===400 || statusCode===500){

            fctn.showInformModal(serverInfo.msg);
        }
    };


    // after fetch
    afterAllPayMethods = (data, onSuccess) => {

        const {payMethod} = this.state;
        this.setState({
            payMethod : {
                ...payMethod,
                allPayMethods : data.payMethods
            }
        }, () => {

            onSuccess && onSuccess();
        });
    };
    afterAllRooms = (data, onSuccess) => {

        const {roomType} = this.state;
        this.setState({
            roomType : {
                ...roomType,
                allRooms : data.rooms
            }
        }, () => {

            onSuccess && onSuccess();
        });
    };


    // getter setter
    getValue = (colName) => {

        const {fctn} = this.props;

        return fctn.getFilterModalVal(colName);
    }
    getAllPayMethods = () => {

        const {payMethod} = this.state;
        return payMethod.allPayMethods;
    };
    getAllRooms = () => {

        const {roomType} = this.state;
        return roomType.allRooms;
    };
 
}

export default FilterModal;