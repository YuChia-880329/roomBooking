import trashCanIcon from '../../../image/trashCan-icon.png'
import React, { Component } from 'react';
import { Card, Col, Image, Row, Stack } from 'react-bootstrap';

class Item extends Component {

    render() {

        const trashCanIconStyle = {
            width: '1.5rem',
			height: '1.8rem'
        }
        const hotelImgStyle = {
            minHeight : '20rem'
        }

        return (
            <Card>
                <Row>
                    <Col xs={4}>
                        <Card.Img src="#" style={hotelImgStyle} className='d-block' alt='hotel image' />
                    </Col>
                    <Col xs={8}>
                        <Card.Body className='h-100'>
                            <Stack className='h-100 me-2'>
                                <div>
                                    <Stack direction='horizontal'>
                                        <Card.Title className='fs-1 fw-bold mb-0'>XXX飯店</Card.Title>
                                        <div className='ms-auto'>
                                            <Image src={trashCanIcon} style={trashCanIconStyle} />
                                        </div>
                                    </Stack>
                                    
                                    <div className='ms-3 mt-5'>
                                        <Card.Text className='fs-4 text-info'>
                                            <span>1</span> x 標準雙人房
                                        </Card.Text>
                                        <Card.Text className='fs-4 text-warning'>
                                            <span>2023/5/12</span> ~ <span>2023/5/13</span>
                                        </Card.Text>
                                    </div>
                                </div>
                                <div className='mt-auto'>
                                    <Stack direction='horizontal' className='justify-content-end'>
                                        <Card.Text className='fs-3 text-secondary'>
                                            $ <span>1000</span>
                                        </Card.Text>
                                    </Stack>
                                </div>
                            </Stack>
                        </Card.Body>
                    </Col>
                </Row>
            </Card>
        );
    }
}

export default Item;