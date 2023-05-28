import React, { Component } from 'react';
import { Container } from 'react-bootstrap';
import BorderForm from '../../hoc/form/border-form';
import InfoForm from './hotel_info/info-form';
import BackendMain from '../../hoc/backend-main';

class HotelInfo extends Component {

    
    render() {
        
        return (
            <BackendMain titleText='飯店資料' Content={this.Content} />
        );
    }

    // jsx
    Content = () => {

        return (
            <Container className='w-75'>
                <BorderForm Content={InfoForm}/>
            </Container>
        );
    };
}

export default HotelInfo;