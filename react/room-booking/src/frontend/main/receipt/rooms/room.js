import React, { Component } from 'react';
import { Card, Container } from 'react-bootstrap';

class Room extends Component {

    render() {

        return (
            <Card>
                <Card.Header className='fs-2 fw-bold'>XXX飯店</Card.Header>
                <Card.Body>
                    <Container className='my-2'>
                        <Card.Title className='fs-3'>標準單人房</Card.Title>
                        <div className='mt-4'>
                            <Card.Text>
                                <span>2023/06/01</span> - <span>2023/06/02</span>
                            </Card.Text>
                            <Card.Text>
                                預計 <span>16 : 00</span> 入住
                            </Card.Text>
                            <Card.Text>
                                數量 : <span>1</span> 間
                            </Card.Text>
                            <Card.Text>
                                價錢 : <span>1000</span> 元
                            </Card.Text>
                        </div>
                    </Container>
                </Card.Body>
            </Card>
        );
    }
}

export default Room;