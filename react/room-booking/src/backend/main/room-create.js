import React, { Component } from 'react';
import { Container } from 'react-bootstrap';
import BorderForm from '../../hoc/form/border-form';
import CreateForm from './room_create/create-form';
import BackendMain from '../../hoc/backend-main';

class RoomCreate extends Component {

    componentDidMount(){

        const {fctn} = this.props;

        fctn.checkLogin();
    }

    render() {

        return (
            <BackendMain titleText='新增房型' Content={this.Content} />
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
}

export default RoomCreate;