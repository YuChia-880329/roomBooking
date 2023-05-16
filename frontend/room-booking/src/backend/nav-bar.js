import React, { Component } from 'react';
import '../css/backend/nav-bar.css'
import { Container, Stack } from 'react-bootstrap';

class navBar extends Component {
    render() {
        return (
            <div>
                <Container className='ctner' fluid={true}>
                    <Stack className='justify-content-end' direction='horizontal'>
                        <p className='me-4 fs-5 py-3 text-muted'>
					        歡迎<span>XXX飯店</span>
				        </p>
                        <p className='me-4 fs-5 py-3'>
                            <a className='link-secondary' href='#'>登出</a>
                        </p>
                    </Stack>
                </Container>
            </div>
        );
    }
}

export default navBar;