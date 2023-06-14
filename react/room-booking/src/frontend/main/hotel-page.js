import urls from '../../files/urls.json';
import config from '../../files/config.json';
import houseIcon from '../../image/house-icon.png';
import React, { Component, Fragment } from 'react';
import { Col, Image, Row, Stack } from 'react-bootstrap';
import FilterForm from './hotelPage/filter-form';
import FrontendMain from '../../hoc/frontend-main';
import Introduction from './hotelPage/introduction';
import Rooms from './hotelPage/rooms';
import Pagn from '../../hoc/pagn';
import BuyModal from './hotelPage/buy-modal';
import { useLocation, useParams } from 'react-router-dom';
import axios from 'axios';


const constant = {
    fetch : {
        url : {
            getInfo : urls.frontend.hotelPage.getInfo
        },
        config : {
            timeout : config.fetch.timeout
        },
        req : {
            getInfo : {
                hotelId : ''
            }
        }
    }
}

class HotelPageWrapped extends Component {

    constructor(props){

        super(props);
        this.state = {
            filterForm : {
                validated : false,
                date : {
                    valueCheckinDate : this.props.data.checkinDate,
                    valueCheckoutDate : this.props.data.checkoutDate
                },
                number : {
                    value : this.props.data.number
                }
            },
            introduction : {
                imgUrl : '',
                hotelName : '',
                address : '',
                description : '',
                feature : {
                    items : []
                }
            },
            rooms : [],
            pagination : {
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

        this.getInfo();
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
            introduction : {
                setIntroduction : (colVal, onSet) => this.setter('introduction', colVal, onSet)
            }
        };
        const getter = {
            filterForm : {
                getFilterForm : () => this.getter('filterForm')
            },
            introduction : {
                getIntroduction : () => this.getter('introduction')
            }
        };
        const fctn = {
            filterForm : {
                showInformModal : this.props.fctn.showInformModal,
                closeInformModal : this.props.fctn.closeInformModal
            }
        };

        return (
            <Fragment>
                <Row className='justify-content-center'>
                    <Col xs='auto' className='align-self-center'>
                        <Image src={houseIcon} style={homeIconStyle} />
                    </Col>
                    <Col xs={8}>
                        <FilterForm setter={setter.filterForm} getter={getter.filterForm} fctn={fctn.filterForm} />
                    </Col>
                </Row>
                <div className='mt-5'>
                    <Introduction setter={setter.introduction} getter={getter.introduction} />
                </div>
                <div className='my-5 pt-5'>
                    <Rooms />
                </div>
                <Stack direction='horizontal'>
                    <div className='ms-auto'>
                        <Pagn pagn={pagination} />
                    </div>
                </Stack>
                <BuyModal />
            </Fragment>
        );
    }


    // other
    getInfo = () => {

        const req = constant.fetch.req.getInfo;
        const {data} = this.props;

        req.hotelId = data.hotelId;
        this.getInfoFetch(req);
    };


    // fetch
    getInfoFetch = async (params) => {

        const {fctn} = this.props;
        const {fetch} =  constant;
        const url = fetch.url.getInfo;
        const config = fetch.config;

        const {serverInfo, data} = await axios.get(url, {
                timeout : config.timeout,
                params : params
            })
            .then(rs => rs.data)
            .catch(error => console.error(error));

        const statusCode = serverInfo.statusCode;
        if(statusCode === 200){

            this.afterGetInfo(data);
        }else if(statusCode===400 || statusCode===500){

            fctn.showInformModal(serverInfo.msg);
        }
    };

    // after fetch
    afterGetInfo = (data) => {

        const {introduction} = this.state;

        this.setter('introduction', {
            ...introduction,
            imgUrl : data.imgUrl,
            hotelName : data.hotelName,
            address : data.address,
            description : data.description,
            feature : {
                ...introduction.feature,
                items : data.features
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

const HotelPage = props => {

    const params = useParams();
    const location = useLocation();
    const data = {
        ...params,
        ...location.state
    };

    return (<HotelPageWrapped {...props} data={data} />);
};

export default HotelPage;