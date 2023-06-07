import React, { Component } from 'react';
import { Button, Col, Form, Row } from 'react-bootstrap';

class ImageOrder extends Component {
 
    render() {
        
        const {value} = this.props;
        
        return (
            <Form.Group as={Row}>
                <Form.Label column xs='auto'>照片順序 : </Form.Label>
                <Col>
                    <Row>
                        <Col>
                            <Form.Control as='select' value={value.value} onChange={this.onChange}>
                                <option value=''>---- 請選擇 ----</option>
                                {
                                    value.options.map(
                                        op => (
                                            <option key={op.order} value={op.order}>{op.order}</option>
                                        )
                                    )
                                }
                            </Form.Control>
                        </Col>
                        <Col xs='auto' className='align-self-center'>
                            <Button variant='outline-primary' size='sm'>變更順序</Button>
                        </Col>
                    </Row>
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
        setter.setImageOrder({
            ...value,
            [colName] : colVal
        }, onSet);
    };
}

export default ImageOrder;