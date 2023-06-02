import React, { Component, Fragment } from 'react';
import { Container } from 'react-bootstrap';
import BorderForm from '../../hoc/form/border-form';
import CreateForm from './room_create/create-form';
import BackendMain from '../../hoc/backend-main';
import InformModal from '../../hoc/modal/inform-modal';

class RoomCreate extends Component {

    constructor(props){

        super(props);
        this.state = {
            informModal : {
                show : false,
                msg : '',
                onHide : () => {}
            }
        };
    }

    render() {
        
        const {informModal} = this.state;

        return (
            <Fragment>
                <BackendMain titleText='新增房型' Content={this.Content} />
                <InformModal show={informModal.show} msg={informModal.msg} onHide={informModal.onHide} />
            </Fragment>
        );
    }

    // jsx
    Content = () => {

        return (
            <Container className='w-75'>
                <BorderForm Content={CreateForm} />
            </Container>
        );
    };

    // other
    showInformModal = (msg, onHide) => {

        const {informModal} = this.state;
        this.setState({
            informModal : {
                ...informModal,
                show : true,
                msg : msg,
                onHide : onHide
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
}

export default RoomCreate;