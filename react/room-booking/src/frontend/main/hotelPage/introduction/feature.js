import checkIcon from '../../../../image/check-icon.webp'
import React, { Component } from 'react';
import { Card, Col, Image, Row, Stack } from 'react-bootstrap';

class Feature extends Component {

    render() {

        const checkIconStyle = {
            width : '1rem',
            height : '1rem'
        };

        return (
            <Row className='mb-2'>
                {
                    this.getter('items').map(
                        feature => (
                            <Col xs={4} key={feature.id}>
                                <Stack direction='horizontal' className='justify-content-center'>
                                    <Image style={checkIconStyle} src={checkIcon} />
                                    <Card.Text className='mb-0 ms-2 text-info'>{feature.name}</Card.Text>
                                </Stack>
                            </Col>
                        )
                    )
                }
            </Row>
        );
    }

    // setter getter
    setter = (colName, colVal, onSet) => {

        const {setter, getter} = this.props;

        setter.setFeature({
            ...getter.getFeature(),
            [colName] : colVal
        }, onSet);
    };
    getter = (colName) => {

        const {getter} = this.props;
        return getter.getFeature()[colName];
    }
}

export default Feature;