import React, { Component } from 'react';
import { Button, Col, Form, Row, Stack } from 'react-bootstrap';
import Type from './update_form/type';
import Name from './update_form/name';
import TotalNumber from './update_form/total-number';
import ValidNumber from './update_form/valid-number';
import InvalidNumber from './update_form/invalid-number';
import Price from './update_form/price';
import SingleBedNumber from './update_form/single-bed-number';
import DoubleBedNumber from './update_form/double-bed-number';
import Area from './update_form/area';
import Scene from './update_form/scene';
import Shower from './update_form/shower';
import RoomImage from './update_form/room-image';
import ImageOrder from './update_form/image-order';
import NewImage from './update_form/new-image';

class UpdateForm extends Component {
    render() {

        // style
        const formRowStyle = {
            marginTop : '3rem'
        };
        const deleteBtnStyle = {
            paddingTop : '0.2rem'
        };

        return (
            <Form>
                <Row>
                    <Col>
                        <Type />
                    </Col>
                    <Col>
                        <Name />
                    </Col>
                </Row>
                <Row style={formRowStyle}>
                    <Col>
                        <TotalNumber />
                    </Col>
                    <Col xs='auto' className='px-5'>
                        <ValidNumber />
                    </Col>
                    <Col>
                        <InvalidNumber />
                    </Col>
                </Row>
                <Row style={formRowStyle}>
                    <Col>
                        <Price />
                    </Col>
                    <Col>
                        <SingleBedNumber />
                    </Col>
                    <Col>
                        <DoubleBedNumber />
                    </Col>
                </Row>
                <Row style={formRowStyle}>
                    <Col>
                        <Area />
                    </Col>
                    <Col>
                        <Scene />
                    </Col>
                    
                </Row>
                <Row style={formRowStyle}>
                    <Col>
                        <Shower />
                    </Col>
                </Row>
                <Row style={formRowStyle}>
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
                <Row style={formRowStyle}>
                    <Col>
                        <NewImage />
                    </Col>
                </Row>
                <Stack direction='horizontal' style={formRowStyle}>
                    <Button variant='outline-primary' className='ms-auto'>更新資料</Button>
                </Stack>
            </Form>
        );
    }
}

export default UpdateForm;