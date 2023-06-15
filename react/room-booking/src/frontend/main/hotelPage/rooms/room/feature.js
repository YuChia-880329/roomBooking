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
        const {value} = this.props;

        return (
            <Stack className='mt-4'>
                <Stack direction='horizontal' className='justify-content-evenly mt-4'>
                    <Stack direction='horizontal'>
                        <Image src={bedIcon} style={featureIconStyle} />
                        <div>
                            {
                                value.bedNum.singleBedNum.show && 
                                    <Card.Text className='mb-0 ms-2'>
                                        <span>{value.bedNum.singleBedNum.num}</span> x 單人床
                                    </Card.Text>
                            }
                            {
                                value.bedNum.doubleBedNum.show && 
                                    <Card.Text className='mb-0 ms-2'>
                                        <span>{value.bedNum.doubleBedNum.num}</span> x 雙人床
                                    </Card.Text>
                            }
                        </div>
                    </Stack>
                    <Stack direction='horizontal'>
                        <Image src={areaIcon} style={featureIconStyle} />
                        <Card.Text className='mb-0 ms-2'>
                            <span>{value.area}</span> 平方公尺
                        </Card.Text>
                    </Stack>
                </Stack>
                <Stack direction='horizontal' className='justify-content-evenly mt-4'>
                    <Stack direction='horizontal'>
                        <Image src={balconyIcon} style={featureIconStyle} />
                        <Card.Text className='mb-0 ms-2'>
                            <span>{value.sceneName}</span>
                        </Card.Text>
                    </Stack>
                    <Stack direction='horizontal'>
                        <Image src={showerIcon} style={featureIconStyle} />
                        <div>
                            {
                                value.showers.map(
                                    shower => (
                                        <Card.Text className='mb-0 ms-2' key={shower.id}>
                                            <span>{shower.name}</span>
                                        </Card.Text>
                                    )
                                )
                            }
                        </div>
                    </Stack>
                </Stack>
            </Stack>
        );
    }
}

export default Feature;