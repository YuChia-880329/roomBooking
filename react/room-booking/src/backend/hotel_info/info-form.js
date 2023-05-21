import React, { Component } from 'react';
import { Button, Col, Form, Row, Stack } from 'react-bootstrap';
import Name from './info_form/name';
import Address from './info_form/address';
import Section from './info_form/section';
import Description from './info_form/description';
import Feature from './info_form/feature';
import HotelImage from './info_form/hotel-image';
import UpdateImage from './info_form/update-image';

class InfoForm extends Component {

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
                        <Section />
                    </Col>
                </Row>
                <div style={formRowStyle}>
                    <Address />
                </div>
                <div style={formRowStyle}>
                    <Description />
                </div>
                <div style={formRowStyle}>
                    <Feature />
                </div>
                <div style={formRowStyle}>
                    <HotelImage />
                </div>
                <div style={formRowStyle}>
                    <UpdateImage />
                </div>
                <Stack direction='horizontal' style={formRowStyle}>
                    <Button variant='outline-primary' className='ms-auto'>更新資料</Button>
                </Stack>
            </Form>
        );
    }
}

export default InfoForm;