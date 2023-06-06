import React, { Component } from 'react';
import { Col, Form, Row } from 'react-bootstrap';

const constant = {
    status : {
        on : {
            code : 1,
            description : '公開'
        },
        off : {
            code : 0,
            description : '不公開'
        }
    }
};
class Status extends Component {

    render() {

        const {value} = this.props;
        const {status} = constant;

        return (
            <Form.Group as={Row}>
                <Form.Label column xs='auto'>房間狀態 : </Form.Label>
                <Form.Label column xs='auto'>
                    <Row xs='auto' className='g-3'>
                        <Col>
                            <Form.Check type='radio' label={status.on.description} value={status.on.code}
                                    checked={value.value===`${status.on.code}`} onChange={this.onChange} />
                        </Col>
                        <Col>
                            <Form.Check type='radio' label={status.off.description} value={status.off.code}
                                    checked={value.value===`${status.off.code}`} onChange={this.onChange} />
                        </Col>
                    </Row>
                </Form.Label>
                
            </Form.Group>
        );
    }

    // on
    onChange = (event) => {

        this.setter('value', event.target.value);
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