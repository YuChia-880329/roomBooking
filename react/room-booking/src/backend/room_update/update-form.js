import React, { Component } from 'react';
import { Button, Col, Row, Stack } from 'react-bootstrap';
import Type from './update_form/type';
import Name from './update_form/name';
import TotalNum from './update_form/total-num';
import ValidNum from './update_form/valid-num';
import InvalidNum from './update_form/invalid-num';
import Price from './update_form/price';
import SingleBedNum from './update_form/single-bed-num';
import DoubleBedNum from './update_form/double-bed-num';
import Area from './update_form/area';
import Scene from './update_form/scene';
import Shower from './update_form/shower';
import RoomImage from './update_form/room-image';
import ImageOrder from './update_form/image-order';
import NewImage from './update_form/new-image';

class UpdateForm extends Component {
    render() {

        // style
        const deleteBtnStyle = {
            paddingTop : '0.2rem'
        };

        return (
            <Stack gap={5}>
                <Row>
                    <Col>
                        <Type />
                    </Col>
                    <Col>
                        <Name />
                    </Col>
                </Row>
                <Row>
                    <Col>
                        <TotalNum />
                    </Col>
                    <Col xs='auto' className='px-5'>
                        <ValidNum />
                    </Col>
                    <Col>
                        <InvalidNum />
                    </Col>
                </Row>
                <Row>
                    <Col>
                        <Price />
                    </Col>
                    <Col>
                        <SingleBedNum />
                    </Col>
                    <Col>
                        <DoubleBedNum />
                    </Col>
                </Row>
                <Row>
                    <Col>
                        <Area />
                    </Col>
                    <Col>
                        <Scene />
                    </Col>
                </Row>
                <Shower />
                <Row>
                    <Col>
                        <RoomImage />
                    </Col>
                    <Col>
                        <ImageOrder />
                    </Col>
                    <Col xs='auto' style={deleteBtnStyle}>
                        <Button variant='outline-primary' size='sm'>刪除照片</Button>
                    </Col>
                </Row>
                <NewImage />
                <Stack direction='horizontal'>
                    <Button variant='outline-primary' className='ms-auto'>更新資料</Button>
                </Stack>
            </Stack>
        );
    }
}

export default UpdateForm;