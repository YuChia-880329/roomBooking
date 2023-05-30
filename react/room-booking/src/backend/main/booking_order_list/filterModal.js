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


const constant = {
    filterModal : {
        colName : {
            idMin : 'idMin',
            idMax : 'idMax',
            clientName : 'clientName',
            clientPhone : 'clientPhone',
            roomName : 'roomName',
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

    render() {
        
        const {filterModal} = constant;
        const {show, onHide} = this.props;

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
                            <ClientName value={this.getValue(filterModal.colName.clientName)} onChange={(e) => this.ctrlOnChange(filterModal.colName.clientName, e)} />
                            <Phone value={this.getValue(filterModal.colName.clientPhone)} onChange={(e) => this.ctrlOnChange(filterModal.colName.clientPhone, e)} />
                            <RoomType />
                            <RoomNum valueMin={this.getValue(filterModal.colName.roomNumMin)} 
                                    valueMax={this.getValue(filterModal.colName.roomNumMax)} 
                                    onChangeMin={(e) => this.ctrlOnChange(filterModal.colName.roomNumMin, e)} 
                                    onChangeMax={(e) => this.ctrlOnChange(filterModal.colName.roomNumMax, e)} />
                            <Price valueMin={this.getValue(filterModal.colName.priceMin)} 
                                    valueMax={this.getValue(filterModal.colName.priceMax)} 
                                    onChangeMin={(e) => this.ctrlOnChange(filterModal.colName.priceMin, e)} 
                                    onChangeMax={(e) => this.ctrlOnChange(filterModal.colName.priceMax, e)} />
                            <PayMethod />
                            <CheckinDateTime />
                            <CheckoutDate />
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

    // on
    ctrlOnChange = (colName, event) => {

        const {fctn} = this.props;

        fctn.setFilterModalVal(colName, event.target.value);
    }
    okBtnOnClick = () => {

        const {fctn} = this.props;
        const {onHide} = this.props;

        fctn.tableUpdate();
        onHide();
    }


    // getter setter
    getValue = (colName) => {

        const {fctn} = this.props;

        return fctn.getFilterModalVal(colName);
    }
 
}

export default FilterModal;