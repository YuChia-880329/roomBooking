import React, { Component, Fragment, createRef } from 'react';
import LoginForm from './login/login-form';
import InformModal from '../hoc/modal/inform-modal';

class Login extends Component {

    informModalRef = createRef();

    constructor(props){

        super(props);
        this.state = {
            informModal : {
                msg : ''
            }
        }
    }


    informModalShow = (msg) => {

        this.setState({
            informModal : {
                msg : msg
            }
        });
        this.informModalRef.current.handleShow();
    }
    informModalHide = () => {

        this.informModalRef.current.handleClose();
    }

    render() {

        // state
        const {informModal} = this.state;

        const informModalHandle = {
            informModalShow : this.informModalShow
        };

        return (
            <Fragment>
                <div className='position-absolute top-50 start-50 translate-middle'>
                    <LoginForm informModalHandle={informModalHandle} />
                </div>
                <InformModal ref={this.informModalRef} msg={informModal.msg} />
            </Fragment>
        );
    }
}

export default Login;