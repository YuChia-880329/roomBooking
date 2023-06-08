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
                            <Form.Control as='select' value={value.value} onChange={this.onChange} disabled={value.disabled}>
                                {
                                    value.disabled ? 
                                            (<option value={-1}>----------------</option>) :
                                                    value.options.map(
                                                        op => (
                                                            <option key={op} value={op}>{op}</option>
                                                        )
                                                    )
                                }
                            </Form.Control>
                        </Col>
                        <Col xs='auto' className='align-self-center'>
                            <Button variant='outline-primary' size='sm' onClick={this.onClickChangeOrderBtn} disabled={value.disabled}>變更順序</Button>
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
    onClickChangeOrderBtn = (event) => {

        const {value, setter, getter, fctn} = this.props;

        fctn.showConfirmModal('確定更新照片順序 ? (更新送出前重整即可恢復)', () => {

            const currentImgIndex = getter.getRoomImage().options.reduce((a, c, i) => {

                if(a !== -1)
                    return a;
                else if(c.id === parseInt(getter.getRoomImage().value, 10))
                    return i;
                else
                    return -1;
            }, -1);
            const currentImg = getter.getRoomImage().options[currentImgIndex];
            const targetImgIndex = getter.getRoomImage().options.reduce((a, c, i) => {
    
                if(a !== -1)
                    return a;
                else if(c.order === parseInt(value.value, 10))
                    return i;
                else
                    return -1;
            }, -1);
            const targetImg = getter.getRoomImage().options[targetImgIndex];
    
            targetImg.order = currentImg.order;
            currentImg.order = parseInt(value.value, 10);
    
            const options = getter.getRoomImage().options.with(currentImgIndex, currentImg).with(targetImgIndex, targetImg);
            options.sort((img1, img2) => img1.order-img2.order);
            setter.setRoomImage({
                ...getter.getRoomImage(),
                options : options
            });
            fctn.closeConfirmModal();
        });
    }


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