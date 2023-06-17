import React, { Component } from 'react';
import { Card, Container } from 'react-bootstrap';

class Room extends Component {

    render() {

        const {value} = this.props;

        return (
            <Card>
                <Card.Header className='fs-2 fw-bold'>{value.hotelName}</Card.Header>
                <Card.Body>
                    <Container className='my-2'>
                        <Card.Title className='fs-3'>{value.roomName}</Card.Title>
                        <div className='mt-4'>
                            <Card.Text>
                                <span>{value.checkinDate}</span> ~ <span>{value.checkoutDate}</span>
                            </Card.Text>
                            <Card.Text>
                                預計 <span>{value.checkinTime}</span> 入住
                            </Card.Text>
                            <Card.Text>
                                數量 : <span>{value.num}</span> 間
                            </Card.Text>
                            <Card.Text>
                                價錢 : <span>{value.price}</span> 元
                            </Card.Text>
                        </div>
                    </Container>
                </Card.Body>
            </Card>
        );
    }
}

export default Room;