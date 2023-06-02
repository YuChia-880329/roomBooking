import React, { Component } from 'react';

class ConfirmModal extends Component {
    
    render() {

        const {msg, show, onHide, onConfirm} = this.props;
        const msgPStyle = {
            wordWrap: 'break-word'
        };

        return (
            <Modal show={show} onHide={onHide} className='inform-modal'>
                <Modal.Header closeButton>
                    <Modal.Title>
                        <h3 className='mb-0'>確認</h3>
                    </Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    <Container className='px-4'>
                        <p className='fs-5' style={msgPStyle}>{msg}</p>
                    </Container>
                </Modal.Body>
                <Modal.Footer>
                    <Button variant="secondary" onClick={onHide}>取消</Button>
                    <Button variant="primary" onClick={onConfirm}>確認</Button>
                </Modal.Footer>
            </Modal>
        );
    }
}

export default ConfirmModal;