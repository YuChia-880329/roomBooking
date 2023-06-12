import mapIcon from '../../../../image/map-icon.jpg'
import React, { Component } from 'react';
import { Card, Col, Image, Row, Stack } from 'react-bootstrap';

class Hotel extends Component {

    render() {

        const mapIconStyle = {
            width : '0.4rem',
            height : '0.6rem'
        };
        const hotelImgStyle = {
            minHeight : '15rem'
        }

        return (
            <Card>
                <Row>
                    <Col xs={4}>
                        <a href='#' className='stretched-link'>
                            <Card.Img src="#" style={hotelImgStyle} className='d-block' alt='hotel image' />
                        </a>
                    </Col>
                    <Col xs={8}>
                        <Card.Body className='h-100'>
                            <Stack className='h-100'>
                                <div>
                                    <Card.Title className='fs-1 fw-bold'>XXX飯店</Card.Title>
                                    <Stack direction='horizontal'>
                                        <Image style={mapIconStyle} src={mapIcon} />
                                        <Card.Text className='mb-0 ms-2'>西門町</Card.Text>
                                    </Stack>
                                </div>
                                <div className='mt-auto'>
                                    <div className='me-2'>
                                        <Stack direction='horizontal' className='justify-content-end'>
                                            <Card.Text className='text-danger fs-4'>
                                                只剩 <span>3</span> 間
                                            </Card.Text>
                                        </Stack>
                                        <Stack direction='horizontal' className='justify-content-end'>
                                            <Card.Text className='text-secondary fs-3'>
                                                $ <span>1000</span> 元
                                            </Card.Text>
                                        </Stack>
                                    </div>
                                </div>
                            </Stack>
                        </Card.Body>
                    </Col>
                </Row>
            </Card>
        );
    }
}

export default Hotel;