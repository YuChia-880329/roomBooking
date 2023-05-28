import React, { Component } from 'react';
import { Button, Col, Form, Row } from 'react-bootstrap';

class ImageOrder extends Component {

    Ctrl = () => {

        return (
            <Row>
                <Col>
                    <Form.Select>
                        <option>--------</option>
                        <option>2</option>
                        <option>3</option>
                        <option>4</option>
                        <option>5</option>
                    </Form.Select>
                </Col>
                <Col xs='auto' className='align-self-center'>
                    <Button variant='outline-primary' size='sm'>變更順序</Button>
                </Col>
            </Row>
            
        );
    };
 
    render() {
        
        return (
            <Form.Group as={Row}>
                <Form.Label column xs='auto'>照片順序 : </Form.Label>
                <Col>
                    <Row>
                        <Col>
                            <Form.Select>
                                <option>--------</option>
                                <option>2</option>
                                <option>3</option>
                                <option>4</option>
                                <option>5</option>
                            </Form.Select>
                        </Col>
                        <Col xs='auto' className='align-self-center'>
                            <Button variant='outline-primary' size='sm'>變更順序</Button>
                        </Col>
                    </Row>
                </Col>
            </Form.Group>
        );
    }
}

export default ImageOrder;