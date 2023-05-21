import React, { Component } from 'react';
import { Container } from 'react-bootstrap';
import BorderForm from '../hoc/form/border-form';
import CreateForm from './room_create/create-form';

class RoomCreate extends Component {
    render() {
        return (
            <Container className='w-75'>
                <BorderForm Content={CreateForm} />
            </Container>
        );
    }
}

export default RoomCreate;