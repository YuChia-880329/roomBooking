import React, { Component, createRef } from 'react';
import { Button, Container } from 'react-bootstrap';
import TwoBtnModal from '../../hoc/modal/two-btn-modal';
import Id from './filter_modal/id';

class FilterModal extends Component {

    filterModal = createRef();

    filterBtnClicked = () => {
        this.filterModal.current.handleShow();
    }
    filterBodyContent = () => {
        return (
            <Container className='my-3'>
                <Id />
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