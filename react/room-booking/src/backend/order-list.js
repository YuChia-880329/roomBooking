import React, { Component, Fragment, createRef } from 'react';
import { Button, Container, Stack } from 'react-bootstrap';
import OrderTable from './order_list/order-table';
import Pagn from '../hoc/pagn';
import FilterModal from './order_list/filterModal';
import BackendHoc from '../hoc/backend-hoc';

class OrderList extends Component {

    filterModal = createRef();

    filterBtnClicked = () => {
        this.filterModal.current.filterBtnClicked();
    }

    content = () => {
        return (
            <Fragment>
                <Container className='w-75'>
                    <OrderTable />
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
            <BackendHoc titleText='訂房訂單' Content={this.content} />
        );
    }
}

export default OrderList;