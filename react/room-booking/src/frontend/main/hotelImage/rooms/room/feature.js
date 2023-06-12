import bedIcon from '../../../../../image/bed-icon.png';
import areaIcon from '../../../../../image/area-icon.png';
import balconyIcon from '../../../../../image/balcony-icon.webp';
import showerIcon from '../../../../../image/shower-icon.png';
import React, { Component } from 'react';
import { Card, Image, Stack } from 'react-bootstrap';

class Feature extends Component {

    render() {

        const featureIconStyle = {
            width : '1rem',
            height : '1rem'
        };

        return (
            <Stack className='mt-4'>
                <Stack direction='horizontal' className='justify-content-evenly mt-4'>
                    <Stack direction='horizontal'>
                        <Image src={bedIcon} style={featureIconStyle} />
                        <div>
                            <Card.Text className='mb-0 ms-2'>
                                <span>1</span> x單人床
                            </Card.Text>
                            <Card.Text className='mb-0 ms-2'>
                                <span>1</span> x雙人床
                            </Card.Text>
                        </div>
                    </Stack>
                    <Stack direction='horizontal'>
                        <Image src={areaIcon} style={featureIconStyle} />
                        <Card.Text className='mb-0 ms-2'>
                            <span>13</span> 平方公尺
                        </Card.Text>
                    </Stack>
                </Stack>
                <Stack direction='horizontal' className='justify-content-evenly mt-4'>
                    <Stack direction='horizontal'>
                        <Image src={balconyIcon} style={featureIconStyle} />
                        <Card.Text className='mb-0 ms-2'>
                            <span>市景</span>
                        </Card.Text>
                    </Stack>
                    <Stack direction='horizontal'>
                        <Image src={showerIcon} style={featureIconStyle} />
                        <div>
                            <Card.Text className='mb-0 ms-2'>
                                <span>淋浴設備</span>
                            </Card.Text>
                            <Card.Text className='mb-0 ms-2'>
                                <span>浴缸</span>
                            </Card.Text>
                            <Card.Text className='mb-0 ms-2'>
                                <span>蒸氣室</span>
                            </Card.Text>
                        </div>
                    </Stack>
                </Stack>
            </Stack>
        );
    }
}

export default Feature;