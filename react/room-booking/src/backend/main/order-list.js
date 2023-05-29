import React, { Component, Fragment } from 'react';
import { Button, Container, Stack } from 'react-bootstrap';
import OrderTable from './order_list/order-table';
import Pagn from '../../hoc/pagn';
import FilterModal from './order_list/filterModal';
import BackendMain from '../../hoc/backend-main';

class OrderList extends Component {

    render() {
        
        return (
            <BackendMain titleText='訂房訂單' Content={this.Content} />
        );
    }

    // jsx
    Content = () => {

        return (
            <Fragment>
                <Container className='w-75'>
                    <OrderTable />
                    <Stack direction='horizontal' className='mt-5'>
                        <div>
                            <Button variant='outline-primary'>篩選</Button>
                        </div>
                        <div className='ms-auto'>
                        <Pagn pagn={{first : {}, prev : {}, pages : [], next : {}, last : {}, currentPage : {}}} />
                        </div>
                    </Stack>
                </Container>
                <FilterModal />
            </Fragment>
        );
    };
    

}

export default OrderList;