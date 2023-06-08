import React, { Component } from 'react';
import { Col, Form, Row } from 'react-bootstrap';

class Shower extends Component {

    render() {

        const {value} = this.props;

        return (
            <Form.Group as={Row}>
                <Form.Label column xs='auto'>沐浴設備 : </Form.Label>
                <Form.Label column xs='auto'>
                    <Row xs='auto' className='g-3'>
                        {
                            value.options.map(
                                op => (
                                    <Col key={op.id}>
                                        <Form.Check type='checkbox' label={op.name}
                                                checked={value.values.includes(op.id)}
                                                onChange={e => this.onChange(e, op.id)}
                                                disabled={value.disabled} />
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
    onChange = (event, checkBoxVal) => {

        const {value} = this.props;
        let newValues;

        if(event.target.checked)
            newValues = [...value.values, checkBoxVal];
        else
            newValues = value.values.filter(v => v!==checkBoxVal);

        this.setter('values', newValues);
    }

    // setter
    setter = (colName, colVal, onSet) => {

        const {setter, value} = this.props;
        setter.setShower({
            ...value,
            [colName] : colVal
        }, onSet);
    };
}

export default Shower;