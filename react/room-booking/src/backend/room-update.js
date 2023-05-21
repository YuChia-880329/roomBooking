import React, { Component } from 'react';
import { Container } from 'react-bootstrap';
import BorderForm from '../hoc/form/border-form';
import UpdateForm from './room_update/update-form';

class RoomUpdate extends Component {

    render() {
        return (
            <Container className='w-75'>
                <BorderForm Content={UpdateForm} />
            </Container>
        );
    }
}

export default RoomUpdate;