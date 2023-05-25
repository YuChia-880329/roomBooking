import React, { Component, createRef } from 'react';
import { Container, Stack } from 'react-bootstrap';
import TwoBtnModal from '../../../hoc/modal/two-btn-modal';
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

    filterModalRef = createRef();

    filterBtnClicked = () => {

        this.filterModalRef.current.handleShow();
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
                    <PayMethod />
                    <CheckinDate />
                    <CheckinTime />
                    <CheckoutDate />
                    <UseDay />
                    <TotalPrice />
                </Stack>
            </Container>
        );
    };


    
    render() {
        
        return (
            <TwoBtnModal ref={this.filterModalRef} title='篩選表單' BodyContent={this.FilterBodyContent} OkBtnText='篩選' />
        );
    }


 
}

export default FilterModal;