import React, { Component, Fragment, createRef } from 'react';
import { Button } from 'react-bootstrap';
import SimpleModal from './simple-modal';

class OneBtnModal extends Component {

    simpleModalRef = createRef();

    handleShow = () => {

        this.simpleModalRef.current.handleShow();
    };
    handleClose = () => {

        this.simpleModalRef.current.handleClose();
    };

    FooterContent = () => {

        // props
        const {OkBtnText} = this.props;

        return (
            <Fragment>
                <Button variant="primary" onClick={this.handleClose}>{OkBtnText}</Button>
            </Fragment>
        );
    }

    render() {

        // props
        const {title, BodyContent, className} = this.props;

        return (
            <SimpleModal className={className} ref={this.simpleModalRef} title={title} BodyContent={BodyContent} FooterContent={this.FooterContent}  />
        );
    }
}

export default OneBtnModal;