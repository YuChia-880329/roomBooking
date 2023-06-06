import React, { Component } from 'react';
import { Button, Col, Form, Row, Stack } from 'react-bootstrap';
import Name from './info_form/name';
import Address from './info_form/address';
import Section from './info_form/section';
import Description from './info_form/description';
import Feature from './info_form/feature';
import HotelImage from './info_form/hotel-image';
import UpdateImage from './info_form/update-image';


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
            },
            updateImage : {
                setUpdateImage : (val, onSet) => this.setter('updateImage', val, onSet)
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
            <Stack as={Form} gap={5} noValidate validated={value.validated}>
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
                <UpdateImage value={value.updateImage} setter={setter.updateImage} />
                <Stack direction='horizontal'>
                    <Button variant='outline-primary' className='ms-auto'>更新資料</Button>
                </Stack>
            </Stack>
        );
    }

    // on
    // onChange = (colName, event) => {

    //     const {fctn} = this.props;
    //     fctn.setInfoFormValue(colName, event.target.value);
    // }
    // updateImageOnChange = (event) => {

    //     const {colName} = constant;

    //     const updateImage = this.getValue(colName.updateImage);
    //     updateImage.imageName = event.target.value;
    //     this.setValue(colName.updateImage, updateImage);
    // };
    // onSubmit = (event) => {

    //     const {fctn} = this.props;

    //     event.preventDefault();
    //     fctn.setInfoFormValidated(true, () =>{

    //         if(event.target.checkValidity() === true){
            
    //             fctn.showConfirmModal('確定要更新飯店資料?', () => {

    //                 fctn.update(event.currentTarget.hotelImage.files[0]);
    //             });
    //         }
    //     });
    // };

    // getter setter
    setter = (colName, colVal, onSet) => {

        const {setter, value} = this.props;
        setter.setInfoForm({
            ...value,
            [colName] : colVal
        }, onSet);
    };
}

export default InfoForm;