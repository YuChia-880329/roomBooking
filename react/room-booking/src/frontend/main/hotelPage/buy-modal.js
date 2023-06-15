import React, { Component } from 'react';
import { Button, Container, Modal, Stack } from 'react-bootstrap';
import Date from './buyModal/date';
import CheckinTime from './buyModal/checkin-time';
import Num from './buyModal/num';

class BuyModal extends Component {

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
                    </Container>
                </Modal.Body>
                <Modal.Footer>
                    <Button variant="secondary">取消</Button>
                    <Button variant="primary">確認</Button>
                </Modal.Footer>
            </Modal>
        );
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