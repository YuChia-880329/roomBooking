import React, { Component } from 'react';
import { Button, Form, Stack } from 'react-bootstrap';
import Name from './local_form/name';
import Address from './local_form/address';
import Section from './local_form/section';
import Description from './local_form/description';
import Feature from './local_form/feature';
import LocalImage from './local_form/local-image';
import UpdateImage from './local_form/update-image';

class LocalForm extends Component {

    render() {

        // style
        const borderStyle = {
            padding : '4.5rem 4.5rem 2rem'
        };
        const formGroupStyle = {
            marginTop : '3rem'
        };

        return (
            <div className='border border-2 border-secondary rounded-4 rounded' style={borderStyle}>
                <Form>
                    <div>
                        <Name />
                    </div>
                    <div style={formGroupStyle}>
                        <Address />
                    </div>
                    <div style={formGroupStyle}>
                        <Section />
                    </div>
                    <div style={formGroupStyle}>
                        <Description />
                    </div>
                    <div style={formGroupStyle}>
                        <Feature />
                    </div>
                    <div style={formGroupStyle}>
                        <LocalImage />
                    </div>
                    <div style={formGroupStyle}>
                        <UpdateImage />
                    </div>
                    <Stack direction='horizontal' style={formGroupStyle}>
                        <Button variant='outline-primary' className='ms-auto'>更新資料</Button>
                    </Stack>
                </Form>
            </div>
        );
    }
}

export default LocalForm;