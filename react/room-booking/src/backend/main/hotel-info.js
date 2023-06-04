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
                option : {
                    section : {
                        allSections : []
                    },
                    feature : {
                        allFeatures : [],
                        allNewFeatures : []
                    }
                },
                value : {
                    name : '',
                    section : '',
                    address : '',
                    description : '',
                    feature : {
                        features : [],
                        newFeatures : [],
                        insertFeature : ''
                    },
                    hotelImage : {
                        imageName : '',
                        url : ''
                    },
                    updateImage : {
                        imageName : ''
                    }
                },
                other : {
                    feature : {
                        insertFeatureForm : {
                            validated : false
                        }
                    }
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

        const fctn = {
            infoForm : {
                showInformModal : this.props.fctn.showInformModal,
                closeInformModal : this.props.fctn.closeInformModal,
                showConfirmModal : this.props.fctn.showConfirmModal,
                closeConfirmModal : this.props.fctn.closeConfirmModal,
                getAllSections : this.getAllSections,
                getAllFeatures : this.getAllFeatures,
                getAllNewFeatures : this.getAllNewFeatures,
                setAllNewFeatures : this.setAllNewFeatures,
                getInfoFormValue : this.getInfoFormValue,
                setInfoFormValue : this.setInfoFormValue,
                getInsertFeatureFormValidated : this.getInsertFeatureFormValidated,
                setInsertFeatureFormValidated : this.setInsertFeatureFormValidated
            }
        };

        return (
            <InfoForm fctn={fctn.infoForm} />
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
    hotelInfo = (onSuccess) => {

        this.hotelInfoFetch(onSuccess);
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
    hotelInfoFetch = async (onSuccess) => {

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

            this.afterHotelInfo(data, onSuccess);
        }else if(statusCode===400 || statusCode===500){

            fctn.showInformModal(serverInfo.msg);
        }
    };


    // after fetch
    afterAllSections = (data, onSuccess) => {

        const {infoForm} = this.state;
        this.setState({
            infoForm : {
                ...infoForm,
                option : {
                    ...infoForm.option,
                    section : {
                        ...infoForm.option.section,
                        allSections : data.sections
                    }
                }
            }
        }, () => {

            onSuccess && onSuccess();
        });
    };
    afterAllFeatures = (data, onSuccess) => {

        const {infoForm} = this.state;
        this.setState({
            infoForm : {
                ...infoForm,
                option : {
                    ...infoForm.option,
                    feature : {
                        ...infoForm.option.feature,
                        allFeatures : data.features
                    }
                }
            }
        }, () => {

            onSuccess && onSuccess();
        });
    };
    afterAllNewFeatures = (data, onSuccess) => {

        const {infoForm} = this.state;
        this.setState({
            infoForm : {
                ...infoForm,
                option : {
                    ...infoForm.option,
                    feature : {
                        ...infoForm.option.feature,
                        allNewFeatures : data.newFeatures
                    }
                }
            }
        }, () => {

            onSuccess && onSuccess();
        });
    }
    afterHotelInfo = (data, onSuccess) => {

        const {infoForm} = this.state;
        this.setState({
            infoForm : {
                ...infoForm,
                value : {
                    ...infoForm.value,
                    name : data.name,
                    section : data.sectionCode,
                    address : data.address,
                    description : data.introduction,
                    feature : {
                        ...infoForm.value.feature,
                        features : data.featureIds,
                        newFeatures : data.newFeatureNames
                    },
                    hotelImage : {
                        ...infoForm.value.hotelImage,
                        imageName : data.image.imgName,
                        url : data.image.url
                    }
                }
            }
        }, () => {

            onSuccess && onSuccess();
        });
    };


    // getter setter
    getAllSections = () => {

        const {infoForm} = this.state;
        return infoForm.option.section.allSections;
    };
    getAllFeatures = () => {

        const {infoForm} = this.state;
        return infoForm.option.feature.allFeatures;
    };
    getAllNewFeatures = () => {

        const {infoForm} = this.state;
        return infoForm.option.feature.allNewFeatures;
    };
    getInfoFormValue = (colName) => {

        const {infoForm} = this.state;
        return infoForm.value[colName];
    }
    getInsertFeatureFormValidated = () => {

        const {infoForm} = this.state;
        return infoForm.other.feature.insertFeatureForm.validated;
    };


    setInfoFormValue = (colName, colValue) => {

        const {infoForm} = this.state;
        this.setState({
            infoForm : {
                ...infoForm,
                value : {
                    ...infoForm.value,
                    [colName] : colValue
                }
            }
        });
    }
    setAllNewFeatures = (allNewFeatures, onSuccess) => {

        const {infoForm} = this.state;
        this.setState({
            infoForm : {
                ...infoForm,
                option : {
                    ...infoForm.option,
                    feature : {
                        ...infoForm.option.feature,
                        allNewFeatures : allNewFeatures
                    }
                }
            }
        }, () => {

            onSuccess && onSuccess();
        });
    }
    setInsertFeatureFormValidated = (validated, onSuccess) => {

        const {infoForm} = this.state;
        this.setState({
            infoForm : {
                ...infoForm,
                other : {
                    ...infoForm.other,
                    feature : {
                        ...infoForm.other.feature,
                        insertFeatureForm : {
                            ...infoForm.other.feature.insertFeatureForm,
                            validated : validated
                        }
                    }
                }
            }
        }, () => {

            onSuccess && onSuccess();
        });
    };
}

export default HotelInfo;