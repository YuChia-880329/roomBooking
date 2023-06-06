import React, { Component } from 'react';
import { Button, Container, Modal, Stack } from 'react-bootstrap';
import Name from './filter_modal/name';
import TotalRoomNum from './filter_modal/total-room-num';
import InvalidRoomNum from './filter_modal/invalid-room-num';
import Price from './filter_modal/price';
import UsedRoomNum from './filter_modal/used-room-num';
import Status from './filter_modal/status';

class FilterModal extends Component {

    render() {

        const {value} = this.props;
        const setter = {
            name : {
                setName : (val, onSet) => this.setter('name', val, onSet)
            },
            totalRoomNum : {
                setTotalRoomNum : (val, onSet) => this.setter('totalRoomNum', val, onSet)
            },
            usedRoomNum : {
                setUsedRoomNum : (val, onSet) => this.setter('usedRoomNum', val, onSet)
            },
            invalidRoomNum : {
                setInvalidRoomNum : (val, onSet) => this.setter('invalidRoomNum', val, onSet)
            },
            price : {
                setPrice : (val, onSet) => this.setter('price', val, onSet)
            },
            status : {
                setStatus : (val, onSet) => this.setter('status', val, onSet)
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
                    <Container className='my-3'>
                        <Stack gap={4}>
                            <Name value={value.name} setter={setter.name} />
                            <TotalRoomNum value={value.totalRoomNum} setter={setter.totalRoomNum} />
                            <UsedRoomNum value={value.usedRoomNum} setter={setter.usedRoomNum} />
                            <InvalidRoomNum value={value.invalidRoomNum} setter={setter.invalidRoomNum} />
                            <Price value={value.price} setter={setter.price} />
                            <Status value={value.status} setter={setter.status} />
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


    // setter
    setter = (colName, colVal, onSet) => {

        const {setter, value} = this.props;
        setter.setFilterModal({
            ...value,
            [colName] : colVal
        }, onSet);
    };
}

export default FilterModal;