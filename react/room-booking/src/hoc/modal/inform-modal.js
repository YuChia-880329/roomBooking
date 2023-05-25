import React, { Component, createRef } from 'react';
import OneBtnModal from './one-btn-modal';
import { Container } from 'react-bootstrap';
import '../../css/custom.css'

class InformModal extends Component {

    oneBtnModalRef = createRef();


    handleShow = () => {

        this.oneBtnModalRef.current.handleShow();
    };
    handleClose = () => {

        this.oneBtnModalRef.current.handleClose();
    };


    BodyContent = () => {

        // style
        const msgPStyle = {
            wordWrap: 'break-word'
        };

        // props
        const {msg} = this.props;

        return (
            <Container>
                <p style={msgPStyle}>{msg}</p>
            </Container>
        );
    };
    render() {

        return (
            <OneBtnModal className='inform-modal' ref={this.oneBtnModalRef} title='訊息' BodyContent={this.BodyContent} OkBtnText='確認'  />
        );
    }
}

export default InformModal;