import urls from '../../files/urls.json';
import config from '../../files/config.json';
import React, { Component } from 'react';
import { Container } from 'react-bootstrap';
import BorderForm from '../../hoc/form/border-form';
import UpdateForm from './room_update/update-form';
import BackendMain from '../../hoc/backend-main';
import axios from 'axios';


const constant = {
    fetch : {
        url : {
            allShowers : urls.backend.roomUpdate.allShowers,
            allScenes : urls.backend.roomUpdate.allScenes,
            allRooms : urls.backend.roomUpdate.allRooms,
            roomInfo : urls.backend.roomUpdate.roomInfo
        },
        config : {
            timeout : config.fetch.timeout
        },
        req : {
            roomInfo : {
                roomId : -1
            },
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
class RoomUpdate extends Component {

    constructor(props){

        super(props);
        this.state = {
            updateForm : {
                validated : false,
                type : {
                    options : [],
                    value : ''
                },
                name : {
                    disabled : true,
                    value : ''
                },
                totalNum : {
                    disabled : true,
                    value : ''
                },
                usedNum : {
                    disabled : true,
                    options : [],
                    value : ''
                },
                inValidNum : {
                    disabled : true,
                    options : [],
                    value : ''
                },
                price : {
                    disabled : true,
                    value : ''
                },
                singleBedNum : {
                    disabled : true,
                    value : ''
                },
                doubleBedNum : {
                    disabled : true,
                    value : ''
                },
                area : {
                    disabled : true,
                    value : ''
                },
                scene : {
                    disabled : true,
                    options : [],
                    value : ''
                },
                shower : {
                    disabled : true,
                    options : [],
                    values : []
                },
                status : {
                    disabled : true,
                    value : ''
                },
                roomImage : {
                    disabled : true,
                    options : [],
                    value : '',
                    url : ''
                },
                imageOrder : {
                    disabled : true,
                    options : [],
                    value : ''
                },
                deleteBtn : {
                    disabled : true
                },
                newImage : {
                    disabled : true,
                    numbers : [1, 2],
                    hasfile : [],
                    index : 2
                },
                updateBtn : {
                    disabled : true
                }
            }
        };
    }

    componentDidMount(){

        const {fctn} = this.props;

        fctn.checkLogin(() => {

            this.allShowers(() => {

                this.allScenes(() => {

                    this.allRooms();
                });
            });
        });
    }

    render() {
        
        return (
            <BackendMain titleText='房型更新' Content={this.Content} />
        );
    }

    // jsx
    Content = () => {

        return (
            <Container className='w-75'>
                <BorderForm Content={this.BorderFormContent} />
            </Container>
        );
    };
    BorderFormContent = () => {

        const {updateForm} = this.state;
        const setter = {
            updateForm : {
                setUpdateForm : (val, onSet) => this.setter('updateForm', val, onSet)
            }
        }
        const fctn = {
            updateForm : {
                showInformModal : this.props.fctn.showInformModal,
                closeInformModal : this.props.fctn.closeInformModal,
                showConfirmModal : this.props.fctn.showConfirmModal,
                closeConfirmModal : this.props.fctn.closeConfirmModal,
                roomInfo : this.roomInfo
            }
        };

        return (
            <UpdateForm value={updateForm} setter={setter.updateForm} fctn={fctn.updateForm} />
        );
    };


    // other
    allShowers = (onSucess) => {

        this.allShowersFetch(onSucess);
    };
    allScenes = (onSucess) => {

        this.allScenesFetch(onSucess);
    };
    allRooms = () => {

        this.allRoomsFetch();
    };
    roomInfo = (roomId) => {

        const req = constant.fetch.req.roomInfo;
        req.roomId = roomId;
        this.roomInfoFetch(req);
    };


    // fetch
    allShowersFetch = async (onSuccess) => {

        const {fctn} = this.props;
        const {fetch} =  constant;
        const url = fetch.url.allShowers;
        const config = fetch.config;

        const {serverInfo, data} = await axios.get(url, {
                timeout : config.timeout
            })
            .then(rs => rs.data)
            .catch(error => console.error(error));

        const statusCode = serverInfo.statusCode;
        if(statusCode === 200){

            this.afterAllShowers(data, onSuccess);
        }else if(statusCode===400 || statusCode===500){

            fctn.showInformModal(serverInfo.msg);
        }
    };
    allScenesFetch = async (onSuccess) => {

        const {fctn} = this.props;
        const {fetch} =  constant;
        const url = fetch.url.allScenes;
        const config = fetch.config;

        const {serverInfo, data} = await axios.get(url, {
                timeout : config.timeout
            })
            .then(rs => rs.data)
            .catch(error => console.error(error));

        const statusCode = serverInfo.statusCode;
        if(statusCode === 200){

            this.afterAllScenes(data, onSuccess);
        }else if(statusCode===400 || statusCode===500){

            fctn.showInformModal(serverInfo.msg);
        }
    };
    allRoomsFetch = async () => {

        const {fctn} = this.props;
        const {fetch} =  constant;
        const url = fetch.url.allRooms;
        const config = fetch.config;

        const {serverInfo, data} = await axios.get(url, {
                timeout : config.timeout,
                withCredentials: true
            })
            .then(rs => rs.data)
            .catch(error => console.error(error));

        const statusCode = serverInfo.statusCode;
        if(statusCode === 200){

            this.afterAllRooms(data);
        }else if(statusCode===400 || statusCode===500){

            fctn.showInformModal(serverInfo.msg);
        }
    };
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
    afterAllShowers = (data, onSucess) => {

        const {updateForm} = this.state;

        this.setter('updateForm', {
            ...updateForm,
            shower : {
                ...updateForm.shower, 
                options : data.showers
            }
        }, () => {

            onSucess && onSucess();
        });
    };
    afterAllScenes = (data, onSucess) => {

        const {updateForm} = this.state;

        this.setter('updateForm', {
            ...updateForm,
            scene : {
                ...updateForm.scene, 
                options : data.scenes
            }
        }, () => {

            onSucess && onSucess();
        });
    };
    afterAllRooms = (data) => {

        const {updateForm} = this.state;

        this.setter('updateForm', {
            ...updateForm,
            type : {
                ...updateForm.type, 
                options : data.rooms
            }
        });
    };
    afterRoomInfo = (data) => {

        const {updateForm} = this.state;

        this.setter('updateForm', {
            ...updateForm,
            name : {
                ...updateForm.name,
                disabled : !data.hasValue,
                value : data.hasValue ? data.roomName : ''
            },
            totalNum : {
                ...updateForm.totalNum,
                disabled : !data.hasValue,
                value : data.hasValue ? data.totalNum : ''
            },
            usedNum : {
                ...updateForm.usedNum,
                disabled : !data.hasValue,
                options : data.hasValue ? data.usedNum.options : [],
                value : data.hasValue ? `${data.usedNum.value}` : '-1'
            },
            inValidNum : {
                ...updateForm.inValidNum,
                disabled : !data.hasValue,
                options : data.hasValue ? data.invalidNum.options : [],
                value : data.hasValue ? `${data.invalidNum.value}` : '-1'
            },
            price : {
                ...updateForm.price,
                disabled : !data.hasValue,
                value : data.hasValue ? data.price : ''
            },
            singleBedNum : {
                ...updateForm.singleBedNum,
                disabled : !data.hasValue,
                value : data.hasValue ? data.singleBedNum : ''
            },
            doubleBedNum : {
                ...updateForm.doubleBedNum,
                disabled : !data.hasValue,
                value : data.hasValue ? data.doubleBedNum : ''
            },
            area : {
                ...updateForm.area,
                disabled : !data.hasValue,
                value : data.hasValue ? data.area : ''
            },
            scene : {
                ...updateForm.scene,
                disabled : !data.hasValue,
                value : data.hasValue ? `${data.sceneId}` : '-1'
            },
            shower : {
                ...updateForm.shower,
                disabled : !data.hasValue,
                values : data.hasValue ? data.showerIds : []
            },
            status : {
                ...updateForm.status,
                disabled : !data.hasValue,
                value : data.hasValue ? data.statusId : -1
            },
            roomImage : {
                ...updateForm.roomImage,
                disabled : !data.roomImgs.hasImg,
                options : data.roomImgs.hasImg ? data.roomImgs.imgs : [],
                value : data.roomImgs.hasImg ? `${data.roomImgs.currentImg.id}` : '-1',
                url : data.roomImgs.hasImg ? data.roomImgs.currentImg.url : ''
            },
            imageOrder : {
                ...updateForm.imageOrder,
                disabled : !data.imageOrder.hasImg,
                options : data.imageOrder.hasImg ? data.imageOrder.orders : [],
                value : data.imageOrder.hasImg ? `${data.imageOrder.value}` : '-1'
            },
            deleteBtn : {
                ...updateForm.deleteBtn,
                disabled : !data.roomImgs.hasImg
            },
            newImage : {
                ...updateForm.newImage,
                disabled : !data.hasValue,
                numbers : [],
                hasfile : [],
                index : 0
            },
            updateBtn : {
                ...updateForm.updateBtn,
                disabled : !data.hasValue
            }
        }, () => {

            const updateForm = this.state.updateForm;
            this.setter('updateForm', {
                ...updateForm,
                newImage : {
                    ...updateForm.newImage,
                    numbers : [1, 2],
                    index : 2
                }
            });
        });
    }


    // setter
    setter = (colName, colVal, onSet) => {

        this.setState({
            [colName] : colVal
        }, () => {

            onSet && onSet();
        });
    }
}

export default RoomUpdate;