import React, { Component } from 'react';
import { Col, Form, Image, Row } from 'react-bootstrap';

class HotelImage extends Component {

    render() {

        const imageStyle = {
            maxHeight : '15rem',
            maxWidth : '15rem',
            height : '15rem',
            width : '15rem'
        };
        const {value} = this.props;

        return (
            <Form.Group as={Row}>
                <Form.Label column xs='auto'>飯店照片 : </Form.Label>
                <Col>
                    <Row>
                        <Form.Label column xs='auto'>{value.imageName}</Form.Label>
                        <Form.Label column xs='auto'>
                            <Image src={value.url} alt='hotel photo' className='d-inline-block' style={imageStyle} />
                        </Form.Label>
                    </Row>
                </Col>
            </Form.Group>
        );
    }
}

export default HotelImage;