import React, { Component, Fragment, createRef } from 'react';
import { Button, Container, Stack } from 'react-bootstrap';
import RoomTable from './room_list/room-table';
import Pagn from '../hoc/pagn';
import FilterModal from './room_list/filter-modal';
import BackendHoc from '../hoc/backend-hoc';

class RoomList extends Component {

    filterModal = createRef();

    filterBtnClicked = () => {
        this.filterModal.current.filterBtnClicked();
    }

    content = () => {
        return (
            <Fragment>
                <Container className='w-75'>
                    <RoomTable />
                    <Stack direction='horizontal' className='mt-5'>
                        <div>
                            <Button variant='outline-primary' onClick={this.filterBtnClicked}>篩選</Button>
                        </div>
                        <div className='ms-auto'>
                            <Pagn pages={[1, 2, 3]} />
                        </div>
                    </Stack>
                </Container>
                <FilterModal ref={this.filterModal} />
            </Fragment>
        );
    };

    render() {
        return (
            <BackendHoc titleText='房型列表' Content={this.content} />
        );
    }
}

export default RoomList;