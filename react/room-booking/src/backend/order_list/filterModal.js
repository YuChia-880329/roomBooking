import React, { Component, createRef } from 'react';
import { Button, Container, Stack } from 'react-bootstrap';
import TwoBtnModal from '../../hoc/modal/two-btn-modal';
import Id from './filter_modal/id';
import ClientName from './filter_modal/client-name';
import Phone from './filter_modal/phone';
import RoomType from './filter_modal/room-type';
import RoomNum from './filter_modal/room-num';
import Price from './filter_modal/price';
import TotalPrice from './filter_modal/total-price';
import CheckinDate from './filter_modal/checkin-date';
import CheckouDate from './filter_modal/checkout-date';

class FilterModal extends Component {

    filterModal = createRef();

    filterBtnClicked = () => {
        this.filterModal.current.handleShow();
    }

    render() {
        return (
            <TwoBtnModal ref={this.filterModal} title='篩選表單' BodyContent={this.FilterBodyContent} OkBtn={this.OkBtn} />
        );
    }


    FilterBodyContent = () => {
        return (
            <Container className='my-3'>
                <Stack gap={4}>
                    <Id />
                    <ClientName />
                    <Phone />
                    <RoomType />
                    <RoomNum />
                    <Price />
                    <TotalPrice />
                    <CheckinDate />
                    <CheckouDate />
                </Stack>
            </Container>
        );
    };
    OkBtn = () => {
        return (
            <Button variant='primary'>篩選</Button>
        );
    };
}

export default FilterModal;