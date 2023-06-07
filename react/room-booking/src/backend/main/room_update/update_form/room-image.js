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
        const {value} = this.props;

        return (
            <Form.Group as={Row}>
                <Form.Label column xs='auto'>房間照片 : </Form.Label>
                <Col>
                    <Stack gap={4}>
                        <Form.Control as='select' value={value.value} onChange={this.onChange}>
                            <option value=''>---- 請選擇 ----</option>
                            {
                                value.options.map(
                                    op => (
                                        <option key={op}></option>
                                    )
                                )
                            }
                        </Form.Control>
                        <div>
                            <Image src={value.url} alt='room photo' className='d-inline-block' style={imageStyle} />
                        </div>
                    </Stack>
                </Col>
            </Form.Group>
        );
    }

    // on
    onChange = (event) => {

        this.setter('value', event.target.value);
    };


    // setter
    setter = (colName, colVal, onSet) => {

        const {setter, value} = this.props;
        setter.setRoomImage({
            ...value,
            [colName] : colVal
        }, onSet);
    };
}

export default RoomImage;