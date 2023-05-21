import React, { Component } from 'react';
import { Form, Image, Stack } from 'react-bootstrap';
import SelectFormInput from '../../../hoc/form/select-form-input';

class RoomImage extends Component {

    ctrl = () => {

        // style
        const imageStyle = {
            maxHeight : '10rem',
            maxWidth : '10rem',
            height : '10rem',
            width : '10rem'
        };

        return (
            <Stack gap={4}>
                <Form.Select>
                    <option>---- 請選擇 ----</option>
                    <option>img1.jpg</option>
                    <option>img2.jpg</option>
                    <option>img3.jpg</option>
                    <option>img4.jpg</option>
                    <option>img5.jpg</option>
                </Form.Select>
                <Image src='#' alt='room photo' className='d-inline-block' style={imageStyle} />
            </Stack>
            
        );
    };
    imgCtrl = () => {

        // style
        const imageStyle = {
            maxHeight : '10rem',
            maxWidth : '10rem',
            height : '10rem',
            width : '10rem'
        };

        return (
            <Image src='#' alt='room photo' className='d-inline-block' style={imageStyle} />
        );
    }
    render() {

        const options = ['---- 請選擇 ----', 'img1.jpg', 'img2.jpg', 
                'img3.jpg', 'img4.jpg', 'img5.jpg'];

        return (
            <SelectFormInput text='房間照片' options={options} AddCtrl={this.imgCtrl} />
        );
    }
}

export default RoomImage;