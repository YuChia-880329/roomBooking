import React, { Component, Fragment, createRef } from 'react';
import SimpleModal from './simple-modal';
import { Button } from 'react-bootstrap';

class TwoBtnModal extends Component {

    simpleModalRef = createRef();

    handleShow = () => {

        this.simpleModalRef.current.handleShow();
    };
    handleClose = () => {

        this.simpleModalRef.current.handleClose();
    };

    FooterContent = () => {

        // props
        const {OkBtnText, OkBtnOnClick} = this.props;

        return (
            <Fragment>
                <Button variant="secondary" onClick={this.handleClose}>關閉</Button>
                <Button variant="primary" onClick={OkBtnOnClick ? OkBtnOnClick : null}>{OkBtnText}</Button>
            </Fragment>
        );
    }
    render() {

        // props
        const {title, BodyContent} = this.props;

        return (
            <SimpleModal ref={this.simpleModalRef} title={title} BodyContent={BodyContent} FooterContent={this.FooterContent}  />
        );
    }
}

export default TwoBtnModal;