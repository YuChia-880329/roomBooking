import '../../../css/custom.css';
import React, { Component, Fragment } from 'react';
import { Form, Row, Col, Button, Stack } from 'react-bootstrap';
import HorizontalFormInput from '../../../hoc/form/horizontal-form-input';
import CheckboxFormInput from '../../../hoc/form/checkbox-form-input';


class Feature extends Component {

    AddCtrl = () => {

        return (
            <Fragment>
                <this.NewCheckTable />
                <HorizontalFormInput id='form_newFeature' text='新增選項' Ctrl={this.CtrlNew} />
            </Fragment>
        );
    };
    CtrlNew = () => {
        
        return (
            <Row>
                <Col xs='auto'>
                    <Form.Control id='form_newFeature' htmlSize={15} />
                </Col>
                <Col xs='auto' className='align-self-center'>
                    <Button variant='outline-primary' size='sm'>+</Button>
                </Col>
            </Row>
        );
    };
    NewCheckTable = () => {

        const newChecks = ['房內免費Wi-Fi', '停車場',  '房內免費Wi-Fi', 
        '停車場', '可寄放行李', '可寄放行李', '房內免費Wi-Fi', '停車場', '可寄放行李'];

        // style
        const checkboxStyle = {
            margin : '0'
        };

        return (
            <Row xs={3}>
                {newChecks.map(
                    newCheck => (
                        <Col>
                            <Stack direction='horizontal' gap={4}>
                                <Form.Check type='checkbox' label={newCheck} style={checkboxStyle} />
                                <div>
                                    <Button variant='outline-primary' size='sm' className='little-btn'>-</Button>
                                </div>
                            </Stack>
                        </Col>
                    )
                )}
            </Row>
        );
    };

    render() {

        const checks = ['房內免費Wi-Fi', '停車場', '可寄放行李', '房內免費Wi-Fi', 
                '停車場', '可寄放行李', '房內免費Wi-Fi', '停車場', '可寄放行李'];

        return (
            <Fragment>
                <CheckboxFormInput text='飯店特色' rowColsNum={4} checks={checks} AddCtrl={this.AddCtrl} />
            </Fragment>
            
        );
    }
}

export default Feature;