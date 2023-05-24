import React, { Component } from 'react';
import { Button, Col, Row, Stack } from 'react-bootstrap';
import Name from './create_form/name';
import TotalNum from './create_form/total-num';
import InvalidNum from './create_form/invalid-num';
import Price from './create_form/price';
import SingleBedNum from './create_form/single-bed-num';
import DoubleBedNum from './create_form/double-bed-num';
import Area from './create_form/area';
import Scene from './create_form/scene';
import Shower from './create_form/shower';
import NewImage from './create_form/new-image'


class CreateForm extends Component {
    
    render() {

        return (
            <Stack gap={5}>
                <Row>
                    <Col>
                        <Name />
                    </Col>
                    <Col>
                        <TotalNum />
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
                <NewImage />
                <Stack direction='horizontal'>
                    <Button variant='outline-primary' className='ms-auto'>新增房型</Button>
                </Stack>
            </Stack>
        );
    }
}

export default CreateForm;