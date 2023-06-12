import React, { Component } from 'react';
import { Col, Container, Row } from 'react-bootstrap';
import Room from './rooms/room';

class Rooms extends Component {

    render() {

        const containerStyle = {
            width : '85%'
        };
        return (
            <Container style={containerStyle}>
                <Row xs={1} className='g-4'>
                    <Col>
                        <Room />
                    </Col>
                    <Col>
                        <Room />
                    </Col>
                    <Col>
                        <Room />
                    </Col>
                </Row>
            </Container>
        );
    }
}

export default Rooms;