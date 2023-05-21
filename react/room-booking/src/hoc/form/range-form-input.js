import React, { Component } from 'react';
import { Col, Form, Row } from 'react-bootstrap';
import HorizontalFormInput from './horizontal-form-input';


class RangeFormInput extends Component {

    ctrl = () => {

        // props
        const {type, min1, min2} = this.props;

        return (
            <Row>
                <Col>
                    <Form.Control id={this.props.id1} type={type} min={min1}  />
                </Col>
                <Col xs='auto' className='px-3 align-self-center'>
                    <p className='mb-0'>~</p>
                </Col>
                <Col>
                    <Form.Control id={this.props.id2} type={type} min={min2}  />
                </Col>
            </Row>
        );
    };
    render() {

        // props
        const {id1, text, AddCtrl} = this.props;

        return (
            <HorizontalFormInput id={id1} text={text} Ctrl={this.ctrl} AddCtrl={AddCtrl} />
        );
    }
}

export default RangeFormInput;