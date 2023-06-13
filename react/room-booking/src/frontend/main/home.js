import urls from '../../files/urls.json';
import config from '../../files/config.json';
import houseIcon from '../../image/house-icon.png';
import React, { Component, Fragment } from 'react';
import { Col, Image, Row, Stack } from 'react-bootstrap';
import FrontendMain from '../../hoc/frontend-main';
import FilterForm from './home/filter-form';
import Hotels from './home/hotels';
import Pagn from '../../hoc/pagn';
import axios from 'axios';


const constant = {
    fetch : {
        url : {
            allSections : urls.frontend.home.allSections
        },
        config : {
            timeout : config.fetch.timeout
        }
    }
}

class Home extends Component {

    constructor(props){

        super(props);
        this.state = {
            filterForm : {
                date : {
                    valueCheckinDate : '',
                    valueCheckoutDate : ''
                },
                number : {
                    value : ''
                },
                section : {
                    options : [],
                    value : ''
                }
            },
            hotels : {
                items : []
            },
            pagination : {
                show : false,
                first : {
                    show : true,
                    toPage : 1
                },
                prev : {
                    show : true,
                    toPage : 1
                },
                pages : [1, 2, 3],
                next : {
                    show : true,
                    toPage : 3
                },
                last : {
                    show : true,
                    toPage : 3 
                },
                currentPage : 2
            }
        };
    }


    componentDidMount(){

        this.allSections();
    }

    
    render() {

        return (
            <FrontendMain Content={this.Content} />
        );
    }

    // jsx
    Content = () => {

        const homeIconStyle = {
            width : '16rem',
            height : '16rem'
        };
        const{pagination} = this.state;
        const setter = {
            filterForm : {
                setFilterForm : (colVal, onSet) => this.setter('filterForm', colVal, onSet)
            },
            hotels : {
                setHotels : (colVal, onSet) => this.setter('hotels', colVal, onSet)
            }
        };
        const getter = {
            filterForm : {
                getFilterForm : () => this.getter('filterForm')
            },
            hotels : {
                getHotels : () => this.getter('hotels')
            }
        }

        return (
            <Fragment>
                <Row className='justify-content-center pb-5'>
                    <Col xs='auto' className='align-self-center'>
                        <Image src={houseIcon} style={homeIconStyle} />
                    </Col>
                    <Col xs={8}>
                        <FilterForm setter={setter.filterForm} getter={getter.filterForm} />
                    </Col>
                </Row>
                <div className='py-5'>
                    <Hotels setter={setter.hotels} getter={getter.hotels} />
                </div>
                {
                    pagination.show && (
                        <Stack direction='horizontal'>
                            <div className='ms-auto'>
                                <Pagn pagn={pagination} />
                            </div>
                        </Stack>
                    )
                }
            </Fragment>
        );
    };


    // other
    allSections = () => {

        this.allSectionsFetch();
    };


    // fetch
    allSectionsFetch = async () => {

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

            this.afterAllSections(data);
        }else if(statusCode===400 || statusCode===500){

            fctn.showInformModal(serverInfo.msg);
        }
    };


    // after fetch
    afterAllSections = (data) => {

        const filterForm = this.getter('filterForm');

        this.setter('filterForm', {
            ...filterForm,
            section : {
                ...filterForm.section,
                options : data.sections
            }
        });
    };


    // setter getter
    setter = (colName, colVal, onSet) => {

        this.setState({
            [colName] : colVal
        }, () => {

            onSet && onSet();
        });
    };
    getter = (colName) => {

        return this.state[colName];
    };
}

export default Home;