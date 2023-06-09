import urls from '../../files/urls.json';
import config from '../../files/config.json';
import React, { Component } from 'react';
import { Container } from 'react-bootstrap';
import BorderForm from '../../hoc/form/border-form';
import CreateForm from './room_create/create-form';
import BackendMain from '../../hoc/backend-main';
import axios from 'axios';


const constant = {
    fetch : {
        url : {
            allShowers : urls.backend.roomCreate.allShowers,
            allScenes : urls.backend.roomCreate.allScenes
        },
        config : {
            timeout : config.fetch.timeout
        }
    }
};

class RoomCreate extends Component {

    constructor(props){

        super(props);
        this.state = {
            createForm : {
                validated : false,
                name : {
                    value : ''
                },
                totalNum : {
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
                    value : '1'
                },
                shower : {
                    options : [],
                    values : []
                },
                status : {
                    value : 1
                },
                newImage : {
                    numbers : [1, 2],
                    hasfile : [],
                    index : 2
                }
            }
        };
    }

    componentDidMount(){

        const {fctn} = this.props;

        fctn.checkLogin(() => {

            this.allShowers(() => {

                this.allScenes();
            });
        });
    }

    render() {

        return (
            <BackendMain titleText='新增房型' Content={this.Content} />
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

        const {createForm} = this.state;
        const setter = {
            createForm : {
                setCreateForm : (val, onSet) => this.setter('createForm', val, onSet)
            }
        }
        const fctn = {
            createForm : {
                showInformModal : this.props.fctn.showInformModal,
                closeInformModal : this.props.fctn.closeInformModal,
                showConfirmModal : this.props.fctn.showConfirmModal,
                closeConfirmModal : this.props.fctn.closeConfirmModal,
                initInput : this.initInput
            }
        };

        return (
            <CreateForm value={createForm} setter={setter.createForm} fctn={fctn.createForm} />
        );
    };



    // other
    allShowers = (onSucess) => {

        this.allShowersFetch(onSucess);
    };
    allScenes = () => {

        this.allScenesFetch();
    };
    initInput = () => {

        const {createForm} = this.state;

        this.setter('createForm', {
            ...createForm,
            validated : false,
            name : {
                ...createForm.name,
                value : ''
            },
            totalNum : {
                ...createForm.totalNum,
                value : ''
            },
            inValidNum : {
                ...createForm.inValidNum,
                options : [],
                value : ''
            },
            price : {
                ...createForm.price,
                value : ''
            },
            singleBedNum : {
                ...createForm.singleBedNum,
                value : ''
            },
            doubleBedNum : {
                ...createForm.doubleBedNum,
                value : ''
            },
            area : {
                ...createForm.area,
                value : ''
            },
            scene : {
                ...createForm.scene,
                value : '1'
            },
            shower : {
                ...createForm.shower,
                values : []
            },
            status : {
                ...createForm.status,
                value : 1
            },
            newImage : {
                ...createForm.newImage,
                numbers : [],
                hasfile : [],
                index : 0
            }
        }, () => {

            const createForm = this.state.createForm;
            this.setter('createForm', {
                ...createForm,
                newImage : {
                    numbers : [1, 2],
                    index : 2
                }
            });
        });
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
    allScenesFetch = async () => {

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

            this.afterAllScenes(data);
        }else if(statusCode===400 || statusCode===500){

            fctn.showInformModal(serverInfo.msg);
        }
    };
    

    // after fetch
    afterAllShowers = (data, onSucess) => {

        const {createForm} = this.state;

        this.setter('createForm', {
            ...createForm,
            shower : {
                ...createForm.shower, 
                options : data.showers
            }
        }, () => {

            onSucess && onSucess();
        });
    };
    afterAllScenes = (data) => {

        const {createForm} = this.state;

        this.setter('createForm', {
            ...createForm,
            scene : {
                ...createForm.scene, 
                options : data.scenes
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

export default RoomCreate;