import houseIcon from '../../image/house-icon.png';
import React, { Component, Fragment } from 'react';
import { Col, Image, Row, Stack } from 'react-bootstrap';
import FrontendMain from '../../hoc/frontend-main';
import FilterForm from './home/filter-form';
import Hotels from './home/hotels';
import Pagn from '../../hoc/pagn';

class Home extends Component {

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
                <Row className='justify-content-center pb-5'>
                    <Col xs='auto' className='align-self-center'>
                        <Image src={houseIcon} style={homeIconStyle} />
                    </Col>
                    <Col xs={8}>
                        <FilterForm />
                    </Col>
                </Row>
                <div className='py-5'>
                    <Hotels />
                </div>
                <Stack direction='horizontal'>
                    <div className='ms-auto'>
                        <Pagn pagn={pagination} />
                    </div>
                </Stack>
            </Fragment>
        );
    };
}

export default Home;