import React, { Component, Fragment } from 'react';
import FrontendMain from '../../hoc/frontend-main';
import { Col, Row, Stack } from 'react-bootstrap';
import Item from './shoppingCart/item';
import TotalPrice from './shoppingCart/total-price';
import Pagn from '../../hoc/pagn';

class ShoppingCart extends Component {

    constructor(props){

        super(props);
        this.state = {
            pagination : {
                first : {
                    show : true,
                    toPage : 1
                },
                prev : {
                    show : true,
                    toPage : 1
                },
                pages : [1, 2, 3],
                next : {
                    show : true,
                    toPage : 3
                },
                last : {
                    show : true,
                    toPage : 3 
                },
                currentPage : 2
            }
        };
    }

    render() {

        return (
            <FrontendMain Content={this.Content} />
        );
    }

    // jsx
    Content = () => {

        const{pagination} = this.state;

        return (
            <Fragment>
                <h1>您的購物車</h1>
                <hr />
                <div className='mt-5'>
                    <Row>
                        <Col xs={8}>
                            <Stack gap={3}>
                                <Item />
                                <Item />
                                <Item />
                            </Stack>
                        </Col>
                        <Col xs={4}>
                            <Stack className='h-100'>
                                <TotalPrice />
                                <div className='mt-auto ms-auto'>
                                    <Pagn pagn={pagination} />
                                </div>
                            </Stack>
                        </Col>
                    </Row>
                </div>
            </Fragment>
        );
    }
}

export default ShoppingCart;