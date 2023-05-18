import React, { Component } from 'react';
import '../css/backend/nav-bar.css'
import { Container, Navbar, Nav, Button } from 'react-bootstrap';
import LocalRouter from './local-router';

class navBar extends Component {
    render() {
        return (
            <Navbar className='navbar-dark bg-secondary bg-gradient' expand='lg' collapseOnSelect>
                <Container fluid>
                    <Navbar.Brand className='local-navBar-brand'>
                        歡迎<span>XXX飯店</span>
                    </Navbar.Brand>
                    <Navbar.Toggle />
                    <Navbar.Collapse>
                        <LocalRouter className='me-auto' />
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

export default navBar;