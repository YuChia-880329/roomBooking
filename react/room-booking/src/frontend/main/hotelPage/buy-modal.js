import React, { Component } from 'react';
import { Button, Container, Modal, Stack } from 'react-bootstrap';
import Date from './buyModal/date';
import CheckinTime from './buyModal/checkin-time';
import Num from './buyModal/num';

class BuyModal extends Component {

    render() {

        return (
            <Modal show={false} onHide={() => {}}>
                <Modal.Header closeButton>
                    <Modal.Title>加入購物車</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    <Container className='my-2'>
                        <Stack gap={4}>
                            <h1 className='fw-bold'>XXX飯店</h1>
                            <Stack direction='horizontal' className='ms-2 justify-content-between'>
                                <p className='fs-3'>標準雙人床</p>
                                <p className='fs-5 text-secondary'>
                                    剩餘 <span>3</span> 間
                                </p>
                                <p className='fs-5 text-danger'>
                                    $ <span>1000</span> 元 / 間
                                </p>
                            </Stack>
                            <div className='ms-2'>
                                <Date />
                            </div>
                            <div className='ms-2'>
                                <CheckinTime />
                            </div>
                            <div className='ms-2'>
                                <Num />
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
}

export default BuyModal;