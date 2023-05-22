import React, { Component, createRef } from 'react';
import { Button, Container, Stack } from 'react-bootstrap';
import TwoBtnModal from '../../hoc/modal/two-btn-modal';
import Type from './filter_modal/type';
import TotalRoomNum from './filter_modal/total-room-num';
import ValidRoomNum from './filter_modal/valid-room-num';
import InvalidRoomNum from './filter_modal/invalid-room-num';
import Price from './filter_modal/price';

class FilterModal extends Component {

    filterModal = createRef();

    filterBtnClicked = () => {
        this.filterModal.current.handleShow();
    }
    filterBodyContent = () => {
        return (
            <Container className='my-3'>
                <Stack gap={4}>
                    <Type />
                    <TotalRoomNum />
                    <ValidRoomNum />
                    <InvalidRoomNum />
                    <Price />
                </Stack>
            </Container>
        );
    };
    okBtn = () => {
        return (
            <Button variant='primary'>篩選</Button>
        );
    };
    render() {
        return (
            <TwoBtnModal ref={this.filterModal} title='篩選表單' BodyContent={this.filterBodyContent} OkBtn={this.okBtn} />
        );
    }
}

export default FilterModal;