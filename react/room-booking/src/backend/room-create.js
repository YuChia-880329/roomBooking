import React, { Component } from 'react';
import { Container } from 'react-bootstrap';
import BorderForm from '../hoc/form/border-form';
import CreateForm from './room_create/create-form';
import BackendHoc from '../hoc/backend-hoc';

class RoomCreate extends Component {

    Content = () => {

        return (
            <Container className='w-75'>
                <BorderForm Content={CreateForm} />
            </Container>
        );
    };

    render() {
        
        return (
            <BackendHoc titleText='新增房型' Content={this.Content} />
        );
    }
}

export default RoomCreate;