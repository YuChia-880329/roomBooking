import houseIcon from '../../image/house-icon.png';
import React, { Component, Fragment } from 'react';
import { Col, Image, Row, Stack } from 'react-bootstrap';
import FilterForm from './hotelImage/filter-form';
import FrontendMain from '../../hoc/frontend-main';
import Introduction from './hotelImage/introduction';
import Rooms from './hotelImage/rooms';
import Pagn from '../../hoc/pagn';

class HotelPage extends Component {

    constructor(props){

        super(props);
        this.state = {
            pagination : {
                first : {
                    show : true,
                    toPage : 1
                },
                prev : {
                    show : true,
                    toPage : 1
                },
                pages : [1, 2, 3],
                next : {
                    show : true,
                    toPage : 3
                },
                last : {
                    show : true,
                    toPage : 3 
                },
                currentPage : 2
            }
        };
    }

    render() {

        return (
            <FrontendMain Content={this.Content} />
        );
    }

    // jsx
    Content = () => {

        const homeIconStyle = {
            width : '16rem',
            height : '16rem'
        };
        const{pagination} = this.state;

        return (
            <Fragment>
                <Row className='justify-content-center'>
                    <Col xs='auto' className='align-self-center'>
                        <Image src={houseIcon} style={homeIconStyle} />
                    </Col>
                    <Col xs={8}>
                        <FilterForm />
                    </Col>
                </Row>
                <div className='mt-5'>
                    <Introduction />
                </div>
                <div className='my-5 pt-5'>
                    <Rooms />
                </div>
                <Stack direction='horizontal'>
                    <div className='ms-auto'>
                        <Pagn pagn={pagination} />
                    </div>
                </Stack>
            </Fragment>
        );
    }
}

export default HotelPage;