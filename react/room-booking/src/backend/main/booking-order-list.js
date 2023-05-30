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
            searchTable : urls.backend.bookingOrderList.searchTable
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
                roomName : undefined,
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
                form : {
                    value : {
                        idMin : '',
                        idMax : '',
                        clientName : '',
                        clientPhone : '',
                        roomName : '',
                        roomNumMin : '',
                        roomNumMax : '',
                        priceMin : '',
                        priceMax : '',
                        payMethod : [],
                        checkinDateTimeFrom : '',
                        checkinDateTimeTo : '',
                        checkoutDateFrom : '',
                        checkoutDateTo : '',
                        useDayMin : '',
                        useDayMax : '',
                        totalPriceMin : '',
                        totalPriceMax : ''
                    }
                },
                show : false
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

    // componentDidMount(){

    //     this.tableUpdate();
    // }

    render() {
        
        return (
            <BackendMain titleText='訂房訂單' Content={this.Content} />
        );
    }

    // jsx
    Content = () => {

        const fctn = {
            filterModal : {
                getFilterModalVal : this.getFilterModalVal,
                setFilterModalVal : this.setFilterModalVal,
                tableUpdate : this.tableUpdate
            }
        }
        const {filterModal, pagination} = this.state;

        const pagn = {
            first : pagination.first,
            prev : pagination.prev,
            pages : pagination.pages,
            next : pagination.next,
            last : pagination.last,
            currentPage : pagination.currentPage
        };
        
        return (
            <Fragment>
                <Container className='w-75'>
                    <BookingOrderTable />
                    <Stack direction='horizontal' className='mt-5'>
                        <div>
                            <Button variant='outline-primary' onClick={() => this.showFilterModal()}>篩選</Button>
                        </div>
                        <div className='ms-auto'>
                        <Pagn pagn={{first : {}, prev : {}, pages : [], next : {}, last : {}, currentPage : {}}} />
                        </div>
                    </Stack>
                </Container>
                <FilterModal fctn={fctn.filterModal} show={filterModal.show} onHide={this.filterModalOnHide} />
            </Fragment>
        );
    };

    // other
    showFilterModal = () => {

        const {filterModal} = this.state;

        this.setState({
            filterModal : {
                ...filterModal,
                show : true
            }
        });
    };
    tableUpdate = () => {

        const req = constant.fetch.req.searchTable;
        const {filterModal} = this.state;

        const idMin = filterModal.form.value.idMin;
        const idMax = filterModal.form.value.idMax;
        const clientName = filterModal.form.value.clientName;
        const clientPhone = filterModal.form.value.clientPhone;
        const roomName = filterModal.form.value.roomName;
        const roomNumMin = filterModal.form.value.roomNumMin;
        const roomNumMax = filterModal.form.value.roomNumMax;
        const priceMin = filterModal.form.value.priceMin;
        const priceMax = filterModal.form.value.priceMax;
        const payMethod = filterModal.form.value.payMethod;
        const checkinDateTimeFrom = filterModal.form.value.checkinDateTimeFrom;
        const checkinDateTimeTo = filterModal.form.value.checkinDateTimeTo;
        const checkoutDateFrom = filterModal.form.value.checkoutDateFrom;
        const checkoutDateTo = filterModal.form.value.checkoutDateTo;
        const useDayMin = filterModal.form.value.useDayMin;
        const useDayMax = filterModal.form.value.useDayMax;
        const totalPriceMin = filterModal.form.value.totalPriceMin;
        const totalPriceMax = filterModal.form.value.totalPriceMax;

        req.idMin = (idMin==='' ? undefined : idMin);
        req.idMax = (idMax==='' ? undefined : idMax);
        req.clientName = (clientName==='' ? undefined : clientName);
        req.clientPhone = (clientPhone==='' ? undefined : clientPhone);
        req.roomName = (roomName==='' ? undefined : roomName);
        req.roomNumMin = (roomNumMin==='' ? undefined : roomNumMin);
        req.roomNumMax = (roomNumMax==='' ? undefined : roomNumMax);
        req.priceMin = (priceMin==='' ? undefined : priceMin);
        req.priceMax = (priceMax==='' ? undefined : priceMax);
        req.payMethod = (payMethod==='' ? undefined : payMethod);
        req.checkinDateTimeFrom = (checkinDateTimeFrom==='' ? undefined : checkinDateTimeFrom);
        req.checkinDateTimeTo = (checkinDateTimeTo==='' ? undefined : checkinDateTimeTo);
        req.checkoutDateFrom = (checkoutDateFrom==='' ? undefined : checkoutDateFrom);
        req.checkoutDateTo = (checkoutDateTo==='' ? undefined : checkoutDateTo);
        req.useDayMin = (useDayMin==='' ? undefined : useDayMin);
        req.useDayMax = (useDayMax==='' ? undefined : useDayMax);
        req.totalPriceMin = (totalPriceMin==='' ? undefined : totalPriceMin);
        req.totalPriceMax = (totalPriceMax==='' ? undefined : totalPriceMax);

        this.searchTable(req);
    };

    // on
    filterModalOnHide = () => {

        const {filterModal} = this.state;

        this.setState({
            filterModal : {
                ...filterModal,
                show : false
            }
        });
    }
    // pageOnClick = (page) => {

    //     const req = constant.fetch.req.turnPage;

    //     req.page = page;
    //     this.turnPage(req);
    // }
    // orderOnClick = (colName, direction) => {

    //     const req = constant.fetch.req.changeOrder;
    //     const orderCode = constant.orderCode;

    //     req.order = orderCode[colName][direction===0 ? 'asc' : 'desc'];
    //     this.changeOrder(req);
    // }
    
    // fetch
    searchTable = async (params) => {

        const {fetch} =  constant;
        const url = fetch.url.searchTable;
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

            this.afterSearchTable(data);
        }
    };
    // turnPage = async (params) => {

    //     const {fetch} =  constant;
    //     const url = fetch.url.turnPage;
    //     const config = fetch.config;

    //     const {serverInfo, data} = await axios.get(url, {
    //             timeout : config.timeout,
    //             withCredentials: true,
    //             params : params
    //         })
    //         .then(rs => rs.data)
    //         .catch(error => console.error(error));

    //     const statusCode = serverInfo.statusCode;
    //     if(statusCode === 200){

    //         this.afterTurnPage(data);
    //     }
    // };
    // changeOrder = async (params) => {

    //     const {fetch} =  constant;
    //     const url = fetch.url.changeOrder;
    //     const config = fetch.config;

    //     const {serverInfo, data} = await axios.get(url, {
    //             timeout : config.timeout,
    //             withCredentials: true,
    //             params : params
    //         })
    //         .then(rs => rs.data)
    //         .catch(error => console.error(error));

    //     const statusCode = serverInfo.statusCode;
    //     if(statusCode === 200){

    //         this.afterChangeOrder(data);
    //     }
    // };


     // after fetch
     afterSearchTable = (data) => {

        // const {table, pagination} = data;

        // this.updateState(table, pagination);
        console.log('data : ', data);
    };
    // afterTurnPage = (data) => {

    //     const {table, pagination} = data;

    //     this.updateState(table, pagination);
    // };
    // afterChangeOrder = (data) => {

    //     const {table, pagination} = data;

    //     this.updateState(table, pagination);
    // }
    updateState = (table, pagination) => {

        const {bookingOrderTable} = this.state;

        this.setState({
            bookingOrderTable : {
                ...bookingOrderTable,
                tableRows : table.tableRows
            },
            pagination : {
                ...this.state.pagination,
                first : {
                    show : pagination.first.show,
                    toPage : pagination.first.toPage
                },
                prev : {
                    show : pagination.prev.show,
                    toPage : pagination.prev.toPage
                },
                pages : pagination.pages,
                next : {
                    show : pagination.next.show,
                    toPage : pagination.next.toPage
                },
                last : {
                    show : pagination.last.show,
                    toPage : pagination.last.toPage
                },
                currentPage : pagination.currentPage
            }
        });
    };

    // getter setter
    getFilterModalVal = (colName) => {

        return this.state.filterModal.form.value[colName];
    }
    setFilterModalVal = (colName, colVal) => {

        const {filterModal} = this.state;

        this.setState({
            filterModal : {
                ...filterModal,
                form : {
                    ...filterModal.form,
                    value : {
                        ...filterModal.form.value,
                        [colName] : colVal
                    }
                }
            }
        });
    }
    // getTableRows = () => {

    //     const {roomTable} = this.state;

    //     return roomTable.tableRows;
    // }
}

export default BookingOrderList;