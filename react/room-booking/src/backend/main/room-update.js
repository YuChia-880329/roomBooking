import React, { Component, Fragment } from 'react';
import { Container } from 'react-bootstrap';
import BorderForm from '../../hoc/form/border-form';
import UpdateForm from './room_update/update-form';
import BackendMain from '../../hoc/backend-main';
import InformModal from '../../hoc/modal/inform-modal';

class RoomUpdate extends Component {

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
                <BackendMain titleText='房型更新' Content={this.Content} />
                <InformModal show={informModal.show} msg={informModal.msg} onHide={informModal.onHide} />
            </Fragment>
        );
    }

    // jsx
    Content = () => {

        return (
            <Container className='w-75'>
                <BorderForm Content={UpdateForm} />
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

export default RoomUpdate;