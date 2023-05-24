import React, { Component } from 'react';
import { Col, Form, Image, Row } from 'react-bootstrap';
import HorizontalFormInput from '../../../../hoc/form/horizontal-form-input';

class HotelImage extends Component {

    Ctrl = () => {
        
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
            <Row>
                <Form.Label column xs='auto'>img1.jpg</Form.Label>
                <Col xs='auto' style={imageColStyle}>
                    <Image src='#' alt='hotel photo' className='d-inline-block' style={imageStyle} />
                </Col>
            </Row>
        );
    };
    
    render() {

        return (
            <HorizontalFormInput text='飯店照片' Ctrl={this.Ctrl} />
        );
    }
}

export default HotelImage;