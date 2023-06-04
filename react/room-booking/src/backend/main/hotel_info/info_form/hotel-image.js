import React, { Component } from 'react';
import { Col, Form, Image, Row } from 'react-bootstrap';

class HotelImage extends Component {

    render() {

        const imageStyle = {
            maxHeight : '10rem',
            maxWidth : '10rem',
            height : '10rem',
            width : '10rem'
        };
        const {imgName, url} = this.props;

        return (
            <Form.Group as={Row}>
                <Form.Label column xs='auto'>飯店照片 : </Form.Label>
                <Col>
                    <Row>
                        <Form.Label column xs='auto'>{imgName}</Form.Label>
                        <Form.Label column xs='auto'>
                            <Image src={url} alt='hotel photo' className='d-inline-block' style={imageStyle} />
                        </Form.Label>
                    </Row>
                </Col>
            </Form.Group>
        );
    }
}

export default HotelImage;