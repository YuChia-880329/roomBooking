import React, { Component } from 'react';
import { Col, Form, Row } from 'react-bootstrap';

class Scene extends Component {

    render() {

        const {value} = this.props;

        return (
            <Form.Group as={Row}>
                <Form.Label column xs='auto'>景觀 : </Form.Label>
                <Col>
                    <Form.Control as='select' value={value.value} onChange={this.onChange} disabled={value.disabled}>
                        {
                            value.disabled ? 
                                    (<option value={-1}>----------------</option>) : 
                                            value.options.map(
                                                op => (
                                                    <option key={op.id} value={op.id}>{op.name}</option>
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


    // setter
    setter = (colName, colVal, onSet) => {

        const {setter, value} = this.props;
        setter.setScene({
            ...value,
            [colName] : colVal
        }, onSet);
    };
}

export default Scene;