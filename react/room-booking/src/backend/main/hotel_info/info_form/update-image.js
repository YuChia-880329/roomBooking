import React, { Component } from 'react';
import { Form, Row, Col } from 'react-bootstrap';

class UpdateImage extends Component {

    render() {
        
        const {value} = this.props;

        return (
            <Form.Group as={Row}>
                <Form.Label column xs='auto' htmlFor='form_updateImage'>更新照片 : </Form.Label>
                <Col>
                    <Row>
                        <Col xs='auto'>
                            <Form.Control id='form_updateImage' name='hotelImage' type='file' 
                                    value={value.imgName} onChange={this.onChange} />
                        </Col>
                    </Row>
                </Col>
            </Form.Group>
        );
    }

    // on
    onChange = (event) => {

        this.setter('imageName', event.target.value);
    };


    // setter
    setter = (colName, colVal, onSet) => {

        const {setter, value} = this.props;
        setter.setUpdateImage({
            ...value,
            [colName] : colVal
        }, onSet);
    };
}

export default UpdateImage;