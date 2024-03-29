import urls from '../../files/urls.json';
import config from '../../files/config.json';
import React, { Component } from 'react';
import { Container } from 'react-bootstrap';
import BorderForm from '../../hoc/form/border-form';
import InfoForm from './hotel_info/info-form';
import BackendMain from '../../hoc/backend-main';
import axios from 'axios';


const constant = {
    fetch : {
        url : {
            allSections : urls.backend.hotelInfo.allSections,
            allFeatures : urls.backend.hotelInfo.allFeatures,
            allNewFeatures : urls.backend.hotelInfo.allNewFeatures,
            hotelInfo : urls.backend.hotelInfo.hotelInfo
        },
        config : {
            timeout : config.fetch.timeout
        }
    }
}
class HotelInfo extends Component {

    constructor(props){

        super(props);
        this.state = {
            infoForm : {
                validated : false,
                name : {
                    value : ''
                },
                section : {
                    options : [],
                    value : ''
                },
                address : {
                    value : ''
                },
                description : {
                    value : ''
                },
                feature : {
                    feature : {
                        options : [],
                        values : []
                    },
                    newFeature : {
                        options : [],
                        values : []
                    },
                    insertFeature : {
                        value : ''
                    }
                },
                hotelImage : {
                    imageName : '',
                    url : ''
                }
            }
        };
    }
    componentDidMount(){

        const {fctn} = this.props;
        
        fctn.checkLogin(() => {

            this.allSections(() => {

                this.allFeatures(() => {

                    this.allNewFeatures(() => {

                        this.hotelInfo();
                    });
                });
            });
        });
    }

    render() {

        return (
            <BackendMain titleText='飯店資料' Content={this.Content} />
        );
    }

    // jsx
    Content = () => {

        return (
            <Container className='w-75'>
                <BorderForm Content={this.BorderFormContent}/>
            </Container>
        );
    };
    BorderFormContent = () => {

        const {infoForm} = this.state;
        const setter = {
            infoForm : {
                setInfoForm : (val, onSet) => this.setter('infoForm', val, onSet)
            }
        }
        const fctn = {
            infoForm : {
                showInformModal : this.props.fctn.showInformModal,
                closeInformModal : this.props.fctn.closeInformModal,
                showConfirmModal : this.props.fctn.showConfirmModal,
                closeConfirmModal : this.props.fctn.closeConfirmModal,
                hotelInfo : this.hotelInfo
            }
        };

        return (
            <InfoForm value={infoForm} setter={setter.infoForm} fctn={fctn.infoForm} />
        );
    };


    // other
    allSections = (onSuccess) => {

        this.allSectionsFetch(onSuccess);
    };
    allFeatures = (onSuccess) => {

        this.allFeaturesFetch(onSuccess);
    };
    allNewFeatures = (onSuccess) => {

        this.allNewFeaturesFetch(onSuccess);
    };
    hotelInfo = () => {

        this.hotelInfoFetch();
    };


    // fetch
    allSectionsFetch = async (onSuccess) => {

        const {fctn} = this.props;
        const {fetch} =  constant;
        const url = fetch.url.allSections;
        const config = fetch.config;

        const {serverInfo, data} = await axios.get(url, {
                timeout : config.timeout
            })
            .then(rs => rs.data)
            .catch(error => console.error(error));

        const statusCode = serverInfo.statusCode;
        if(statusCode === 200){

            this.afterAllSections(data, onSuccess);
        }else if(statusCode===400 || statusCode===500){

            fctn.showInformModal(serverInfo.msg);
        }
    };
    allFeaturesFetch = async (onSuccess) => {

        const {fctn} = this.props;
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

            this.afterAllFeatures(data, onSuccess);
        }else if(statusCode===400 || statusCode===500){

            fctn.showInformModal(serverInfo.msg);
        }
    };
    allNewFeaturesFetch = async (onSuccess) => {

        const {fctn} = this.props;
        const {fetch} =  constant;
        const url = fetch.url.allNewFeatures;
        const config = fetch.config;

        const {serverInfo, data} = await axios.get(url, {
                timeout : config.timeout,
                withCredentials : true
            })
            .then(rs => rs.data)
            .catch(error => console.error(error));

        const statusCode = serverInfo.statusCode;
        if(statusCode === 200){

            this.afterAllNewFeatures(data, onSuccess);
        }else if(statusCode===400 || statusCode===500){

            fctn.showInformModal(serverInfo.msg);
        }
    };
    hotelInfoFetch = async () => {

        const {fctn} = this.props;
        const {fetch} =  constant;
        const url = fetch.url.hotelInfo;
        const config = fetch.config;

        const {serverInfo, data} = await axios.get(url, {
                timeout : config.timeout,
                withCredentials : true
            })
            .then(rs => rs.data)
            .catch(error => console.error(error));

        const statusCode = serverInfo.statusCode;
        if(statusCode === 200){

            this.afterHotelInfo(data);
        }else if(statusCode===400 || statusCode===500){

            fctn.showInformModal(serverInfo.msg);
        }
    };



    // after fetch
    afterAllSections = (data, onSuccess) => {

        const {infoForm} = this.state;

        this.setter('infoForm', {
            ...infoForm,
            section : {
                ...infoForm.section,
                options : data.sections
            }
        }, () => {

            onSuccess && onSuccess();
        });
    };
    afterAllFeatures = (data, onSuccess) => {

        const {infoForm} = this.state;

        this.setter('infoForm', {
            ...infoForm,
            feature : {
                ...infoForm.feature,
                feature : {
                    ...infoForm.feature.feature,
                    options : data.features
                }
            }
        }, () => {

            onSuccess && onSuccess();
        });
    };
    afterAllNewFeatures = (data, onSuccess) => {

        const {infoForm} = this.state;

        this.setter('infoForm', {
            ...infoForm,
            feature : {
                ...infoForm.feature,
                newFeature : {
                    ...infoForm.feature.newFeature,
                    options : data.newFeatures
                }
            }
        }, () => {

            onSuccess && onSuccess();
        });
    }
    afterHotelInfo = (data) => {

        const {infoForm} = this.state;
        const {fctn} = this.props;

        this.setter('infoForm', {
            ...infoForm,
            name : {
                ...infoForm.name,
                value : data.name
            },
            section : {
                ...infoForm.section,
                value : data.sectionCode
            },
            address : {
                ...infoForm.address,
                value : data.address
            },
            description : {
                ...infoForm.description,
                value : data.description
            },
            feature : {
                ...infoForm.feature,
                feature : {
                    ...infoForm.feature.feature,
                    values : data.featureIds
                },
                newFeature : {
                    ...infoForm.feature.newFeature,
                    values : data.newFeatureNames
                }
            },
            hotelImage : {
                ...infoForm.hotelImage,
                imageName : data.image.imgName,
                url : data.image.url
            }
        }, () => {

            fctn.setNavBarHotelName(data.name);
        });
    };


    // setter
    setter = (colName, colVal, onSet) => {

        this.setState({
            [colName] : colVal
        }, () => {

            onSet && onSet();
        });
    }
}

export default HotelInfo;