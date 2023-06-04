import urls from '../../../../files/urls.json';
import config from '../../../../files/config.json';
import '../../../../css/custom.css';
import React, { Component } from 'react';
import { Form, Row, Col, Button, Stack } from 'react-bootstrap';
import axios from 'axios';

const constant = {
    fetch : {
        url : {
            checkNewFeature : urls.backend.hotelInfo.checkNewFeature
        },
        config : {
            timeout : config.fetch.timeout
        },
        req : {
            checkNewFeature : {
                name : ''
            }
        }
    }
}
class Feature extends Component {

    render() {

        const rowStyle = {
            paddingTop : 'calc(.375rem + 1px)'
        };
        const checkboxStyle = {
            margin : '0'
        };
        const {fctn} = this.props;

        return (
            <Form.Group as={Row}>
                <Form.Label column xs='auto' htmlFor='form_description'>飯店特色 : </Form.Label>
                <Col>
                    <Stack gap={5}>
                        <Row xs={4} className='g-3' style={rowStyle}>
                            {
                                fctn.getAllFeatures().map(feature => (
                                    <Col key={feature.id}>
                                        <Form.Check type='checkbox' label={feature.name} value={feature.id} 
                                                checked={this.getFeatureIsChecked(feature.id)} style={checkboxStyle}
                                                onChange={this.featuresOnChange} />
                                    </Col>
                                ))
                            }
                        </Row>
                        <Row xs={3} className='g-3' style={rowStyle}>
                            {
                                fctn.getAllNewFeatures().map(newFeature => (
                                    <Col key={newFeature.name}>
                                        <Stack direction='horizontal' gap={4}>
                                            <Form.Check type='checkbox' label={newFeature.name} value={newFeature.name} 
                                                    checked={this.getNewFeatureIsChecked(newFeature.name)} style={checkboxStyle}
                                                    onChange={this.newFeaturesOnChange} />
                                            <div>
                                                <Button variant='outline-primary' size='sm' className='little-btn' onClick={e => this.minusBtnOnClick(newFeature.name)}>-</Button>
                                            </div>
                                        </Stack>
                                    </Col>
                                ))
                            }
                        </Row>
                        <Form noValidate validated={fctn.getInsertFeatureFormValidated()} onSubmit={this.insertFeatureFormOnSubmit}>
                            <Row>
                                <Form.Label column xs='auto' htmlFor='form_insertFeature'>新增選項 : </Form.Label>
                                <Col xs='auto'>
                                    <Form.Control required id='form_insertFeature' value={this.getInsertFeatureVal()} 
                                            onChange={this.insertFeatureOnChange} htmlSize={15} />
                                    <Form.Control.Feedback type='invalid'>請輸入名稱</Form.Control.Feedback>
                                </Col>
                                <Form.Label column xs='auto' htmlFor='form_insertFeature'>
                                    <Button type='send' variant='outline-primary' size='sm'>+</Button>
                                </Form.Label>
                            </Row>
                        </Form>
                    </Stack>
                </Col>
            </Form.Group>
        );
    }


    // other
    checkNewFeature = () => {

        const {values} = this.props;
        const req = constant.fetch.req.checkNewFeature;
        req.name = values.insertFeature;

        this.checkNewFeatureFetch(req);
    };


    // on
    insertFeatureFormOnSubmit = (event) => {

        const {fctn} = this.props;

        event.preventDefault();
        fctn.setInsertFeatureFormValidated(true, () => {

            if(event.target.checkValidity() === true){
    
                this.checkNewFeature();
            }
        });
    }
    featuresOnChange = (event) => {

        const {values, fctn} = this.props;
        
        if(event.target.checked){

            values.features = [...values.features, event.target.value];
        }else{

            values.features = values.features.filter(v => v!==event.target.value);
        }
        fctn.setValue(values);
        event.target.focus();
    };
    newFeaturesOnChange = (event) => {

        const {values, fctn} = this.props;
        
        if(event.target.checked){

            values.newFeatures = [...values.newFeatures, event.target.value];
        }else{

            values.newFeatures = values.newFeatures.filter(v => v!==event.target.value);
        }
        fctn.setValue(values);
    };
    insertFeatureOnChange = (event) => {

        const {values, fctn} = this.props;
        
        values.insertFeature = event.target.value;
        fctn.setValue(values);
    };
    minusBtnOnClick = (name) => {

        const {values, fctn} = this.props;

        fctn.showConfirmModal('確定要刪除選項', () => {

            values.newFeatures = values.newFeatures.filter(v => v!==name);
            fctn.setValue(values);
    
            const newFeatures = fctn.getAllNewFeatures().filter(v => v.name!==name);
            fctn.setAllNewFeatures(newFeatures);
            fctn.closeConfirmModal();
        });
    };


    // fetch
    checkNewFeatureFetch = async (params) => {

        const {fctn} = this.props;
        const {fetch} =  constant;
        const url = fetch.url.checkNewFeature;
        const config = fetch.config;

        const {serverInfo, data} = await axios.get(url, {
                timeout : config.timeout,
                withCredentials : true,
                params : params
            })
            .then(rs => rs.data)
            .catch(error => console.error(error));

        const statusCode = serverInfo.statusCode;
        if(statusCode === 200){

            this.afterCheckNewFeature(data);
        }else if(statusCode===400 || statusCode===500){

            fctn.showInformModal(serverInfo.msg);
        }
    };


    // after fetch
    afterCheckNewFeature = (data) => {

        const {values, fctn} = this.props;
        const name = values.insertFeature;

        if(data.pass){

            const oldNewFeatures = fctn.getAllNewFeatures();
            if(!oldNewFeatures.every(v => v.name!==name)){

                fctn.showInformModal('名稱重複');
            }else{

                fctn.showConfirmModal('確定要新增選項', () => {

                    const newFeatures = [...oldNewFeatures, {id : -1, name : name}];
                    fctn.setAllNewFeatures(newFeatures, () => {
    
                        values.newFeatures = [...values.newFeatures, name];
                        values.insertFeature = '';
                        fctn.setValue(values);
                        fctn.setInsertFeatureFormValidated(false);
                        fctn.closeConfirmModal();
                    });
                })
            }
        }else{

            fctn.showInformModal(data.msg);
        }
    };


    // getter setter
    getFeatureIsChecked = (checkBoxValue) => {

        const {values} = this.props;
        return values.features.includes(`${checkBoxValue}`);
    }
    getNewFeatureIsChecked = (checkBoxValue) => {

        const {values} = this.props;
        return values.newFeatures.includes(`${checkBoxValue}`);
    }
    getInsertFeatureVal = () => {

        const {values} = this.props;
        return values.insertFeature;
    }
}

export default Feature;