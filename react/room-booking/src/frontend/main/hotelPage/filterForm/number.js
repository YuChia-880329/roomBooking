import React, { Component } from 'react';
import { Col, Form, Row } from 'react-bootstrap';

const constant = {
    options : [
        {
            code : 1,
            description : '1人'
        },
        {
            code : 2,
            description : '2人'
        },
        {
            code : 3,
            description : '3人'
        },
        {
            code : 4,
            description : '4人'
        },
        {
            code : 5,
            description : '5人'
        },
        {
            code : 6,
            description : '6人'
        },
        {
            code : 7,
            description : '7人'
        },
        {
            code : 8,
            description : '8人以上'
        }
    ]
}
class Number extends Component {

    render() {

        return (
            <Form.Group as={Row}>
                <Form.Label column xs='auto'>人數 : </Form.Label>
                <Col>
                    <Form.Control as='select' value={this.getter('value')} onChange={this.onChange}>
                        {
                            constant.options.map(
                                op => (
                                    <option key={op.code} value={op.code}>{op.description}</option>
                                )
                            )          
                        }
                    </Form.Control>
                </Col>
            </Form.Group>
        );
    }


    // on
    onChange = (event) => {

        this.setter('value', event.target.value);
    };

    // setter getter
    setter = (colName, colVal, onSet) => {

        const {setter, getter} = this.props;

        setter.setNumber({
            ...getter.getNumber(),
            [colName] : colVal
        }, onSet);
    };
    getter = (colName) => {

        const {getter} = this.props;
        return getter.getNumber()[colName];
    }
}

export default Number;