import React, { Component, createRef } from 'react';
import { Button, Container, Stack } from 'react-bootstrap';
import OrderTable from './order_list/order-table';
import Pagn from '../hoc/pagn';
import FilterModal from './order_list/filterModal';

class OrderList extends Component {

    filterModal = createRef();

    filterBtnClicked = () => {
        this.filterModal.current.filterBtnClicked();
    }
    
    render() {
        return (
            <div>
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
            </div>
        );
    }
}

export default OrderList;