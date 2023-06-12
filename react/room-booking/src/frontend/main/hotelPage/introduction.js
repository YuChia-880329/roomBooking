import mapIcon from '../../../image/map-icon.jpg'
import React, { Component } from 'react';
import { Card, Col, Image, Row, Stack } from 'react-bootstrap';
import Feature from './introduction/feature';

class Introduction extends Component {

    render() {

        const mapIconStyle = {
            width : '0.4rem',
            height : '0.6rem'
        };
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
                            <Stack className='h-100'>
                                <div>
                                    <Card.Title className='fs-1 fw-bold'>XXX飯店</Card.Title>
                                    <Stack direction='horizontal'>
                                        <Image style={mapIconStyle} src={mapIcon} />
                                        <Card.Text className='mb-0 ms-2'>台北市萬華區...</Card.Text>
                                    </Stack>
                                    <Card.Text className='ps-3 mb-0 mt-4'>入住完美住宿，是完美旅程的必備要素。快來享受住宿提供的客房免費Wi-Fi吧！ 住宿位於中山區的絕佳位置，讓您輕鬆探索周遭景點。 離開前，別忘了探訪知名的台北101大樓。 這間3星級飯店提供室外泳池，給您舒適難忘的住宿體驗。</Card.Text>
                                </div>
                                <div className='mt-auto'>
                                    <Feature />
                                </div>
                            </Stack>
                        </Card.Body>
                    </Col>
                </Row>
            </Card>
        );
    }
}

export default Introduction;