import React, { Component, Fragment } from 'react';
import InformModal from './hoc/modal/inform-modal';
import ConfirmModal from './hoc/modal/confirm-modal';
import Main from './frontend/main';
import Login from './frontend/login';
import Signup from './frontend/signup';
import { Route, Routes } from 'react-router-dom';

class Frontend extends Component {

    constructor(props){

        super(props);
        this.state = {
            informModal : {
                msg : '',
                show : false, 
                onHide : () => {}
            },
            confirmModal : {
                msg : '',
                show : false, 
                onHide : () => {},
                onConfirm : () => {}
            }
        };
    }

    render() {

        const {informModal, confirmModal} = this.state;
        const fctn = {
            login : {
                showInformModal : this.showInformModal,
                closeInformModal : this.closeInformModal
            },
            main : {
                showInformModal : this.showInformModal,
                closeInformModal : this.closeInformModal,
                showConfirmModal : this.showConfirmModal,
                closeConfirmModal : this.closeConfirmModal
            },
            signup : {
                showInformModal : this.showInformModal,
                closeInformModal : this.closeInformModal,
                showConfirmModal : this.showConfirmModal,
                closeConfirmModal : this.closeConfirmModal
            }
        };

        return (
            <Fragment>
                <Routes>
                    <Route path='/login' element={<Login fctn={fctn.login} />} />
                    <Route path='/signup' element={<Signup fctn={fctn.signup} />} />
                    <Route path='/*' element={<Main fctn={fctn.main} />} />
                </Routes>
                <InformModal msg={informModal.msg} show={informModal.show} onHide={informModal.onHide} />
                <ConfirmModal msg={confirmModal.msg} show={confirmModal.show} onHide={confirmModal.onHide} 
                        onConfirm={confirmModal.onConfirm} />
            </Fragment>
        );
    }

    // other
    showInformModal = (msg, onHide) => {

        const {informModal} = this.state;
        this.setState({
            informModal : {
                ...informModal,
                show : true,
                msg : msg,
                onHide : onHide ? onHide : () => {

                    this.closeInformModal();
                }
            }
        });
    };
    closeInformModal = () => {

        const {informModal} = this.state;
        this.setState({
            informModal : {
                ...informModal,
                show : false
            }
        });
    };
    showConfirmModal = (msg, onConfirm, onHide) => {

        const {confirmModal} = this.state;
        this.setState({
            confirmModal : {
                ...confirmModal,
                show : true,
                msg : msg,
                onConfirm : onConfirm,
                onHide : onHide ? onHide : () => {

                    this.closeConfirmModal();
                }
            }
        });
    };
    closeConfirmModal = () => {

        const {confirmModal} = this.state;
        this.setState({
            confirmModal : {
                ...confirmModal,
                show : false
            }
        });
    };
}

export default Frontend;