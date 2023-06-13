import React, { Component, Fragment } from 'react';
import { Col, Row, Stack } from 'react-bootstrap';
import Room from './rooms/room';
import Pagn from '../../../hoc/pagn';

class Rooms extends Component {

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

        const {pagination} = this.state;

        return (
            <Fragment>
                <Row xs={3}>
                    <Col>
                        <Room />
                    </Col>
                    <Col>
                        <Room />
                    </Col>
                    <Col>
                        <Room />
                    </Col>
                </Row>
                <Stack direction='horizontal' className='mt-5 justify-content-end'>
                    <Pagn pagn={pagination} />
                </Stack>
            </Fragment>
        );
    }
}

export default Rooms;