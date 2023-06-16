import {getToday, toDateString} from '../../files/util';
import urls from '../../files/urls.json';
import config from '../../files/config.json';
import houseIcon from '../../image/house-icon.png';
import React, { Component, Fragment, createRef } from 'react';
import { Col, Image, Row, Stack } from 'react-bootstrap';
import FilterForm from './hotelPage/filter-form';
import FrontendMain from '../../hoc/frontend-main';
import Introduction from './hotelPage/introduction';
import Rooms from './hotelPage/rooms';
import Pagn from '../../hoc/pagn';
import BuyModal from './hotelPage/buy-modal';
import { useLocation, useParams } from 'react-router-dom';
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
            getInfo : urls.frontend.hotelPage.getInfo,
            search : urls.frontend.hotelPage.search,
            turnPage : urls.frontend.hotelPage.turnPage
        },
        config : {
            timeout : config.fetch.timeout
        },
        req : {
            getInfo : {
                hotelId : ''
            },
            search : {
                checkinDate : '',
                checkoutDate : '',
                hotelId : '',
                numCode : ''
            },
            turnPage : {
                page : ''
            }
        }
    }
}

class HotelPageWrapped extends Component {

    buyModalRef = createRef();

    constructor(props){

        super(props);
        this.state = {
            filterForm : {
                validated : false,
                date : {
                    valueCheckinDate : this.props.data.checkinDate || todayText,
                    valueCheckoutDate : this.props.data.checkoutDate || tomorrowText
                },
                number : {
                    value : this.props.data.number || '1'
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
            rooms : {
                items : []
            },
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
            },
            buyModal : {
                validated : false,
                show : false,
                onHide : (event => this.closeBuyModal()),
                onClickOkBtn : (event => this.closeBuyModal()),
                roomId : 0,
                hotelName : '',
                roomName : '',
                validNum : '',
                price : '',
                date : {
                    valueCheckinDate : '',
                    valueCheckoutDate : ''
                },
                checkinTime : {
                    value : ''
                },
                num : {
                    value : ''
                }
            }
        };
    }

    componentDidMount(){

        this.getInfo(() => {

            this.search();
        });
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
            },
            rooms : {
                setRooms : (colVal, onSet) => this.setter('rooms', colVal, onSet),
                setBuyModal : (colVal, onSet) => this.setter('buyModal', colVal, onSet)
            },
            buyModal : {
                setBuyModal : (colVal, onSet) => this.setter('buyModal', colVal, onSet)
            }
        };
        const getter = {
            filterForm : {
                getFilterForm : () => this.getter('filterForm')
            },
            introduction : {
                getIntroduction : () => this.getter('introduction')
            },
            rooms : {
                getRooms : () => this.getter('rooms'),
                getBuyModal : () => this.getter('buyModal')
            },
            buyModal : {
                getBuyModal : () => this.getter('buyModal')
            }
        };
        const fctn = {
            filterForm : {
                showInformModal : this.props.fctn.showInformModal,
                closeInformModal : this.props.fctn.closeInformModal,
                search : this.search
            },
            rooms : {
                showInformModal : this.props.fctn.showInformModal,
                closeInformModal : this.props.fctn.closeInformModal,
                showConfirmModal : this.props.fctn.showConfirmModal,
                closeConfirmModal : this.props.fctn.closeConfirmModal,
                showBuyModal : this.showBuyModal,
                closeBuyModal : this.closeBuyModal,
                setBuyModal : this.setBuyModal,
                submitBuyModal : this.submitBuyModal
            },
            buyModal : {
                showInformModal : this.props.fctn.showInformModal,
                closeInformModal : this.props.fctn.closeInformModal,
                showConfirmModal : this.props.fctn.showConfirmModal,
                closeConfirmModal : this.props.fctn.closeConfirmModal
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
                    <Rooms setter={setter.rooms} getter={getter.rooms} fctn={fctn.rooms} />
                </div>
                <Stack direction='horizontal'>
                    <div className='ms-auto'>
                        <Pagn pagn={pagination} turnPage={this.turnPage} />
                    </div>
                </Stack>
                <BuyModal setter={setter.buyModal} getter={getter.buyModal} fctn={fctn.buyModal} ref={this.buyModalRef} />
            </Fragment>
        );
    }


    // other
    getInfo = (onSuccess) => {

        const req = constant.fetch.req.getInfo;
        const {data} = this.props;

        req.hotelId = data.hotelId;
        this.getInfoFetch(req, onSuccess);
    };
    search = () => {

        const req = constant.fetch.req.search;
        const {data} = this.props;
        const {filterForm} = this.state;

        req.checkinDate = filterForm.date.valueCheckinDate;
        req.checkoutDate = filterForm.date.valueCheckoutDate;
        req.numCode = filterForm.number.value;
        req.hotelId = data.hotelId;
        this.searchFetch(req);
    };
    turnPage = (page) => {

        const req = constant.fetch.req.turnPage;

        req.page = page;
        this.turnPageFetch(req);
    };
    showBuyModal = (onClickOkBtn, onHide) => {

        const {buyModal} = this.state;

        this.setter('buyModal', {
            ...buyModal,
            show : true,
            onHide : onHide || (event => this.closeBuyModal()),
            onClickOkBtn : onClickOkBtn || (event => this.closeBuyModal())
        });
    };
    closeBuyModal = () => {

        const {buyModal} = this.state;

        this.setter('buyModal', {
            ...buyModal,
            show : false
        });
    }
    setBuyModal = (roomId, roomName, validNum, price, num, onSet) => {

        const {filterForm, introduction, buyModal} = this.state;

        this.setter('buyModal', {
            ...buyModal,
            roomId : roomId,
            hotelName : introduction.hotelName,
            roomName : roomName,
            validNum : validNum,
            price : price,
            date : {
                valueCheckinDate : filterForm.date.valueCheckinDate,
                valueCheckoutDate : filterForm.date.valueCheckoutDate
            },
            num : {
                value : num
            }
        }, () => {
            
            onSet && onSet();
        });
    };
    submitBuyModal = () => {

        this.buyModalRef.current.submit();
    }



    // fetch
    getInfoFetch = async (params, onSuccess) => {

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

            this.afterGetInfo(data, onSuccess);
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
    afterGetInfo = (data, onSuccess) => {

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
        }, () => {

            onSuccess && onSuccess();
        });
    };
    afterSearch = (data) => {

        this.updateState(data);
    };
    afterTurnPage = (data) => {

        this.updateState(data);
    };
    updateState = (data) => {

        const {rooms, pagination} = this.state;

        this.setter('rooms', {
            ...rooms,
            items : data.rooms.map(room => ({
                ...room,
                shoppingCartForm : {
                    validated : false,
                    value : ''
                }
            }))
        }, () => {

            this.setter('pagination', {
                ...pagination,
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