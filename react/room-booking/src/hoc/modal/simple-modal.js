import React, { Component } from 'react';
import { Modal } from 'react-bootstrap';

class SimpleModal extends Component {

    state = {
        show : false
    }

    handleShow = () =>{
        this.setState({
            show : true
        });
    }
    handleClose = () => {
        this.setState({
            show : false
        });
    };
    render() {

        // state
        const {show} = this.state;

        // props
        const {title, BodyContent, FooterContent} = this.props;

        return (
            <Modal show={show} onHide={this.handleClose}>
                <Modal.Header closeButton>
                    <Modal.Title>{title}</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    <BodyContent />
                </Modal.Body>
                <Modal.Footer>
                    <FooterContent />
                </Modal.Footer>
            </Modal>
        );
    }
}

export default SimpleModal;