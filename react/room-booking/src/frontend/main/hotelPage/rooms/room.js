import React, { Component } from 'react';
import { Card, Carousel, Col, Form, Image, Row, Stack } from 'react-bootstrap';
import Feature from './room/feature';
import ShoppingCartForm from './room/shopping-cart-form';

class Room extends Component {

    render() {

        const hotelImgStyle = {
            minHeight : '25rem',
            height : '100%'
        };

        return (
            <Card>
                <Row>
                    <Col xs={5}>
                        <Carousel interval={null}>
                            <Carousel.Item>
                                <Image className="d-block w-100" style={hotelImgStyle} src="#" alt="First slide" />
                            </Carousel.Item>
                            <Carousel.Item>
                                <Image className="d-block w-100" style={hotelImgStyle} src="#" alt="Second slide" />
                            </Carousel.Item>
                            <Carousel.Item>
                                <Image className="d-block w-100" style={hotelImgStyle} src="#" alt="Third slide" />
                            </Carousel.Item>
                        </Carousel>
                    </Col>
                    <Col xs={7}>
                        <Card.Body className='h-100'>
                            <Stack className='h-100'>
                                <div>
                                    <Card.Title className='mt-1 fs-1 fw-bold'>標準雙人房</Card.Title>
                                    <div className='me-4 mt-5'>
                                        <Stack direction='horizontal' className='justify-content-evenly'>
                                            <Card.Text className='text-danger mt-1 mb-0 fs-3 align-self-center'>
                                                只剩 <span>3</span> 間
                                            </Card.Text>
                                            <Card.Text className='text-secondary mb-0 fs-2 align-self-center'>
                                                $ <span>1000</span> 元 / 間
                                            </Card.Text>
                                        </Stack>
                                        <Feature />
                                    </div>
                                </div>
                                <div className='mt-auto'>
                                    <Form className='mt-5'>
                                        <Stack direction='horizontal' className='justify-content-center'>
                                            <ShoppingCartForm />
                                        </Stack>
                                    </Form>
                                </div>
                            </Stack>
                        </Card.Body>
                    </Col>
                </Row>
            </Card>
        );
    }
}

export default Room;