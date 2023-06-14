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
        const setter = {
            feature : {
                setFeature : (colVal, onSet) => this.setter('feature', colVal, onSet)
            }
        };
        const getter = {
            feature : {
                getFeature : () => this.getter('feature')
            }
        }

        return (
            <Card>
                <Row>
                    <Col xs={4}>
                        <Card.Img src={this.getter('imgUrl')} style={hotelImgStyle} className='d-block' alt='hotel image' />
                    </Col>
                    <Col xs={8}>
                        <Card.Body className='h-100'>
                            <Stack className='h-100'>
                                <div>
                                    <Card.Title className='fs-1 fw-bold'>{this.getter('hotelName')}</Card.Title>
                                    <Stack direction='horizontal'>
                                        <Image style={mapIconStyle} src={mapIcon} />
                                        <Card.Text className='mb-0 ms-2'>{this.getter('address')}</Card.Text>
                                    </Stack>
                                    <Card.Text className='ps-3 mb-0 mt-4'>{this.getter('description')}</Card.Text>
                                </div>
                                <div className='mt-auto'>
                                    <Feature setter={setter.feature} getter={getter.feature} />
                                </div>
                            </Stack>
                        </Card.Body>
                    </Col>
                </Row>
            </Card>
        );
    }


    // setter getter
    setter = (colName, colVal, onSet) => {

        const {setter, getter} = this.props;

        setter.setIntroduction({
            ...getter.getIntroduction(),
            [colName] : colVal
        }, onSet);
    };
    getter = (colName) => {

        const {getter} = this.props;
        return getter.getIntroduction()[colName];
    }
}

export default Introduction;