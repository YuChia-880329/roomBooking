import React, { Component, createRef } from 'react';
import { Container, Stack } from 'react-bootstrap';
import TwoBtnModal from '../../../hoc/modal/two-btn-modal';
import Type from './filter_modal/type';
import TotalRoomNum from './filter_modal/total-room-num';
import InvalidRoomNum from './filter_modal/invalid-room-num';
import Price from './filter_modal/price';
import UsedRoomNum from './filter_modal/used-room-num';

class FilterModal extends Component {

    filterModalRef = createRef();

    filterBtnClicked = () => {

        this.filterModalRef.current.handleShow();
    }
 
    FilterBodyContent = () => {

        return (
            <Container className='my-3'>
                <Stack gap={4}>
                    <Type />
                    <TotalRoomNum />
                    <UsedRoomNum />
                    <InvalidRoomNum />
                    <Price />
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