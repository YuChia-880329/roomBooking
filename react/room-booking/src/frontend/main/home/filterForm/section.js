import React, { Component } from 'react';
import { Col, Form, Row } from 'react-bootstrap';

class Section extends Component {

    render() {

        return (
            <Form.Group as={Row}>
                <Form.Label column xs='auto'>地區 : </Form.Label>
                <Col>
                    <Form.Control as='select' value={this.getter('value')} onChange={this.onChange}>
                        {
                            this.getter('options').map(
                                op => (
                                    <option key={op.code} value={op.code}>{op.name}</option>
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

        setter.setSection({
            ...getter.getSection(),
            [colName] : colVal
        }, onSet);
    };
    getter = (colName) => {

        const {getter} = this.props;
        return getter.getSection()[colName];
    }
}

export default Section;