import mapIcon from '../../../../image/map-icon.jpg'
import React, { Component } from 'react';
import { Card, Col, Image, Row, Stack } from 'react-bootstrap';
import { useNavigate } from 'react-router-dom';

class HotelWrapped extends Component {

    render() {

        const mapIconStyle = {
            width : '0.4rem',
            height : '0.6rem'
        };
        const hotelImgStyle = {
            minHeight : '15rem'
        }
        const {value} = this.props;

        return (
            <Card>
                <Row>
                    <Col xs={4}>
                        <a href='.' className='stretched-link' onClick={e => this.onClick(e, value.hotelId)}>
                            <Card.Img src={value.imgUrl} style={hotelImgStyle} className='d-block' alt='hotel image' />
                        </a>
                    </Col>
                    <Col xs={8}>
                        <Card.Body className='h-100'>
                            <Stack className='h-100'>
                                <div>
                                    <Card.Title className='fs-1 fw-bold'>{value.hotelName}</Card.Title>
                                    <Stack direction='horizontal'>
                                        <Image style={mapIconStyle} src={mapIcon} />
                                        <Card.Text className='mb-0 ms-2'>{value.sectionName}</Card.Text>
                                    </Stack>
                                </div>
                                <div className='mt-auto'>
                                    <div className='me-2'>
                                        <Stack direction='horizontal' gap={3} className='justify-content-end mb-2'>
                                            <Card.Text className='mb-0 fs-3'>
                                                <span>{value.roomName}</span>
                                            </Card.Text>
                                            <Card.Text className='mb-0 text-danger fs-4'>
                                                只剩 <span>{value.validNum}</span> 間
                                            </Card.Text>
                                        </Stack>
                                        <Stack direction='horizontal' className='justify-content-end'>
                                            <Card.Text className='mb-0 text-secondary fs-3'>
                                                $ <span>{value.price}</span> 元
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

    // on
    onClick = (event, hotelId) => {

        const {navigate, getter} = this.props;

        event.preventDefault();

        navigate(`../hotelPage/${hotelId}`, {
            state : {
                checkinDate : getter.getFilterForm().date.valueCheckinDate,
                checkoutDate : getter.getFilterForm().date.valueCheckoutDate,
                number : getter.getFilterForm().number.value
            }
        });
    }
}

const Hotel = props => {

    const navigate = useNavigate();
    return (<HotelWrapped {...props} navigate={navigate} />);
}

export default Hotel;