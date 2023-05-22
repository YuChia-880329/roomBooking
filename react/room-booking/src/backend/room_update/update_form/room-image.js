import React, { Component } from 'react';
import { Image } from 'react-bootstrap';
import SelectFormInput from '../../../hoc/form/select-form-input';

class RoomImage extends Component {

    ImgCtrl = () => {

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
            <SelectFormInput text='房間照片' options={options} AddCtrl={this.ImgCtrl} />
        );
    }
}

export default RoomImage;