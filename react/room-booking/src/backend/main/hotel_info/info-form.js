import React, { Component } from 'react';
import { Button, Col, Row, Stack } from 'react-bootstrap';
import Name from './info_form/name';
import Address from './info_form/address';
import Section from './info_form/section';
import Description from './info_form/description';
import Feature from './info_form/feature';
import HotelImage from './info_form/hotel-image';
import UpdateImage from './info_form/update-image';

class InfoForm extends Component {

    render() {

        return (
            <Stack gap={5}>
                <Row>
                    <Col>
                        <Name />
                    </Col>
                    <Col>
                        <Section />
                    </Col>
                </Row>
                <Address />
                <Description />
                <Feature />
                <HotelImage />
                <UpdateImage />
                <Stack direction='horizontal'>
                    <Button variant='outline-primary' className='ms-auto'>更新資料</Button>
                </Stack>
            </Stack>
        );
    }
}

export default InfoForm;