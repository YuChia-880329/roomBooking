import urls from '../../../../files/urls.json';
import config from '../../../../files/config.json';
import '../../../../css/custom.css';
import React, { Component } from 'react';
import { Form, Row, Col, Button, Stack } from 'react-bootstrap';
import axios from 'axios';

const constant = {
    fetch : {
        url : {
            allFeatures : urls.backend.hotelInfo.allFeatures,
            checkNewHotelFeature : urls.backend.hotelInfo.checkNewHotelFeature
        },
        config : {
            timeout : config.fetch.timeout
        },
        req : {
            checkNewHotelFeature : {
                name : ''
            }
        }
    }
}
class Feature extends Component {

    constructor(props){

        super(props);
        this.state = {
            hotelFeatures : [],
            newHotelFeatures : []
        };
    }

    componentDidMount(){

        this.getAllHotelInfos();
    }
    render() {

        const rowStyle = {
            paddingTop : 'calc(.375rem + 1px)'
        };
        const checkboxStyle = {
            margin : '0'
        };

        const {hotelFeatures, newHotelFeatures} = this.state;

        return (
            <Form.Group as={Row}>
                <Form.Label column xs='auto' htmlFor='form_description'>飯店特色 : </Form.Label>
                <Col>
                    <Stack gap={5}>
                        <Row xs={4} className='g-3' style={rowStyle}>
                            {
                                hotelFeatures.map(hotelFeature => (
                                    <Col key={hotelFeature.id}>
                                        <Form.Check type='checkbox' label={hotelFeature.name} value={hotelFeature.id} style={checkboxStyle} />
                                    </Col>
                                ))
                            }
                        </Row>
                        <Row xs={3} className='g-3' style={rowStyle}>
                            {
                                newHotelFeatures.map(newHotelFeature => (
                                    <Col key={newHotelFeature.id}>
                                        <Stack direction='horizontal' gap={4}>
                                            <Form.Check type='checkbox' label={newHotelFeature.name} value={newHotelFeature.id} style={checkboxStyle} />
                                            <div>
                                                <Button variant='outline-primary' size='sm' className='little-btn'>-</Button>
                                            </div>
                                        </Stack>
                                    </Col>
                                ))
                            }
                        </Row>
                        <Row>
                            <Form.Label column xs='auto' htmlFor='form_newFeature'>新增選項 : </Form.Label>
                            <Col xs='auto'>
                                <Form.Control id='form_newFeature' htmlSize={15} />
                            </Col>
                            <Col xs='auto' className='align-self-center'>
                                <Button variant='outline-primary' size='sm'>+</Button>
                            </Col>
                        </Row>
                    </Stack>
                </Col>
            </Form.Group>
        );
    }


    // other
    getAllHotelInfos = () => {

        this.allHotelInfos();
    };


    // on
    plusBtnOnClick = () => {

        const req = constant.fetch.req.checkNewHotelFeature;
        
        this.checkNewHotelFeature();
    }


    // fetch
    allHotelInfos = async () => {

        const {fetch} =  constant;
        const url = fetch.url.allFeatures;
        const config = fetch.config;

        const {serverInfo, data} = await axios.get(url, {
                timeout : config.timeout,
                withCredentials : true
            })
            .then(rs => rs.data)
            .catch(error => console.error(error));

        const statusCode = serverInfo.statusCode;
        if(statusCode === 200){

            this.afterAllHotelInfos(data);
        }
    };
    checkNewHotelFeature = async (params) => {

        const {fetch} =  constant;
        const url = fetch.url.checkNewHotelFeature;
        const config = fetch.config;

        const {serverInfo, data} = await axios.get(url, {
                timeout : config.timeout,
                params : params
            })
            .then(rs => rs.data)
            .catch(error => console.error(error));

        const statusCode = serverInfo.statusCode;
        if(statusCode === 200){

            this.afterCheckNewHotelFeature(data);
        }
    };


    // after fetch
    afterAllHotelInfos = (data) => {

        this.setState({
            hotelFeatures : data.hotelFeatures
        });
    };
    afterCheckNewHotelFeature = (data) => {

        console.log('data : ', data);
    };
}

export default Feature;