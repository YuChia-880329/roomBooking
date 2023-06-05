import React, { Component } from 'react';
import { Button, Col, Form, Row, Stack } from 'react-bootstrap';
import Name from './info_form/name';
import Address from './info_form/address';
import Section from './info_form/section';
import Description from './info_form/description';
import Feature from './info_form/feature';
import HotelImage from './info_form/hotel-image';
import UpdateImage from './info_form/update-image';

const constant = {
    colName : {
        name : 'name',
        section : 'section',
        address : 'address',
        description : 'description',
        feature : 'feature',
        hotelImage : 'hotelImage',
        updateImage : 'updateImage'
    }
};


class InfoForm extends Component {

    render() {

        const {colName} = constant;
        const fctn = {
            section : {
                getAllSections : this.props.fctn.getAllSections
            },
            feature : {
                showInformModal : this.props.fctn.showInformModal,
                closeInformModal : this.props.fctn.closeInformModal,
                showConfirmModal : this.props.fctn.showConfirmModal,
                closeConfirmModal : this.props.fctn.closeConfirmModal,
                getAllFeatures : this.props.fctn.getAllFeatures,
                getAllNewFeatures : this.props.fctn.getAllNewFeatures,
                setAllNewFeatures : this.props.fctn.setAllNewFeatures,
                setValue : v => this.setValue(colName.feature, v),
                getInsertFeatureFormValidated : this.props.fctn.getInsertFeatureFormValidated,
                setInsertFeatureFormValidated : this.props.fctn.setInsertFeatureFormValidated
            }
        };
        return (
            <Form noValidate>
                <Stack gap={5}>
                    <Row>
                        <Col>
                            <Name value={this.getValue(colName.name)} 
                                    onChange={e => this.onChange(colName.name, e)} />
                        </Col>
                        <Col>
                            <Section fctn={fctn.section} 
                                    value={this.getValue(colName.section)}
                                    onChange={e => this.onChange(colName.section, e)} />
                        </Col>
                    </Row>
                    <Address value={this.getValue(colName.address)}
                            onChange={e => this.onChange(colName.address, e)} />
                    <Description value={this.getValue(colName.description)}
                            onChange={e => this.onChange(colName.description, e)} />
                    <Feature fctn={fctn.feature}
                            values={this.getValue(colName.feature)} />
                    <HotelImage imgName={this.getValue(colName.hotelImage).imageName}
                            url={this.getValue(colName.hotelImage).url} />
                    <UpdateImage imgName={this.getValue(colName.updateImage).imageName} 
                            onChange={this.updateImageOnChange} />
                    <Stack direction='horizontal'>
                        <Button variant='outline-primary' className='ms-auto'>更新資料</Button>
                    </Stack>
                </Stack>
            </Form>
        );
    }

    // on
    onChange = (colName, event) => {

        const {fctn} = this.props;
        fctn.setInfoFormValue(colName, event.target.value);
    }
    updateImageOnChange = (event) => {

        const {colName} = constant;

        const updateImage = this.getValue(colName.updateImage);
        updateImage.imageName = event.target.value;
        this.setValue(colName.updateImage, updateImage);
    };

    // getter setter
    getValue = (colName) => {

        const {fctn} = this.props;
        return fctn.getInfoFormValue(colName);
    };
    setValue = (colName, colValue) => {

        const {fctn} = this.props;
        fctn.setInfoFormValue(colName, colValue);
    }
}

export default InfoForm;