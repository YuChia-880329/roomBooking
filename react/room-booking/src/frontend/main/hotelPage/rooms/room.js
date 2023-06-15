import {indexof} from '../../../../files/util';
import React, { Component } from 'react';
import { Card, Carousel, Col, Image, Row, Stack } from 'react-bootstrap';
import Feature from './room/feature';
import ShoppingCartForm from './room/shopping-cart-form';

class Room extends Component {

    render() {

        const hotelImgStyle = {
            minHeight : '25rem',
            height : '100%'
        };
        const {value} = this.props;
        const setter = {
            shoppingCartForm : {
                setShoppingCartForm : (colVal, onSet) => this.setter('shoppingCartForm', colVal, onSet)
            }
        }
        const getter = {
            shoppingCartForm : {
                getShoppingCartForm : () => this.getter('shoppingCartForm')
            }
        }
        const fctn = {
            shoppingCartForm : {
                showInformModal : this.props.fctn.showInformModal,
                closeInformModal : this.props.fctn.closeInformModal,
                showBuyModal : this.props.fctn.showBuyModal,
                closeBuyModal : this.props.fctn.closeBuyModal,
                setBuyModal : this.setBuyModal,
                submitBuyModal : this.props.fctn.submitBuyModal
            }
        };


        return (
            <Card>
                <Row>
                    <Col xs={5}>
                        <Carousel interval={null}>
                            {
                                value.images.map(
                                    image => (
                                        <Carousel.Item key={image.id}>
                                            <Image className="d-block w-100" style={hotelImgStyle} src={image.imgUrl} alt="room image" />
                                        </Carousel.Item>
                                    )
                                )
                            }
                        </Carousel>
                    </Col>
                    <Col xs={7}>
                        <Card.Body className='h-100'>
                            <Stack className='h-100'>
                                <div>
                                    <Card.Title className='mt-1 fs-1 fw-bold'>{value.name}</Card.Title>
                                    <div className='me-4 mt-5'>
                                        <Stack direction='horizontal' className='justify-content-evenly'>
                                            <Card.Text className='text-danger mt-1 mb-0 fs-3 align-self-center'>
                                                只剩 <span>{value.validNum}</span> 間
                                            </Card.Text>
                                            <Card.Text className='text-secondary mb-0 fs-2 align-self-center'>
                                                $ <span>{value.price}</span> 元 / 間
                                            </Card.Text>
                                        </Stack>
                                        <Feature value={value.features} />
                                    </div>
                                </div>
                                <div className='mt-auto'>
                                    <ShoppingCartForm setter={setter.shoppingCartForm} getter={getter.shoppingCartForm} fctn={fctn.shoppingCartForm} />
                                </div>
                            </Stack>
                        </Card.Body>
                    </Col>
                </Row>
            </Card>
        );
    }


    // other
    setBuyModal = (num, onSet) => {

        const {value, fctn} = this.props;

        fctn.setBuyModal(value.roomId, value.name, value.validNum, value.price, num, onSet);
    }


    // setter getter
    setter = (colName, colVal, onSet) => {

        const {setter, getter} = this.props;
        const items = getter.getItems();

        setter.setItems(items.with(this.index(), {
            ...items[this.index()],
            [colName] : colVal
        }), onSet);
    };
    getter = (colName) => {

        const {getter} = this.props;
        return getter.getItems()[this.index()][colName];
    }
    index = () => {

        const {value, getter} = this.props;
        const items = getter.getItems();
        return indexof(items, item => item.roomId===value.roomId);
    }
}

export default Room;