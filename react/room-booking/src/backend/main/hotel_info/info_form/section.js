import React, { Component } from 'react';
import { Col, Form, Row } from 'react-bootstrap';


class Section extends Component {

    render() {

        const {value} = this.props;

        return (
            <Form.Group as={Row}>
                <Form.Label column xs='auto'>飯店地址區域 : </Form.Label>
                <Col>
                    <Form.Control as='select' value={value.value} onChange={this.onChange}>
                        <option value=''>---- 請選擇 ----</option>
                        {value.options.map(
                            op => (
                                <option key={op.code} value={op.code}>{op.name}</option>
                            )
                        )}
                    </Form.Control>
                </Col>
            </Form.Group>
        );
    }

    // on
    onChange = (event) => {

        this.setter('value', `${event.target.value}`);
    };


    // setter
    setter = (colName, colVal, onSet) => {

        const {setter, value} = this.props;
        setter.setSection({
            ...value,
            [colName] : colVal
        }, onSet);
    };
}

export default Section;