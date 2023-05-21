import React, { Component } from 'react';
import { Form, Row, Col, Button } from 'react-bootstrap';
import HorizontalFormInput from '../../../hoc/form/horizontal-form-input';
import CheckboxFormInput from '../../../hoc/form/checkbox-form-input';


class Feature extends Component {

    addCtrl = () => {

        return (
            <HorizontalFormInput text='新增選項' Ctrl={this.ctrlNew} />
        );
    };
    ctrlNew = () => {
        return (
            <Row>
                <Col xs='auto'>
                    <Form.Control  id='newFeature' htmlSize={15} />
                </Col>
                <Col xs='auto' className='align-self-center'>
                    <Button variant='outline-primary' size='sm'>+</Button>
                </Col>
            </Row>
        );
    };
    render() {

        const checks = ['房內免費Wi-Fi', '停車場', '可寄放行李', '房內免費Wi-Fi', 
                '停車場', '可寄放行李', '房內免費Wi-Fi', '停車場', '可寄放行李'];

        return (
            <CheckboxFormInput text='飯店特色' rowColsNum={4} checks={checks} AddCtrl={this.addCtrl} />
        );
    }
}

export default Feature;