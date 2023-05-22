import React, { Component } from 'react';
import { Container, Navbar, Nav, Button } from 'react-bootstrap';
import { Link } from 'react-router-dom';

class BackendNavbar extends Component {

    state = {
        hotelName : 'XXX飯店'
    }

    render() {

        // state
        const {hotelName} = this.state;

        // style
        const brandStyle = {
            fontSize : '2rem'
        };

        return (
            <Navbar className='navbar-dark bg-secondary bg-gradient' expand='lg' fixed='top' collapseOnSelect>
                <Container fluid className='px-5'>
                    <Navbar.Brand style={brandStyle}>
                        歡迎<span>{hotelName}</span>
                    </Navbar.Brand>
                    <Navbar.Toggle />
                    <Navbar.Collapse>
                        <Nav className='me-auto'>
                            <Nav.Link as={Link} to='/hotelInfo'>飯店資料</Nav.Link>
                            <Nav.Link as={Link} to='/roomList'>房型列表</Nav.Link>
                            <Nav.Link as={Link} to='/roomUpdate'>房型更新</Nav.Link>
                            <Nav.Link as={Link} to='/roomCreate'>新增房型</Nav.Link>
                            <Nav.Link as={Link} to='/orderList'>訂房訂單</Nav.Link>
                            <Nav.Link>前端頁面</Nav.Link>
                        </Nav>
                        <Nav>
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

export default BackendNavbar;