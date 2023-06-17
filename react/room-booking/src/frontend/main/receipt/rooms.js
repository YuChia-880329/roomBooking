import React, { Component, Fragment } from 'react';
import { Col, Row, Stack } from 'react-bootstrap';
import Room from './rooms/room';
import Pagn from '../../../hoc/pagn';

class Rooms extends Component {

    render() {

        const {fctn} = this.props;

        return (
            <Fragment>
                <Row xs={3} className='g-4'>
                    {
                        this.getter('items').map(
                            item => (
                                <Col key={item.itemId}>
                                    <Room value={item} />
                                </Col>
                            )
                        )
                    }
                </Row>
                <Stack direction='horizontal' className='mt-5 justify-content-end'>
                    <Pagn pagn={this.getter('pagination')} turnPage={fctn.turnPage} />
                </Stack>
            </Fragment>
        );
    }

    // setter getter
    setter = (colName, colVal, onSet) => {

        const {setter, getter} = this.props;

        setter.setRooms({
            ...getter.getRooms(),
            [colName] : colVal
        }, onSet);
    };
    getter = (colName) => {

        const {getter} = this.props;
        return getter.getRooms()[colName];
    }
}

export default Rooms;