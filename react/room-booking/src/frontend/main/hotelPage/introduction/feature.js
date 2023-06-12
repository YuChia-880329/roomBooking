import checkIcon from '../../../../image/check-icon.webp'
import React, { Component } from 'react';
import { Card, Col, Image, Row, Stack } from 'react-bootstrap';

const constant = {
    features : ['房內免費Wi-Fi', '停車場', '可寄放行李']
};

class Feature extends Component {

    render() {

        const checkIconStyle = {
            width : '1rem',
            height : '1rem'
        };

        return (
            <Row className='mb-2'>
                {
                    constant.features.map(
                        feature => (
                            <Col xs={4} key={feature}>
                                <Stack direction='horizontal' className='justify-content-center'>
                                    <Image style={checkIconStyle} src={checkIcon} />
                                    <Card.Text className='mb-0 ms-2 text-info'>{feature}</Card.Text>
                                </Stack>
                            </Col>
                        )
                    )
                }
            </Row>
        );
    }
}

export default Feature;