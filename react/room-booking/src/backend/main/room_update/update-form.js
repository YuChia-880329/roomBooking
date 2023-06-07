import urls from '../../../files/urls.json';
import config from '../../../files/config.json';
import React, { Component } from 'react';
import { Button, Col, Row, Stack } from 'react-bootstrap';
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
            roomInfo : urls.backend.roomUpdate.roomInfo
        },
        config : {
            timeout : config.fetch.timeout
        },
        req : {
            roomInfo : {
                roomId : 0
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
                setTotalNum : (val, onSet) => this.setter('totalNum', val, onSet)
            },
            usedNum : {
                setUsedNum : (val, onSet) => this.setter('usedNum', val, onSet)
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
            roomImage : {
                setRoomImage : (val, onSet) => this.setter('roomImage', val, onSet)
            },
            imageOrder : {
                setImageOrder : (val, onSet) => this.setter('imageOrder', val, onSet)
            },
            newImage : {
                setNewImage : (val, onSet) => this.setter('newImage', val, onSet)
            }
        };
        const fctn = {
            type : {
                roomInfo : this.roomInfo
            }
        }


        return (
            <Stack gap={5}>
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
                        <TotalNum value={value.totalNum} setter={setter.totalNum} />
                    </Col>
                    <Col>
                        <UsedNum value={value.usedNum} setter={setter.usedNum} />
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
                <Row>
                    <Col>
                        <RoomImage value={value.roomImage} setter={setter.roomImage} />
                    </Col>
                    <Col>
                        <ImageOrder value={value.imageOrder} setter={setter.imageOrder} />
                    </Col>
                    <Col xs='auto' style={deleteBtnStyle}>
                        <Button variant='outline-primary' size='sm'>刪除照片</Button>
                    </Col>
                </Row>
                <NewImage value={value.newImage} setter={setter.newImage} />
                <Stack direction='horizontal'>
                    <Button variant='outline-primary' className='ms-auto'>更新資料</Button>
                </Stack>
            </Stack>
        );
    }


    // other
    roomInfo = (roomId) => {

        const params = constant.fetch.req.roomInfo;
        params.roomId = roomId;

        this.roomInfoFetch(params);
    };
    
    
    // fetch
    roomInfoFetch = async (params) => {

        const {fctn} = this.props;
        const {fetch} =  constant;
        const url = fetch.url.roomInfo;
        const config = fetch.config;

        const {serverInfo, data} = await axios.get(url, {
                timeout : config.timeout,
                withCredentials: true,
                params : params
            })
            .then(rs => rs.data)
            .catch(error => console.error(error));

        const statusCode = serverInfo.statusCode;
        if(statusCode === 200){

            this.afterRoomInfo(data);
        }else if(statusCode===400 || statusCode===500){

            fctn.showInformModal(serverInfo.msg);
        }
    };


    // after fetch
    afterRoomInfo = (data) => {

        const {value} = this.props;
        const {totalNum, usedNum, inValidNum, price, singleBedNum, 
            doubleBedNum, area, scene, shower, status, roomImage, imageOrder} = value;

        this.setter('totalNum', {
            ...totalNum,
            value : data.totalNum
        });
        this.setter('usedNum', {
            ...usedNum,
            value : data.usedNum
        });
        this.setter('inValidNum', {
            ...inValidNum,
            value : data.invalidNum
        });
        this.setter('price', {
            ...price,
            value : data.price
        });
        this.setter('singleBedNum', {
            ...singleBedNum,
            value : data.singleBedNum
        });
        this.setter('doubleBedNum', {
            ...doubleBedNum,
            value : data.doubleBedNum
        });
        this.setter('area', {
            ...area,
            value : data.area
        });
        this.setter('scene', {
            ...scene,
            value : data.sceneId
        });
        this.setter('shower', {
            ...shower,
            values : data.showerIds
        });
        this.setter('status', {
            ...status,
            value : data.statusId
        });
        this.setter('roomImage', {
            ...roomImage
        });
        this.setter('imageOrder', {
            ...imageOrder
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