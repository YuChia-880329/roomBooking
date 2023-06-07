import urls from '../../../files/urls.json';
import config from '../../../files/config.json';
import React, { Component } from 'react';
import { Button, Col, Form, Row, Stack } from 'react-bootstrap';
import Name from './info_form/name';
import Address from './info_form/address';
import Section from './info_form/section';
import Description from './info_form/description';
import Feature from './info_form/feature';
import HotelImage from './info_form/hotel-image';
import UpdateImage from './info_form/update-image';
import axios from 'axios';


const constant = {
    fetch : {
        url : {
            update : urls.backend.hotelInfo.update
        },
        config : {
            timeout : config.fetch.timeout
        },
        req : {
            update : {
                name : '',
                sectionCode : '',
                address : '',
                description : '',
                featureIds : [],
                newFeatures : [],
                updateImage : {
                    needUpdate : false,
                    imageName : '',
                    file : null
                }
            }
        }
    }
}

class InfoForm extends Component {

    render() {

        const {value} = this.props;
        const setter = {
            name : {
                setName : (val, onSet) => this.setter('name', val, onSet)
            },
            section : {
                setSection : (val, onSet) => this.setter('section', val, onSet)
            },
            address : {
                setAddress : (val, onSet) => this.setter('address', val, onSet)
            },
            description : {
                setDescription : (val, onSet) => this.setter('description', val, onSet)
            },
            feature : {
                setFeature : (val, onSet) => this.setter('feature', val, onSet)
            }
        };
        const fctn = {
            feature : {
                showInformModal : this.props.fctn.showInformModal,
                closeInformModal : this.props.fctn.closeInformModal,
                showConfirmModal : this.props.fctn.showConfirmModal,
                closeConfirmModal : this.props.fctn.closeConfirmModal
            }
        };

        return (
            <Stack as={Form} gap={5} noValidate validated={value.validated} onSubmit={this.onSubmit}>
                <Row>
                    <Col>
                        <Name value={value.name} setter={setter.name} />
                    </Col>
                    <Col>
                        <Section value={value.section} setter={setter.section} />
                    </Col>
                </Row>
                <Address value={value.address} setter={setter.address} />
                <Description value={value.description} setter={setter.description} />
                <Feature value={value.feature} setter={setter.feature} fctn={fctn.feature} />
                <HotelImage value={value.hotelImage} />
                <UpdateImage />
                <Stack direction='horizontal'>
                    <Button type='send' variant='outline-primary' className='ms-auto'>更新資料</Button>
                </Stack>
            </Stack>
        );
    }

    // on
    onSubmit = (event) => {

        const {fctn} = this.props;

        event.preventDefault();
        this.setter('validated', true, () => {

            if(event.target.checkValidity() === true){
    
                fctn.showConfirmModal('確定要更新資料 ?', () => {

                    fctn.closeConfirmModal();
                    this.update(event.target.hotelImage.files[0]);
                });
            }
        });
    };


    // other
    update = (imgFile) => {

        const {value} = this.props;
        const req = constant.fetch.req.update;
        const {newFeature} = value.feature;

        req.name = value.name.value;
        req.sectionCode = value.section.value;
        req.address = value.address.value;
        req.description = value.description.value;
        req.featureIds = value.feature.feature.values;
        req.newFeatures = newFeature.options.map(nf => ({
                id : nf.id,
                name : nf.name,
                checked : newFeature.values.includes(nf.name)
            }));
        req.updateImage.needUpdate = imgFile !== undefined;
        req.updateImage.imageName = imgFile && imgFile.name;
        req.updateImage.file = imgFile;

        const formData = new FormData();
        formData.append('name', req.name);
        formData.append('sectionCode', req.sectionCode);
        formData.append('address', req.address);
        formData.append('description', req.description);
        req.featureIds.forEach((fi, id) => formData.append('featureIds[' + id + ']', fi));
        req.newFeatures.forEach((nf, id) => {

            Object.keys(nf).forEach(key => formData.append('newFeatures[' + id + '].' + key, nf[key]));
        });
        formData.append('updateImage.needUpdate', req.updateImage.needUpdate);
        if(req.updateImage.imageName)
            formData.append('updateImage.imageName', req.updateImage.imageName);
        if(req.updateImage.file)
            formData.append('updateImage.file', req.updateImage.file);

        this.updateFetch(formData);
    }


    // fetch
    updateFetch = async (req) => {

        const {fctn} = this.props;
        const {fetch} =  constant;
        const url = fetch.url.update;
        const config = fetch.config;

        const {serverInfo, data} = await axios.patch(url, req, {
                timeout : config.timeout,
                withCredentials : true
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

        const {fctn} = this.props;

        fctn.showInformModal(data.msg, () => {

            if(data.success){

                const href = window.location.href;
                window.location.href = href;
            }
        });
    }



    // setter
    setter = (colName, colVal, onSet) => {

        const {setter, value} = this.props;
        setter.setInfoForm({
            ...value,
            [colName] : colVal
        }, onSet);
    };
}

export default InfoForm;