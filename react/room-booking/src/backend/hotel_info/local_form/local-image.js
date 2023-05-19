import React, { Component } from 'react';
import { Col, Form, Image, Row } from 'react-bootstrap';

class LocalImage extends Component {

    render() {

        // style
        const imageColStyle = {
            paddingTop : 'calc(.375rem + 1px)'
        };
        const imageStyle = {
            maxHeight : '10rem',
            maxWidth : '10rem',
            height : '10rem',
            width : '10rem'
        };


        return (
            <Form.Group as={Row}>
                <Form.Label column xs='auto'>飯店照片  : </Form.Label>
                <Form.Label column xs='auto'>img1.jpg</Form.Label>
                <Col xs='auto' style={imageColStyle}>
                    <Image src='#' alt='hotel photo' className='d-inline-block' style={imageStyle} />
                </Col>
            </Form.Group>
        );
    }
}

export default LocalImage;