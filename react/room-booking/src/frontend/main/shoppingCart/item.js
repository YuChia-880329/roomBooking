import trashCanIcon from '../../../image/trashCan-icon.png'
import React, { Component } from 'react';
import { Card, Carousel, Col, Image, Row, Stack } from 'react-bootstrap';

class Item extends Component {

    render() {

        const trashCanIconStyle = {
            width: '1.5rem',
			height: '1.8rem'
        }
        const hotelImgStyle = {
            minHeight : '20rem'
        }
        const {value} = this.props;

        return (
            <Card>
                <Row>
                    <Col xs={4}>
                        <Carousel interval={null}>
                            {
                                value.images.map(
                                    image => (
                                        <Carousel.Item key={image.imgUrl}>
                                            <Image className="d-block w-100" style={hotelImgStyle} src={image.imgUrl} alt="room image" />
                                        </Carousel.Item>
                                    )
                                )
                            }
                        </Carousel>
                    </Col>
                    <Col xs={8}>
                        <Card.Body className='h-100'>
                            <Stack className='h-100 me-2'>
                                <div>
                                    <Stack direction='horizontal'>
                                        <Card.Title className='fs-1 fw-bold mb-0'>{value.hotelName}</Card.Title>
                                        <div className='ms-auto'>
                                            <a href='.' onClick={e => this.onClickDelete(e, value.itemId)} >
                                                <Image src={trashCanIcon} style={trashCanIconStyle} />
                                            </a>
                                        </div>
                                    </Stack>
                                    
                                    <div className='ms-3 mt-5'>
                                        <Card.Text className='fs-4 text-info'>
                                            <span>{value.num}</span> x <span>{value.roomName}</span>
                                        </Card.Text>
                                        <Stack direction='horizontal' gap={2}>
                                            <Card.Text className='fs-4 mb-0 text-warning'>
                                                <span>{value.checkinDate}</span>(預計 <span>{value.checkinTime}</span> 入住)
                                            </Card.Text>
                                            <Card.Text className='fs-4 mb-0 text-warning'> ~ </Card.Text>
                                            <Card.Text className='fs-4 mb-0 text-warning'>
                                                <span>{value.checkoutDate}</span>
                                            </Card.Text>
                                        </Stack>
                                    </div>
                                </div>
                                <div className='mt-auto'>
                                    <Stack direction='horizontal' className='justify-content-end'>
                                        <Card.Text className='fs-3 text-secondary'>
                                            $ <span>{value.price}</span> 元 / 間
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

    onClickDelete = (event, itemId) => {

        const {fctn} = this.props;
        
        event.preventDefault();

        fctn.showConfirmModal('確定要刪除選項 ? ', () => {

            fctn.closeConfirmModal();
            fctn.delete(itemId);
        });
    }
}

export default Item;