import React, { Component } from 'react';
import { Container } from 'react-bootstrap';
import BorderForm from '../../hoc/form/border-form';
import UpdateForm from './room_update/update-form';
import BackendMain from '../../hoc/backend-main';

class RoomUpdate extends Component {

    render() {
        
        return (
            <BackendMain titleText='房型更新' Content={this.Content} />
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
}

export default RoomUpdate;