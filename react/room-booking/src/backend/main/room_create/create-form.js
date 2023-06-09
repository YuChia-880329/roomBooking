import urls from '../../../files/urls.json';
import config from '../../../files/config.json';
import React, { Component } from 'react';
import { Button, Col, Form, Row, Stack } from 'react-bootstrap';
import Name from './create_form/name';
import TotalNum from './create_form/total-num';
import InvalidNum from './create_form/invalid-num';
import Price from './create_form/price';
import SingleBedNum from './create_form/single-bed-num';
import DoubleBedNum from './create_form/double-bed-num';
import Area from './create_form/area';
import Scene from './create_form/scene';
import Shower from './create_form/shower';
import NewImage from './create_form/new-image'
import Status from './create_form/status';
import axios from 'axios';


const constant = {
    fetch : {
        url : {
            create : urls.backend.roomCreate.create
        },
        config : {
            timeout : config.fetch.timeout
        },
        req : {
            update : {
                name : '',
                totalNum : 0,
                invalidNum : 0,
                price : 0,
                singleBedNum : 0,
                doubleBedNum : 0,
                area : 0,
                sceneId : 0,
                showerIds : [],
                statusId : 0,
                newImgs : []
            }
        }
    }
};

class CreateForm extends Component {
    
    render() {

        const {value} = this.props;
        const setter = {
            name : {
                setName : (val, onSet) => this.setter('name', val, onSet)
            },
            totalNum : {
                setTotalNum : (val, onSet) => this.setter('totalNum', val, onSet),
                setInValidNum : (val, onSet) => this.setter('inValidNum', val, onSet)
            },
            inValidNum : {
                setInValidNum : (val, onSet) => this.setter('inValidNum', val, onSet)
            },
            price : {
                setPrice : (val, onSet) => this.setter('price', val, onSet)
            },
            singleBedNum : {
                setSingleBedNum : (val, onSet) => this.setter('singleBedNum', val, onSet)
            },
            doubleBedNum : {
                setDoubleBedNum : (val, onSet) => this.setter('doubleBedNum', val, onSet)
            },
            area : {
                setArea : (val, onSet) => this.setter('area', val, onSet)
            },
            scene : {
                setScene : (val, onSet) => this.setter('scene', val, onSet)
            },
            shower : {
                setShower : (val, onSet) => this.setter('shower', val, onSet)
            },
            status : {
                setStatus : (val, onSet) => this.setter('status', val, onSet)
            },
            newImage : {
                setNewImage : (val, onSet) => this.setter('newImage', val, onSet)
            }
        };
        const getter = {
            totalNum:{
                getInValidNum : () => value.inValidNum
            }
        }
        const fctn = {
            newImage : {
                showConfirmModal : this.props.fctn.showConfirmModal,
                closeConfirmModal : this.props.fctn.closeConfirmModal
            }
        }

        return (
            <Stack as={Form} gap={5} noValidate validated={value.validated} onSubmit={this.onSubmitCreateForm}>
                <Row>
                    <Col>
                        <Name value={value.name} setter={setter.name} />
                    </Col>
                    <Col>
                        <TotalNum value={value.totalNum} setter={setter.totalNum} getter={getter.totalNum} />
                    </Col>
                    <Col>
                        <InvalidNum value={value.inValidNum} setter={setter.inValidNum} />
                    </Col>
                </Row>
                <Row>
                    <Col>
                        <Price value={value.price} setter={setter.price} />
                    </Col>
                    <Col>
                        <SingleBedNum value={value.singleBedNum} setter={setter.singleBedNum} />
                    </Col>
                    <Col>
                        <DoubleBedNum value={value.doubleBedNum} setter={setter.doubleBedNum} />
                    </Col>
                </Row>
                <Row>
                    <Col>
                        <Area value={value.area} setter={setter.area} />
                    </Col>
                    <Col>
                        <Scene value={value.scene} setter={setter.scene} />
                    </Col>
                </Row>
                <Shower value={value.shower} setter={setter.shower} />
                <Status value={value.status} setter={setter.status} />
                <NewImage value={value.newImage} setter={setter.newImage} fctn={fctn.newImage} />
                <Stack direction='horizontal'>
                    <Button type='send' variant='outline-primary' className='ms-auto'>新增房型</Button>
                </Stack>
            </Stack>
        );
    }


    // on
    onSubmitCreateForm = (event) => {

        const {fctn} = this.props;

        event.preventDefault();
        this.setter('validated', true, () => {

            if(event.target.checkValidity() === true){
    
                fctn.showConfirmModal('確定要更新資料 ?', () => {

                    fctn.closeConfirmModal();
                    this.create(event.target);
                });
            }else{

                fctn.showInformModal('表單未完整');
            }
        });
    }


    // other
    create = (form) => {

        const req = constant.fetch.req.update;
        const {value} = this.props;

        req.name = value.name.value;
        req.totalNum = value.totalNum.value;
        req.invalidNum = value.inValidNum.value;
        req.price = value.price.value;
        req.singleBedNum = value.singleBedNum.value;
        req.doubleBedNum = value.doubleBedNum.value;
        req.area = value.area.value;
        req.sceneId = value.scene.value;
        req.showerIds = value.shower.values;
        req.statusId = value.status.value;
        req.newImgs = value.newImage.numbers
            .filter(n => value.newImage.hasfile.includes(n))
            .map(n => ({
                idNumber : n,
                imgName : form[`form_newImage${n}`].files[0].name,
                file : form[`form_newImage${n}`].files[0]
            }));


        const formData = new FormData();
        formData.append('name', req.name);
        formData.append('totalNum', req.totalNum);
        formData.append('invalidNum', req.invalidNum);
        formData.append('price', req.price);
        formData.append('singleBedNum', req.singleBedNum);
        formData.append('doubleBedNum', req.doubleBedNum);
        formData.append('area', req.area);
        formData.append('sceneId', req.sceneId);
        req.showerIds.forEach((si, id) => formData.append(`showerIds[${id}]`, si));
        formData.append('statusId', req.statusId);
        req.newImgs.forEach((ni, id) => Object.keys(ni).forEach(key => formData.append(`newImgs[${id}].${key}`, ni[key])));

        this.createFetch(formData);
    }

    // fetch
    createFetch = async (req) => {

        const {fctn} = this.props;
        const {fetch} =  constant;
        const url = fetch.url.create;
        const config = fetch.config;

        const {serverInfo, data} = await axios.post(url, req, {
                timeout : config.timeout,
                withCredentials: true
            })
            .then(rs => rs.data)
            .catch(error => console.error(error));

        const statusCode = serverInfo.statusCode;
        if(statusCode === 200){

            this.afterCreate(data);
        }else if(statusCode===400 || statusCode===500){

            fctn.showInformModal(serverInfo.msg);
        }
    };


    // after fetch
    afterCreate = (data) => {

        const {fctn} = this.props;

        fctn.showInformModal(data.msg, () => {

            if(data.success){

                this.setter('validated', false, () => {

                    fctn.initInput();
                });
            }
            fctn.closeInformModal();
        });
    };



    // setter
    setter = (colName, colVal, onSet) => {

        const {setter, value} = this.props;
        setter.setCreateForm({
            ...value,
            [colName] : colVal
        }, onSet);
    };
}

export default CreateForm;