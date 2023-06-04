import React, { Component } from 'react';
import { Col, Form, Row } from 'react-bootstrap';


class RoomType extends Component {

    render() {
        
        const {value, onChange, fctn} = this.props;

        return (
            <Form.Group as={Row}>
                <Form.Label column xs='auto'>預定房型 : </Form.Label>
                <Col>
                    <Form.Control as='select' value={value} onChange={onChange}>
                        <option value=''>--- 請選擇 ---</option>
                        {
                            fctn.getAllRooms().map(
                                room => (
                                    <option key={room.id} value={room.id}>{room.name}</option>
                                )
                            )
                        }
                    </Form.Control>
                </Col>
            </Form.Group>
        );
    }
}

export default RoomType;