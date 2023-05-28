import React, { Component } from 'react';
import { Container } from 'react-bootstrap';

class BackendHoc extends Component {
    
    render() {

        const {titleText, Content} = this.props;
        const containerStyle = {
            marginTop : '10rem'
        };
        const titleStyle = {
            marginBottom : '4rem'
        };

        return (
            <Container className='mb-5' style={containerStyle}>
                <div className='border-bottom border-2 text-secondary pb-3' style={titleStyle}>
                    <h2>{titleText}</h2>
                </div>
                <Content />
            </Container>
        );
    }
}

export default BackendHoc;