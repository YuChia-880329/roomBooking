import React, { Component } from 'react';
import { Button, Col, Form, Row, Stack } from 'react-bootstrap';

class ShoppingCartForm extends Component {

    render() {

        return (
            <Form className='mt-5' noValidate validated={this.getter('validated')} onSubmit={this.onSubmit}>
                <Stack direction='horizontal' className='justify-content-center'>
                    <Form.Group as={Row}>
                        <Form.Label column xs='auto' htmlFor='room_num'>數量 : </Form.Label>
                        <Col xs='auto'>
                            <Form.Control id='room_num' type='number' min={0} 
                                    value={this.getter('value')} onChange={this.onChange} required />
                            <Form.Control.Feedback type='invalid'>請輸入數量</Form.Control.Feedback>
                        </Col>
                        <Col xs='auto'>
                            <Button type='send' variant='outline-primary'>加入購物車</Button>
                        </Col>
                    </Form.Group>
                </Stack>
            </Form>
        );
    }


    // on
    onChange = (event) => {

        this.setter('value', event.target.value);
    };
    onSubmit = (event) => {

        const {fctn} = this.props;

        event.preventDefault();
        this.setter('validated', true, () => {

            if(event.target.checkValidity() === true){
    
                this.setter('validated', false, () => {

                    fctn.setBuyModal(this.getter('value'), () => {

                        fctn.showBuyModal((event) => {

                            fctn.submitBuyModal();
                        });
                    });
                });
            }
        });
    };


    // setter getter
    setter = (colName, colVal, onSet) => {

        const {setter, getter} = this.props;

        setter.setShoppingCartForm({
            ...getter.getShoppingCartForm(),
            [colName] : colVal
        }, onSet);
    };
    getter = (colName) => {

        const {getter} = this.props;
        return getter.getShoppingCartForm()[colName];
    }
}

export default ShoppingCartForm;