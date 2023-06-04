import React, { Component } from 'react';
import { Col, Form, Row } from 'react-bootstrap';


class Section extends Component {

    render() {

        const {fctn, value, onChange} = this.props;

        return (
            <Form.Group as={Row}>
                <Form.Label column xs='auto'>飯店地址區域 : </Form.Label>
                <Col>
                    <Form.Control as='select' value={value} onChange={onChange}>
                        <option value=''>---- 請選擇 ----</option>
                        {fctn.getAllSections().map(
                            section => (
                                <option key={section.code} value={section.code}>{section.name}</option>
                            )
                        )}
                    </Form.Control>
                </Col>
            </Form.Group>
        );
    }
}

export default Section;