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
            allRooms : urls.backend.roomUpdate.allRooms
        },
        config : {
            timeout : config.fetch.timeout
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
                    value : ''
                },
                totalNum : {
                    value : ''
                },
                usedNum : {
                    options : [],
                    value : ''
                },
                inValidNum : {
                    options : [],
                    value : ''
                },
                price : {
                    value : ''
                },
                singleBedNum : {
                    value : ''
                },
                doubleBedNum : {
                    value : ''
                },
                area : {
                    value : ''
                },
                scene : {
                    options : [],
                    value : ''
                },
                shower : {
                    options : [],
                    values : []
                },
                status : {
                    value : ''
                },
                roomImage : {
                    options : [],
                    value : '',
                    url : ''
                },
                imageOrder : {
                    options : [],
                    value : ''
                },
                newImage : {
                    num : 0
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
                closeInformModal : this.props.fctn.closeInformModal
                // showConfirmModal : this.props.fctn.showConfirmModal,
                // closeConfirmModal : this.props.fctn.closeConfirmModal
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