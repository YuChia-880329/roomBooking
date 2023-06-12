import React, { Component } from 'react';
import { Container } from 'react-bootstrap';

class FrontendMain extends Component {

    render() {

        const {Content} = this.props;
        const containerStyle = {
            marginTop : '10rem'
        };

        return (
            <Container className='mb-5' style={containerStyle}>
                <Content />
            </Container>
        );
    }
}

export default FrontendMain;