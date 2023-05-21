import React, { Component } from 'react';
import { Button, Container, Stack } from 'react-bootstrap';
import RoomTable from './room_list/room-table';
import Pagn from '../hoc/pagn';

class RoomList extends Component {
    render() {
        return (
            <Container className='w-75'>
                <RoomTable />
                <Stack direction='horizontal' className='mt-5'>
                    <div>
                        <Button variant='outline-primary'>篩選</Button>
                    </div>
                    <div className='ms-auto'>
                        <Pagn pages={[1, 2, 3]} />
                    </div>
                </Stack>
            </Container>
        );
    }
}

export default RoomList;