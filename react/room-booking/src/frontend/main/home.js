import {getToday, toDateString} from '../../files/util';
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

const today = getToday();
const todayText = toDateString(today);
const tomorrow = {
    year : today.year,
    month : today.month,
    day : today.day+1
}
const tomorrowText = toDateString(tomorrow);

const constant = {
    fetch : {
        url : {
            allSections : urls.frontend.home.allSections,
            search : urls.frontend.home.search,
            turnPage : urls.frontend.home.turnPage
        },
        config : {
            timeout : config.fetch.timeout
        },
        req : {
            search : {
                checkinDate : '',
                checkoutDate : '',
                numCode : '',
                sectionCode : ''
            },
            turnPage : {
                page : ''
            }
        }
    }
}

class Home extends Component {

    constructor(props){

        super(props);
        this.state = {
            filterForm : {
                validated : false,
                date : {
                    valueCheckinDate : todayText,
                    valueCheckoutDate : tomorrowText
                },
                number : {
                    value : '1'
                },
                section : {
                    options : [],
                    value : 'TPE'
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
                getHotels : () => this.getter('hotels'),
                getFilterForm : () => this.getter('filterForm')
            }
        };
        const fctn = {
            filterForm : {
                showInformModal : this.props.fctn.showInformModal,
                closeInformModal : this.props.fctn.closeInformModal,
                search : this.search
            }
        };

        return (
            <Fragment>
                <Row className='justify-content-center pb-5'>
                    <Col xs='auto' className='align-self-center'>
                        <Image src={houseIcon} style={homeIconStyle} />
                    </Col>
                    <Col xs={8}>
                        <FilterForm setter={setter.filterForm} getter={getter.filterForm} fctn={fctn.filterForm} />
                    </Col>
                </Row>
                <div className='py-5'>
                    <Hotels setter={setter.hotels} getter={getter.hotels} />
                </div>
                {
                    pagination.show && (
                        <Stack direction='horizontal'>
                            <div className='ms-auto'>
                                <Pagn pagn={pagination} turnPage={this.turnPage} />
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
    search = () => {

        const params = constant.fetch.req.search;
        const {filterForm} = this.state;

        params.checkinDate = filterForm.date.valueCheckinDate;
        params.checkoutDate = filterForm.date.valueCheckoutDate;
        params.numCode = filterForm.number.value;
        params.sectionCode = filterForm.section.value;

        this.searchFetch(params);
    }
    turnPage = (page) => {

        const req = constant.fetch.req.turnPage;

        req.page = page;
        this.turnPageFetch(req);
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
    searchFetch = async (params) => {

        const {fctn} = this.props;
        const {fetch} =  constant;
        const url = fetch.url.search;
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

            this.afterSearch(data);
        }else if(statusCode===400 || statusCode===500){

            fctn.showInformModal(serverInfo.msg);
        }
    };
    turnPageFetch = async (params) => {

        const {fctn} = this.props;
        const {fetch} =  constant;
        const url = fetch.url.turnPage;
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

            this.afterTurnPage(data);
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
    afterSearch = (data) => {

        this.updateState(data);
    };
    afterTurnPage = (data) => {

        this.updateState(data);
    };
    updateState = (data) => {

        const {hotels, pagination} = this.state;

        this.setter('hotels', {
            ...hotels,
            items : data.hotels
        }, () => {

            this.setter('pagination', {
                ...pagination,
                show : true,
                first : {
                    ...pagination.first,
                    show : data.pagination.first.show,
                    toPage : data.pagination.first.toPage
                },
                prev : {
                    ...pagination.prev,
                    show : data.pagination.prev.show,
                    toPage : data.pagination.prev.toPage
                },
                pages : data.pagination.pages,
                next : {
                    ...pagination.next,
                    show : data.pagination.next.show,
                    toPage : data.pagination.next.toPage
                },
                last : {
                    ...pagination.last,
                    show : data.pagination.last.show,
                    toPage : data.pagination.last.toPage
                },
                currentPage : data.pagination.currentPage
            });
        });
    }


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