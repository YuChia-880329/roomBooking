import urls from '../../files/urls.json';
import config from '../../files/config.json';
import React, { Component, Fragment } from 'react';
import { Button, Container, Stack } from 'react-bootstrap';
import BookingOrderTable from './booking_order_list/booking-order-table';
import Pagn from '../../hoc/pagn';
import FilterModal from './booking_order_list/filterModal';
import BackendMain from '../../hoc/backend-main';
import axios from 'axios';


const constant = {
    fetch : {
        url : {
            searchTable : urls.backend.bookingOrderList.searchTable,
            changeOrder : urls.backend.bookingOrderList.changeOrder,
            turnPage : urls.backend.bookingOrderList.turnPage
        },
        config : {
            timeout : config.fetch.timeout
        },
        req : {
            searchTable : {
                idMin : undefined,
                idMax : undefined,
                clientName : undefined,
                clientPhone : undefined,
                roomType : undefined,
                roomNumMin : undefined,
                roomNumMax : undefined,
                priceMin : undefined,
                priceMax : undefined,
                payMethod : undefined,
                checkinDateTimeFrom : undefined,
                checkinDateTimeTo : undefined,
                checkoutDateFrom : undefined,
                checkoutDateTo : undefined,
                useDayMin : undefined,
                useDayMax : undefined,
                totalPriceMin : undefined,
                totalPriceMax : undefined
            },
            turnPage : {
                page : 1
            },
            changeOrder : {
                order : 1
            }
        }
    },
    orderCode : {
        id : {
            asc : 1,
            desc : 2
        },
        clientName : {
            asc : 3,
            desc : 4
        },
        clientPhone : {
            asc : 5,
            desc : 6
        },
        roomName : {
            asc : 7,
            desc : 8
        },
        roomNum : {
            asc : 9,
            desc : 10
        },
        price : {
            asc : 11,
            desc : 12
        },
        payMethod : {
            asc : 13,
            desc : 14
        },
        checkinDateTime : {
            asc : 15,
            desc : 16
        },
        checkoutDate : {
            asc : 17,
            desc : 18
        },
        useDay : {
            asc : 19,
            desc : 20
        },
        totalPrice : {
            asc : 21,
            desc : 22
        },
    }
}
class BookingOrderList extends Component {

    constructor(props){

        super(props);
        this.state = {
            bookingOrderTable : {
                tableRows : []
            },
            filterModal : {
                show : false,
                id : {
                    valueMin : '',
                    valueMax : ''
                },
                clientName : {
                    value : ''
                },
                clientPhone : {
                    value : ''
                },
                roomType : {
                    options : [],
                    value : ''
                },
                roomNum : {
                    valueMin : '',
                    valueMax : ''
                },
                price : {
                    valueMin : '',
                    valueMax : ''
                },
                payMethod : {
                    options : [],
                    values : []
                },
                checkinDateTime : {
                    valueFrom : '',
                    valueTo : ''
                },
                checkoutDate : {
                    valueFrom : '',
                    valueTo : ''
                },
                useDay : {
                    valueMin : '',
                    valueMax : ''
                },
                totalPrice : {
                    valueMin : '',
                    valueMax : ''
                }
            },
            pagination : {
                first : {
                    show : false,
                    toPage : 1
                },
                prev : {
                    show : false,
                    toPage : 1
                },
                pages : [1],
                next : {
                    show : false,
                    toPage : 1
                },
                last : {
                    show : false,
                    toPage : 1 
                },
                currentPage : 1
            }
        };
    }

    componentDidMount(){

        const {fctn} = this.props;

        fctn.checkLogin(() => {

            this.searchTable();
        });
    }

    render() {

        return (
            <BackendMain titleText='訂房訂單' Content={this.Content} />
        );
    }

    // jsx
    Content = () => {

        const fctn = {
            bookingOrderTable : {
                changeOrder : this.changeOrder
            },
            filterModal : {
                searchTable : this.searchTable
            }
        }
        const {bookingOrderTable, pagination, filterModal} = this.state;

        const setter = {
            bookingOrderTable : {
                setBookingOrderTable : (val, onSet) => this.setter('bookingOrderTable', val, onSet)
            },
            filterModal : {
                setFilterModal : (val, onSet) => this.setter('filterModal', val, onSet)
            }
        }
        
        
        return (
            <Fragment>
                <Container className='w-75'>
                    <BookingOrderTable value={bookingOrderTable} setter={setter.bookingOrderTable} fctn={fctn.bookingOrderTable} />
                    <Stack direction='horizontal' className='mt-5'>
                        <div>
                            <Button variant='outline-primary' onClick={this.onClickShowFilterBtn}>篩選</Button>
                        </div>
                        <div className='ms-auto'>
                        <Pagn pagn={pagination} turnPage={this.turnPage} />
                        </div>
                    </Stack>
                </Container>
                <FilterModal value={filterModal} setter={setter.filterModal} fctn={fctn.filterModal} />
            </Fragment>
        );
    };

    // on
    onClickShowFilterBtn = (event) => {

        const {filterModal} = this.state;

        this.setter('filterModal', {
            ...filterModal,
            show : true
        });
    }

    // other
    searchTable = () => {

        const req = constant.fetch.req.searchTable;
        const {filterModal} = this.state;

        const idMin = filterModal.id.valueMin;
        const idMax = filterModal.id.valueMax;
        const clientName = filterModal.clientName.value;
        const clientPhone = filterModal.clientPhone.value;
        const roomType = filterModal.roomType.value;
        const roomNumMin = filterModal.roomNum.valueMin;
        const roomNumMax = filterModal.roomNum.valueMax;
        const priceMin = filterModal.price.valueMin;
        const priceMax = filterModal.price.valueMax;
        const payMethod = filterModal.payMethod.values;
        const checkinDateTimeFrom = filterModal.checkinDateTime.valueFrom;
        const checkinDateTimeTo = filterModal.checkinDateTime.valueTo;
        const checkoutDateFrom = filterModal.checkoutDate.valueFrom;
        const checkoutDateTo = filterModal.checkoutDate.valueTo;
        const useDayMin = filterModal.useDay.valueMin;
        const useDayMax = filterModal.useDay.valueMax;
        const totalPriceMin = filterModal.totalPrice.valueMin;
        const totalPriceMax = filterModal.totalPrice.valueMax;

        req.idMin = (idMin==='' ? undefined : idMin);
        req.idMax = (idMax==='' ? undefined : idMax);
        req.clientName = (clientName==='' ? undefined : clientName);
        req.clientPhone = (clientPhone==='' ? undefined : clientPhone);
        req.roomType = (roomType==='' ? undefined : roomType);
        req.roomNumMin = (roomNumMin==='' ? undefined : roomNumMin);
        req.roomNumMax = (roomNumMax==='' ? undefined : roomNumMax);
        req.priceMin = (priceMin==='' ? undefined : priceMin);
        req.priceMax = (priceMax==='' ? undefined : priceMax);
        req.payMethod = (payMethod===[] ? undefined : payMethod);
        req.checkinDateTimeFrom = (checkinDateTimeFrom==='' ? undefined : checkinDateTimeFrom);
        req.checkinDateTimeTo = (checkinDateTimeTo==='' ? undefined : checkinDateTimeTo);
        req.checkoutDateFrom = (checkoutDateFrom==='' ? undefined : checkoutDateFrom);
        req.checkoutDateTo = (checkoutDateTo==='' ? undefined : checkoutDateTo);
        req.useDayMin = (useDayMin==='' ? undefined : useDayMin);
        req.useDayMax = (useDayMax==='' ? undefined : useDayMax);
        req.totalPriceMin = (totalPriceMin==='' ? undefined : totalPriceMin);
        req.totalPriceMax = (totalPriceMax==='' ? undefined : totalPriceMax);

        this.searchTableFetch(req);
    };
    turnPage = (page) => {

        const req = constant.fetch.req.turnPage;

        req.page = page;
        this.turnPageFetch(req);
    };
    changeOrder = (colName, direction) => {

        const req = constant.fetch.req.changeOrder;
        const orderCode = constant.orderCode;

        req.order = orderCode[colName][direction===0 ? 'asc' : 'desc'];
        this.changeOrderFetch(req);

    };
    
    // fetch
    searchTableFetch = async (params) => {

        const Qs = require('qs');
        const {fctn} = this.props;
        const {fetch} =  constant;
        const url = fetch.url.searchTable;
        const config = fetch.config;

        const myAxios = axios.create({
            paramsSerializer: params => Qs.stringify(params, {arrayFormat: 'repeat'})
        });
        const {serverInfo, data} = await myAxios.get(url, {
                timeout : config.timeout,
                withCredentials: true,
                params : params
            })
            .then(rs => rs.data)
            .catch(error => console.error(error));

        const statusCode = serverInfo.statusCode;
        if(statusCode === 200){

            this.afterSearchTable(data);
        }else if(statusCode===400 || statusCode===500){

            fctn.showInformModal(serverInfo.msg);
        }
    };
    turnPageFetch = async (params) => {

        const {fetch} =  constant;
        const {fctn} = this.props;
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
    changeOrderFetch = async (params) => {

        const {fetch} =  constant;
        const {fctn} = this.props;
        const url = fetch.url.changeOrder;
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

            this.afterChangeOrder(data);
        }else if(statusCode===400 || statusCode===500){

            fctn.showInformModal(serverInfo.msg);
        }
    };


     // after fetch
     afterSearchTable = (data) => {

        const {table, pagination} = data;

        this.updateState(table, pagination);
    };
    afterTurnPage = (data) => {

        const {table, pagination} = data;

        this.updateState(table, pagination);
    };
    afterChangeOrder = (data) => {

        const {table, pagination} = data;

        this.updateState(table, pagination);
    }
    updateState = (table, p) => {

        const {bookingOrderTable, pagination} = this.state;

        this.setter('bookingOrderTable', {
            ...bookingOrderTable,
            tableRows : table.tableRows
        }, () => {

            this.setter('pagination', {
                ...pagination,
                first : {
                    show : p.first.show,
                    toPage : p.first.toPage
                },
                prev : {
                    show : p.prev.show,
                    toPage : p.prev.toPage
                },
                pages : p.pages,
                next : {
                    show : p.next.show,
                    toPage : p.next.toPage
                },
                last : {
                    show : p.last.show,
                    toPage : p.last.toPage
                },
                currentPage : p.currentPage
            })
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

export default BookingOrderList;