import React, { Component } from 'react';
import { Col, Form, Image, Row, Stack } from 'react-bootstrap';

class RoomImage extends Component {

    render() {

        const imageStyle = {
            maxHeight : '10rem',
            maxWidth : '10rem',
            height : '10rem',
            width : '10rem'
        };

        const options = ['---- 請選擇 ----', 'img1.jpg', 'img2.jpg', 
                'img3.jpg', 'img4.jpg', 'img5.jpg'];

        return (
            <Form.Group as={Row}>
                <Form.Label column xs='auto'>房間照片 : </Form.Label>
                <Col>
                    <Stack gap={4}>
                        <Form.Select>
                            {options.map(
                                opt => (
                                    <option key={opt}>{opt}</option>
                                )
                            )}
                        </Form.Select>
                        <div>
                            <Image src='#' alt='room photo' className='d-inline-block' style={imageStyle} />
                        </div>
                    </Stack>
                </Col>
            </Form.Group>
        );
    }
}

export default RoomImage;