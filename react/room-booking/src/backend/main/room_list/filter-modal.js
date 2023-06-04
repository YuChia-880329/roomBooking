import React, { Component } from 'react';
import { Button, Container, Form, Modal, Stack } from 'react-bootstrap';
import Name from './filter_modal/name';
import TotalRoomNum from './filter_modal/total-room-num';
import InvalidRoomNum from './filter_modal/invalid-room-num';
import Price from './filter_modal/price';
import UsedRoomNum from './filter_modal/used-room-num';

const constant = {
    filterModal : {
        colName : {
            name : 'name',
            totalRoomNumMin : 'totalRoomNumMin',
            totalRoomNumMax : 'totalRoomNumMax',
            usedRoomNumMin : 'usedRoomNumMin',
            usedRoomNumMax : 'usedRoomNumMax',
            invalidRoomNumMin : 'invalidRoomNumMin',
            invalidRoomNumMax : 'invalidRoomNumMax',
            priceMin : 'priceMin',
            priceMax : 'priceMax'
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
                            <Name value={this.getValue(filterModal.colName.name)} onChange={(e) => this.ctrlOnChange(filterModal.colName.name, e)} />
                            <TotalRoomNum valueMin={this.getValue(filterModal.colName.totalRoomNumMin)} 
                                    valueMax={this.getValue(filterModal.colName.totalRoomNumMax)} 
                                    onChangeMin={(e) => this.ctrlOnChange(filterModal.colName.totalRoomNumMin, e)} 
                                    onChangeMax={(e) => this.ctrlOnChange(filterModal.colName.totalRoomNumMax, e)} />
                            <UsedRoomNum valueMin={this.getValue(filterModal.colName.usedRoomNumMin)} 
                                    valueMax={this.getValue(filterModal.colName.usedRoomNumMax)} 
                                    onChangeMin={(e) => this.ctrlOnChange(filterModal.colName.usedRoomNumMin, e)} 
                                    onChangeMax={(e) => this.ctrlOnChange(filterModal.colName.usedRoomNumMax, e)} />
                            <InvalidRoomNum valueMin={this.getValue(filterModal.colName.invalidRoomNumMin)} 
                                    valueMax={this.getValue(filterModal.colName.invalidRoomNumMax)} 
                                    onChangeMin={(e) => this.ctrlOnChange(filterModal.colName.invalidRoomNumMin, e)} 
                                    onChangeMax={(e) => this.ctrlOnChange(filterModal.colName.invalidRoomNumMax, e)} />
                            <Price valueMin={this.getValue(filterModal.colName.priceMin)} 
                                    valueMax={this.getValue(filterModal.colName.priceMax)} 
                                    onChangeMin={(e) => this.ctrlOnChange(filterModal.colName.priceMin, e)} 
                                    onChangeMax={(e) => this.ctrlOnChange(filterModal.colName.priceMax, e)} />
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

        fctn.searchTable();
        onHide();
    }


    // getter setter
    getValue = (colName) => {

        const {fctn} = this.props;

        return fctn.getFilterModalVal(colName);
    }
}

export default FilterModal;