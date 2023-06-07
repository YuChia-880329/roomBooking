import React, { Component } from 'react';
import { Col, Form, Row } from 'react-bootstrap';

const constant = {
    options : [
        {
            id : 1,
            name : '公開'
        },
        {
            id : 0,
            name : '不公開'
        }
    ]
}
class Status extends Component {

    render() {

        const {value} = this.props;
        
        return (
            <Form.Group as={Row}>
                <Form.Label column xs='auto'>房間狀態 : </Form.Label>
                <Form.Label column xs='auto'>
                    <Row xs='auto' className='g-3'>
                        {
                            constant.options.map(
                                op => (
                                    <Col key={op.id}>
                                        <Form.Check type='radio' label={op.name}
                                                checked={value.value === op.id}
                                                onChange={e => this.onChange(e, op.id)} />
                                    </Col>
                                )
                            )
                        }
                    </Row>
                </Form.Label>
            </Form.Group>
        );
    }

    // on
    onChange = (event, radioVal) => {

        this.setter('value', radioVal);
    }

    // setter
    setter = (colName, colVal, onSet) => {

        const {setter, value} = this.props;
        setter.setStatus({
            ...value,
            [colName] : colVal
        }, onSet);
    };
}

export default Status;