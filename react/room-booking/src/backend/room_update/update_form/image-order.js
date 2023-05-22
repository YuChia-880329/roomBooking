import React, { Component } from 'react';
import { Button, Col, Form, Row } from 'react-bootstrap';
import HorizontalFormInput from '../../../hoc/form/horizontal-form-input';

class ImageOrder extends Component {

 
    render() {
        return (
            <HorizontalFormInput text='照片順序' Ctrl={this.Ctrl} />
        );
    }

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
}

export default ImageOrder;