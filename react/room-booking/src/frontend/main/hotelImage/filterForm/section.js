import React, { Component } from 'react';
import { Col, Form, Row } from 'react-bootstrap';

const constant = {
    options : [
        '台北', '台中', '高雄'
    ]
}

class Section extends Component {

    render() {

        return (
            <Form.Group as={Row}>
                <Form.Label column xs='auto'>地區 : </Form.Label>
                <Col>
                    <Form.Control as='select' value={1} disabled>
                        {
                            constant.options.map(
                                op => (
                                    <option key={op} value={op}>{op}</option>
                                )
                            )          
                        }
                    </Form.Control>
                </Col>
            </Form.Group>
        );
    }
}

export default Section;