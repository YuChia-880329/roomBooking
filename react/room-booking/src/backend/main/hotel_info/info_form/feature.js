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

        const {value} = this.props;
        const {feature, newFeature, insertFeature} = value;

        return (
            <Form.Group as={Row}>
                <Form.Label column xs='auto' htmlFor='form_description'>飯店特色 : </Form.Label>
                <Form.Label column xs='auto'>
                    <Stack gap={5}>
                        <Row xs='auto' className='g-5'>
                            {
                                feature.options.map(
                                    op => (
                                        <Col key={op.id}>
                                            <Form.Check type='checkbox' label={op.name}
                                                    checked={feature.values.includes(op.id)}
                                                    onChange={e => this.onChangeFeature(e, op.id)} />
                                        </Col>
                                    )
                                )
                            }
                        </Row>
                        <Row xs='auto' className='g-5'>
                            {
                                newFeature.options.map(
                                    op => (
                                        <Col key={op.name}>
                                            <Stack direction='horizontal' gap={2}>
                                                <Form.Check type='checkbox' label={op.name}
                                                        checked={newFeature.values.includes(op.name)}
                                                        onChange={e => this.onChangeNewFeature(e, op.name)} />
                                                <Button variant='outline-primary' size='sm' className='little-btn' 
                                                        onClick={e => this.onClickMinusBtn(op.name)}>-</Button>
                                            </Stack>
                                        </Col>
                                    )
                                )
                            }
                        </Row>
                        <Row>
                            <Form.Label column xs='auto' htmlFor='form_insertFeature'>新增選項 : </Form.Label>
                            <Col xs='auto'>
                                <Form.Control required id='form_insertFeature' value={insertFeature.value} 
                                        onChange={this.onChangeInsertFeature} htmlSize={15} />
                            </Col>
                            <Form.Label column xs='auto' className='pt-1'>
                                <Button variant='outline-primary' size='sm' onClick={this.onClickInsertFeatureBtn}>+</Button>
                            </Form.Label>
                        </Row>
                    </Stack>
                </Form.Label>
            </Form.Group>
        );
    }


    // on
    onChangeFeature = (event, checkBoxVal) => {

        const {value} = this.props;
        const {feature} = value;

        let newValues;

        if(event.target.checked)
            newValues = [...feature.values, checkBoxVal];
        else
            newValues = feature.values.filter(v => v!==checkBoxVal);

        this.setter('feature', {
            ...feature,
            values : newValues
        });
    };
    onChangeNewFeature = (event, checkBoxVal) => {

        const {value} = this.props;
        const {newFeature} = value;

        let newValues;

        if(event.target.checked)
            newValues = [...newFeature.values, checkBoxVal];
        else
            newValues = newFeature.values.filter(v => v!==checkBoxVal);

        this.setter('newFeature', {
            ...newFeature,
            values : newValues
        });
    };
    onChangeInsertFeature = (event) => {

        const {value} = this.props;

        this.setter('insertFeature', {
            ...value.insertFeature,
            value : event.target.value
        });
    };
    onClickInsertFeatureBtn = (event) => {

        const {value, fctn} = this.props;

        if(value.insertFeature.value === ''){

            fctn.showInformModal('請輸入名稱')
        }else{

            fctn.showConfirmModal('確定新增選項 ?', () => {
    
                this.checkNewFeature();
            });
        }
    };
    onClickMinusBtn = (name) => {

        const {value, fctn} = this.props;

        fctn.showConfirmModal('確定要刪除選項 ?', () => {

            this.setter('newFeature', {
                ...value.newFeature,
                options : value.newFeature.options.filter(v => v.name!==`${name}`),
                values : value.newFeature.values.filter(v => v!==`${name}`),
            }, () => {

                fctn.closeConfirmModal();
            });
        });
    };


    // other
    checkNewFeature = () => {

        const {value} = this.props;
        const req = constant.fetch.req.checkNewFeature;
        req.name = value.insertFeature.value;

        this.checkNewFeatureFetch(req);
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

        const {value, fctn} = this.props;
        const name = value.insertFeature.value;

        if(data.pass){

            const oldOptions = value.newFeature.options;
            if(!oldOptions.every(v => v.name!==`${name}`)){

                fctn.closeConfirmModal();
                fctn.showInformModal('名稱重複');
            }else{

                this.setter('newFeature', {
                    ...value.newFeature,
                    options : [...oldOptions, {id : -1, name : `${name}`}],
                    values : [...value.newFeature.values, `${name}`]
                }, () => {

                    this.setter('insertFeature', {
                        ...value.insertFeature,
                        value : ''
                    }, () => {

                        fctn.closeConfirmModal();
                    });
                });
            }
        }else{

            fctn.closeConfirmModal();
            fctn.showInformModal(data.msg);
        }
    };


    // setter
    setter = (colName, colVal, onSet) => {

        const {setter, value} = this.props;
        setter.setFeature({
            ...value,
            [colName] : colVal
        }, onSet);
    };
}

export default Feature;