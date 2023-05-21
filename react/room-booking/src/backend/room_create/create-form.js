import React, { Component } from 'react';
import { Button, Col, Form, Row, Stack } from 'react-bootstrap';
import Name from './create_form/name';
import TotalNumber from './create_form/total-number';
import InvalidNumber from './create_form/invalid-number';
import Price from './create_form/price';
import SingleBedNumber from './create_form/single-bed-number';
import DoubleBedNumber from './create_form/double-bed-number';
import Area from './create_form/area';
import Scene from './create_form/scene';
import Shower from './create_form/shower';
import NewImage from './create_form/new-image'


class CreateForm extends Component {
    render() {

        // style
        const formRowStyle = {
            marginTop : '3rem'
        };

        return (
            <Form>
                <Row>
                    <Col>
                        <Name />
                    </Col>
                    <Col>
                        <TotalNumber />
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
                        <NewImage />
                    </Col>
                </Row>
                <Stack direction='horizontal' style={formRowStyle}>
                    <Button variant='outline-primary' className='ms-auto'>新增房型</Button>
                </Stack>
            </Form>
        );
    }
}

export default CreateForm;