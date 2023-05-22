import React, { Component } from 'react';
import { Container } from 'react-bootstrap';
import BorderForm from '../hoc/form/border-form';
import InfoForm from './hotel_info/info-form';
import BackendHoc from '../hoc/backend-hoc';

class HotelInfo extends Component {

    Content = () => {

        return (
            <Container className='w-75'>
                <BorderForm Content={InfoForm}/>
            </Container>
        );
    };
    render() {
        
        return (
            <BackendHoc titleText='飯店資料' Content={this.Content} />
        );
    }
}

export default HotelInfo;