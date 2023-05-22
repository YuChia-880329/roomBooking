import React, { Component, Fragment, createRef } from 'react';
import SimpleModal from './simple-modal';
import { Button } from 'react-bootstrap';

class TwoBtnModal extends Component {

    simpleModal = createRef();

    handleShow = () => {

        this.simpleModal.current.handleShow();
    };
    handleClose = () => {

        this.simpleModal.current.handleClose();
    };

    FooterContent = () => {

        // props
        const {OkBtn} = this.props;

        return (
            <Fragment>
                <Button variant="secondary" onClick={this.handleClose}>關閉</Button>
                <OkBtn />
            </Fragment>
        );
    }
    render() {

        // props
        const {title, BodyContent} = this.props;

        return (
            <SimpleModal ref={this.simpleModal} title={title} BodyContent={BodyContent} FooterContent={this.FooterContent}  />
        );
    }
}

export default TwoBtnModal;