import React, { Component } from 'react';
import { Button, Container, Form, Modal, Stack } from 'react-bootstrap';
import Id from './filter_modal/id';
import ClientName from './filter_modal/client-name';
import Phone from './filter_modal/phone';
import RoomType from './filter_modal/room-type';
import RoomNum from './filter_modal/room-num';
import Price from './filter_modal/price';
import TotalPrice from './filter_modal/total-price';
import CheckinDate from './filter_modal/checkin-date';
import CheckoutDate from './filter_modal/checkout-date';
import PayMethod from './filter_modal/payMethod';
import CheckinTime from './filter_modal/checkin-time';
import UseDay from './filter_modal/use-day';

class FilterModal extends Component {

    render() {
        
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
                            <Id />
                            <ClientName />
                            <Phone />
                            <RoomType />
                            <RoomNum />
                            <Price />
                            <PayMethod />
                            <CheckinDate />
                            <CheckinTime />
                            <CheckoutDate />
                            <UseDay />
                            <TotalPrice />
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


 
}

export default FilterModal;