import React, { Component } from 'react';
import { Container } from 'react-bootstrap';
import BorderForm from '../hoc/form/border-form';
import UpdateForm from './room_update/update-form';
import BackendHoc from '../hoc/backend-hoc';

class RoomUpdate extends Component {

    content = () => {
        return (
            <Container className='w-75'>
                <BorderForm Content={UpdateForm} />
            </Container>
        );
    };

    render() {
        return (
            <BackendHoc titleText='房型更新' Content={this.content} />
        );
    }
}

export default RoomUpdate;