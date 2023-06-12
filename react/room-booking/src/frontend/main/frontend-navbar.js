import React, { Component } from 'react';
import { Container, Navbar, Nav, Button, Form, Row, Col } from 'react-bootstrap';


class FrontendNavbar extends Component {
    
    render() {

        // style
        const brandStyle = {
            fontSize : '2rem'
        };

        return (
            <Navbar className='navbar-dark bg-secondary bg-gradient' expand='lg' fixed='top' collapseOnSelect>
                <Container fluid className='px-5'>
                    <Navbar.Brand as={Nav.Link} style={brandStyle}>
                        訂房網
                    </Navbar.Brand>
                    <Navbar.Toggle />
                    <Navbar.Collapse>
                        <Nav className='me-auto'>
                            <Form>
                                <Form.Group as={Row}>
                                    <Col>
                                        <Form.Control htmlSize={50} />
                                    </Col>
                                    <Col className='ms-1'>
                                        <Button variant='outline-light'>搜尋飯店</Button>
                                    </Col>
                                </Form.Group>
                            </Form>
                        </Nav>
                        {/* <Nav>
                            <Nav.Link>
                                <Button variant='outline-light'>登入</Button>
                            </Nav.Link>
                            <Nav.Link>
                                <Button variant='outline-light'>註冊</Button>
                            </Nav.Link>
                        </Nav> */}
                        <Navbar.Text className='me-3 fs-2'>
                            歡迎 <span>Joe</span>
                        </Navbar.Text>
                        <Nav>
                            <Nav.Link>
                                <Button variant='outline-light'>前往購物車</Button>
                            </Nav.Link>
                            <Nav.Link>
                                <Button variant='outline-light'>登出</Button>
                            </Nav.Link>
                        </Nav>
                    </Navbar.Collapse>
                </Container>
            </Navbar>
        );
    }
}

export default FrontendNavbar;