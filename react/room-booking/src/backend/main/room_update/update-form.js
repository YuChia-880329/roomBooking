import urls from '../../../files/urls.json';
import config from '../../../files/config.json';
import React, { Component } from 'react';
import { Button, Col, Form, Row, Stack } from 'react-bootstrap';
import Type from './update_form/type';
import Name from './update_form/name';
import TotalNum from './update_form/total-num';
import InvalidNum from './update_form/invalid-num';
import Price from './update_form/price';
import SingleBedNum from './update_form/single-bed-num';
import DoubleBedNum from './update_form/double-bed-num';
import Area from './update_form/area';
import Scene from './update_form/scene';
import Shower from './update_form/shower';
import RoomImage from './update_form/room-image';
import ImageOrder from './update_form/image-order';
import NewImage from './update_form/new-image';
import UsedNum from './update_form/used-num';
import Status from './update_form/status';
import axios from 'axios';

const constant = {
    fetch : {
        url : {
            update : urls.backend.roomUpdate.update
        },
        config : {
            timeout : config.fetch.timeout
        },
        req : {
            update : {
                id : 0,
                name : '',
                totalNum : 0,
                usedNum : 0,
                invalidNum : 0,
                price : 0,
                singleBedNum : 0,
                doubleBedNum : 0,
                area : 0,
                sceneId : 0,
                showerIds : [],
                statusId : 0,
                roomImgs : [],
                newImgs : []
            }
        }
    }
};

class UpdateForm extends Component {
    
    render() {

        const deleteBtnStyle = {
            paddingTop : '0.2rem'
        };
        const {value} = this.props;
        const setter = {
            type : {
                setType : (val, onSet) => this.setter('type', val, onSet)
            },
            name : {
                setName : (val, onSet) => this.setter('name', val, onSet)
            },
            totalNum : {
                setTotalNum : (val, onSet) => this.setter('totalNum', val, onSet),
                setUsedNum : (val, onSet) => this.setter('usedNum', val, onSet),
                setInValidNum : (val, onSet) => this.setter('inValidNum', val, onSet)
            },
            usedNum : {
                setUsedNum : (val, onSet) => this.setter('usedNum', val, onSet)
            },
            inValidNum : {
                setUsedNum : (val, onSet) => this.setter('usedNum', val, onSet),
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
            roomImage : {
                setRoomImage : (val, onSet) => this.setter('roomImage', val, onSet),
                setImageOrder : (val, onSet) => this.setter('imageOrder', val, onSet)
            },
            imageOrder : {
                setRoomImage : (val, onSet) => this.setter('roomImage', val, onSet),
                setImageOrder : (val, onSet) => this.setter('imageOrder', val, onSet)
            },
            newImage : {
                setNewImage : (val, onSet) => this.setter('newImage', val, onSet)
            }
        };
        const getter = {
            totalNum:{
                getUsedNum : () => value.usedNum,
                getInValidNum : () => value.inValidNum
            },
            invalidNum : {
                getTotalNum : () => value.totalNum,
                getUsedNum : () => value.usedNum
            },
            roomImage : {
                getImageOrder : () => value.imageOrder
            },
            imageOrder : {
                getRoomImage : () => value.roomImage
            }
        }
        const fctn = {
            type : {
                roomInfo : this.props.fctn.roomInfo
            },
            imageOrder : {
                showConfirmModal : this.props.fctn.showConfirmModal,
                closeConfirmModal : this.props.fctn.closeConfirmModal
            },
            newImage : {
                showConfirmModal : this.props.fctn.showConfirmModal,
                closeConfirmModal : this.props.fctn.closeConfirmModal
            }
        }

        return (
            <Stack as={Form} gap={5} noValidate validated={value.validated} onSubmit={this.onSubmitUpdateForm}>
                <Row>
                    <Col>
                        <Type value={value.type} setter={setter.type} fctn={fctn.type} />
                    </Col>
                    <Col>
                        <Name value={value.name} setter={setter.name} />
                    </Col>
                </Row>
                <Row>
                    <Col>
                        <TotalNum value={value.totalNum} setter={setter.totalNum} getter={getter.totalNum} />
                    </Col>
                    <Col>
                        <UsedNum value={value.usedNum} setter={setter.usedNum} />
                    </Col>
                    <Col>
                        <InvalidNum value={value.inValidNum} setter={setter.inValidNum} getter={getter.invalidNum} />
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
                <Row>
                    <Col>
                        <RoomImage value={value.roomImage} setter={setter.roomImage} getter={getter.roomImage} />
                    </Col>
                    <Col>
                        <ImageOrder value={value.imageOrder} setter={setter.imageOrder} getter={getter.imageOrder} fctn={fctn.imageOrder} />
                    </Col>
                    <Col xs='auto' style={deleteBtnStyle}>
                        <Button variant='outline-primary' size='sm' onClick={this.onClickDeleteImgBtn} disabled={value.deleteBtn.disabled}>刪除照片</Button>
                    </Col>
                </Row>
                <NewImage value={value.newImage} setter={setter.newImage} fctn={fctn.newImage} />
                <Stack direction='horizontal'>
                    <Button type='send' variant='outline-primary' className='ms-auto' disabled={value.updateBtn.disabled}>更新資料</Button>
                </Stack>
            </Stack>
        );
    }


    // on
    onClickDeleteImgBtn = (event) => {
        
        const {value, fctn} = this.props;

        fctn.showConfirmModal('確定要刪除照片 ? (更新送出前重整即可恢復)', () => {

            const {roomImage, imageOrder} = value;

            const options = roomImage.options.filter(img => img.id!==parseInt(roomImage.value, 10));
            options.sort((img1, img2) => img1.order-img2.order);
            options.forEach((element, index) => element.order=index+1);
            this.setter('roomImage', {
                ...roomImage,
                options : options,
                value : '1',
                url : options[0].url
            }, () => {
    
                this.setter('imageOrder', {
                    ...imageOrder,
                    options : imageOrder.options.filter(v => v!==imageOrder.options.length),
                    value : '1'
                });
            });
            fctn.closeConfirmModal();
        });
    };
    onSubmitUpdateForm = (event) => {

        const {fctn} = this.props;

        event.preventDefault();
        this.setter('validated', true, () => {

            if(event.target.checkValidity() === true){
    
                fctn.showConfirmModal('確定要更新資料 ?', () => {

                    fctn.closeConfirmModal();
                    this.update(event.target);
                });
            }else{

                fctn.showInformModal('表單未完整');
            }
        });
    }


    // other
    update = (form) => {

        const req = constant.fetch.req.update;
        const {value} = this.props;

        req.id = value.type.value;
        req.name = value.name.value;
        req.totalNum = value.totalNum.value;
        req.usedNum = value.usedNum.value;
        req.invalidNum = value.inValidNum.value;
        req.price = value.price.value;
        req.singleBedNum = value.singleBedNum.value;
        req.doubleBedNum = value.doubleBedNum.value;
        req.area = value.area.value;
        req.sceneId = value.scene.value;
        req.showerIds = value.shower.values;
        req.statusId = value.status.value;
        req.roomImgs = value.roomImage.options.map(img => ({
            id : img.id,
            order : img.order
        }));
        req.newImgs = value.newImage.numbers
            .filter(n => value.newImage.hasfile.includes(n))
            .map(n => ({
                idNumber : n,
                imgName : form[`form_newImage${n}`].files[0].name,
                file : form[`form_newImage${n}`].files[0]
            }));


        const formData = new FormData();
        formData.append('id', req.id);
        formData.append('name', req.name);
        formData.append('totalNum', req.totalNum);
        formData.append('usedNum', req.usedNum);
        formData.append('invalidNum', req.invalidNum);
        formData.append('price', req.price);
        formData.append('singleBedNum', req.singleBedNum);
        formData.append('doubleBedNum', req.doubleBedNum);
        formData.append('area', req.area);
        formData.append('sceneId', req.sceneId);
        req.showerIds.forEach((si, id) => formData.append(`showerIds[${id}]`, si));
        formData.append('statusId', req.statusId);
        req.roomImgs.forEach((ri, id) => Object.keys(ri).forEach(key => formData.append(`roomImgs[${id}].${key}`, ri[key])));
        req.newImgs.forEach((ni, id) => Object.keys(ni).forEach(key => formData.append(`newImgs[${id}].${key}`, ni[key])));

        this.updateFetch(formData);
    }

    // fetch
    updateFetch = async (req) => {

        const {fctn} = this.props;
        const {fetch} =  constant;
        const url = fetch.url.update;
        const config = fetch.config;

        const {serverInfo, data} = await axios.post(url, req, {
                timeout : config.timeout,
                withCredentials: true
            })
            .then(rs => rs.data)
            .catch(error => console.error(error));

        const statusCode = serverInfo.statusCode;
        if(statusCode === 200){

            this.afterUpdate(data);
        }else if(statusCode===400 || statusCode===500){

            fctn.showInformModal(serverInfo.msg);
        }
    };


    // after fetch
    afterUpdate = (data) => {

        const {fctn, value} = this.props;

        fctn.showInformModal(data.msg, () => {

            if(data.success){

                fctn.roomInfo(value.type.value);
                this.setter('validated', false);
            }
            fctn.closeInformModal();
        });
    };



    // setter
    setter = (colName, colVal, onSet) => {

        const {setter, value} = this.props;
        setter.setUpdateForm({
            ...value,
            [colName] : colVal
        }, onSet);
    };
}

export default UpdateForm;