import '../../css/custom.css'
import React, { Component } from 'react';
import { Button, Container, Modal } from 'react-bootstrap';

class InformModal extends Component {

    render() {

        const {msg, show, onHide} = this.props;
        const msgPStyle = {
            wordWrap: 'break-word'
        };

        return (
            <Modal show={show} onHide={onHide} className='inform-modal'>
                <Modal.Header closeButton>
                    <Modal.Title>
                        <h3 className='mb-0'>訊息</h3>
                    </Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    <Container className='px-4'>
                        <p className='fs-5' style={msgPStyle}>{msg}</p>
                    </Container>
                </Modal.Body>
                <Modal.Footer>
                    <Button variant="primary" onClick={onHide}>確認</Button>
                </Modal.Footer>
            </Modal>
        );
    }
}

export default InformModal;