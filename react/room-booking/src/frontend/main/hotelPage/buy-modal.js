import urls from '../../../files/urls.json';
import config from '../../../files/config.json';
import React, { Component, createRef } from 'react';
import { Button, Container, Form, Modal, Stack } from 'react-bootstrap';
import Date from './buyModal/date';
import CheckinTime from './buyModal/checkin-time';
import Num from './buyModal/num';
import axios from 'axios';


const constant = {
    fetch : {
        url : {
            addShoppingCart : urls.frontend.hotelPage.addShoppingCart
        },
        config : {
            timeout : config.fetch.timeout
        },
        req : {
            addShoppingCart : {
                roomId : 0,
                checkinDate : "",
                checkoutDate : "",
                checkinTime : "",
                num : 0,
                price : 0
            }
        }
    }
}


class BuyModal extends Component {

    buyModalFormRef = createRef();

    render() {

        const setter = {
            date : {
                setDate : (colVal, onSet) => this.setter('date', colVal, onSet)
            },
            checkinTime : {
                setCheckinTime : (colVal, onSet) => this.setter('checkinTime', colVal, onSet)
            },
            num : {
                setNum : (colVal, onSet) => this.setter('num', colVal, onSet)
            }
        };
        const getter = {
            date : {
                getDate : () => this.getter('date')
            },
            checkinTime : {
                getCheckinTime : () => this.getter('checkinTime')
            },
            num : {
                getNum : () => this.getter('num')
            }
        };
        return (
            <Modal show={this.getter('show')} onHide={this.getter('onHide')}>
                <Modal.Header closeButton>
                    <Modal.Title>加入購物車</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    <Container className='my-2'>
                        <Form noValidate validated={this.getter('validated')} ref={this.buyModalFormRef}>
                            <Stack gap={4}>
                                <h1 className='fw-bold'>{this.getter('hotelName')}</h1>
                                <Stack direction='horizontal' className='ms-2 justify-content-between'>
                                    <p className='fs-3'>{this.getter('roomName')}</p>
                                    <p className='fs-5 text-secondary'>
                                        剩餘 <span>{this.getter('validNum')}</span> 間
                                    </p>
                                    <p className='fs-5 text-danger'>
                                        $ <span>{this.getter('price')}</span> 元 / 間
                                    </p>
                                </Stack>
                                <div className='ms-2'>
                                    <Date setter={setter.date} getter={getter.date} />
                                </div>
                                <div className='ms-2'>
                                    <CheckinTime setter={setter.checkinTime} getter={getter.checkinTime} />
                                </div>
                                <div className='ms-2'>
                                    <Num setter={setter.num} getter={getter.num} />
                                </div>
                            </Stack>
                        </Form>
                    </Container>
                </Modal.Body>
                <Modal.Footer>
                    <Button variant="secondary" onClick={this.getter('onHide')}>取消</Button>
                    <Button variant="primary" onClick={this.getter('onClickOkBtn')}>確認</Button>
                </Modal.Footer>
            </Modal>
        );
    }


    // other
    addShoppingCart = () => {

        const req = constant.fetch.req.addShoppingCart;

        req.roomId = this.getter('roomId');
        req.checkinDate = this.getter('date').valueCheckinDate;
        req.checkoutDate = this.getter('date').valueCheckoutDate;
        req.checkinTime = this.getter('checkinTime').value;
        req.num = this.getter('num').value;
        req.price = this.getter('price');
        this.addShoppingCartFetch(req);
    }
    submit = () => {

        const {fctn} = this.props;

        this.setter('validated', true, () => {

            if(this.buyModalFormRef.current.checkValidity() === true){
    
                if(this.getter('validNum') >= this.getter('num').value){

                    fctn.showConfirmModal('確定要新增至購物車 ? ', () => {

                        fctn.closeConfirmModal();
                        this.addShoppingCart();
                    });
                }else {

                    fctn.showInformModal('加入數量不可高於剩餘數量');
                }
            }
        });
    }



    // fetch
    addShoppingCartFetch = async (req) => {

        const {fctn} = this.props;
        const {fetch} =  constant;
        const url = fetch.url.addShoppingCart;
        const config = fetch.config;

        const {serverInfo, data} = await axios.post(url, req, {
                timeout : config.timeout,
                withCredentials: true
            })
            .then(rs => rs.data)
            .catch(error => console.error(error));

        const statusCode = serverInfo.statusCode;
        if(statusCode === 200){

            this.afterAddShoppingCart(data);
        }else if(statusCode===400 || statusCode===500){

            fctn.showInformModal(serverInfo.msg);
        }
    };


    // after fetch
    afterAddShoppingCart = (data) => {

        const {fctn} = this.props;
        
        if(data.success){
            this.setter('validated', false, () => {

                this.setter('checkinTime', {
                    ...this.getter('checkinTime'),
                    value : ''
                }, () => {

                    this.setter('show', false, () => {

                        fctn.showInformModal(data.msg);
                    });
                });
            });
        }else {

            fctn.showInformModal(data.msg);
        }
    }


    // setter getter
    setter = (colName, colVal, onSet) => {

        const {setter, getter} = this.props;

        setter.setBuyModal({
            ...getter.getBuyModal(),
            [colName] : colVal
        }, onSet);
    };
    getter = (colName) => {

        const {getter} = this.props;
        return getter.getBuyModal()[colName];
    }
}

export default BuyModal;