import urls from '../../files/urls.json';
import config from '../../files/config.json';
import React, { Component, Fragment } from 'react';
import { Button, Container, Stack } from 'react-bootstrap';
import RoomTable from './room_list/room-table';
import BackendMain from '../../hoc/backend-main';
import Pagn from '../../hoc/pagn';
import FilterModal from './room_list/filter-modal';
import axios from 'axios';


const constant = {
    fetch : {
        url : {
            searchTable : urls.backend.roomList.searchTable,
            turnPage : urls.backend.roomList.turnPage,
            changeOrder : urls.backend.roomList.changeOrder
        },
        config : {
            timeout : config.fetch.timeout
        },
        req : {
            searchTable : {
                name : undefined,
                totalNumMin : undefined,
                totalNumMax : undefined,
                usedNumMin : undefined,
                usedNumMax : undefined,
                invalidNumMin : undefined,
                invalidNumMax : undefined,
                priceMin : undefined,
                priceMax : undefined,
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
        name : {
            asc : 1,
            desc : 2
        },
        totalNum : {
            asc : 3,
            desc : 4
        },
        usedNum : {
            asc : 5,
            desc : 6
        },
        invalidNum : {
            asc : 7,
            desc : 8
        },
        price : {
            asc : 9,
            desc : 10
        },
    }
}
class RoomList extends Component {

    constructor(props){

        super(props);
        this.state = {
            roomTable : {
                tableRows : []
            },
            filterModal : {
                form : {
                    value : {
                        name : '',
                        totalRoomNumMin : '',
                        totalRoomNumMax : '',
                        usedRoomNumMin : '',
                        usedRoomNumMax : '',
                        invalidRoomNumMin : '',
                        invalidRoomNumMax : '',
                        priceMin : '',
                        priceMax : ''
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

    componentDidMount(){

        this.tableUpdate();
    }

    render() {

        return (
            <BackendMain titleText='房型列表' Content={this.Content} />
        );
    }

    // jsx
    Content = () => {

        const fctn = {
            roomTable : {
                getTableRows : this.getTableRows,
                orderOnClick : this.orderOnClick
            },
            filterModal : {
                getFilterModalVal : this.getFilterModalVal,
                setFilterModalVal : this.setFilterModalVal,
                tableUpdate : this.tableUpdate
            },
            pagn : {
                pageOnClick : this.pageOnClick
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
                    <RoomTable fctn={fctn.roomTable} />
                    <Stack direction='horizontal' className='mt-5'>
                        <div>
                            <Button variant='outline-primary' onClick={() => this.showFilterModal()}>篩選</Button>
                        </div>
                        <div className='ms-auto'>
                            <Pagn pagn={pagn} fctn={fctn.pagn} />
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

        const name = filterModal.form.value.name;
        const totalNumMin = filterModal.form.value.totalRoomNumMin;
        const totalNumMax = filterModal.form.value.totalRoomNumMax;
        const usedNumMin = filterModal.form.value.usedRoomNumMin;
        const usedNumMax = filterModal.form.value.usedRoomNumMax;
        const invalidNumMin = filterModal.form.value.invalidRoomNumMin;
        const invalidNumMax = filterModal.form.value.invalidRoomNumMax;
        const priceMin = filterModal.form.value.priceMin;
        const priceMax = filterModal.form.value.priceMax;

        req.name = (name==='' ? undefined : name);
        req.totalNumMin = (totalNumMin==='' ? undefined : totalNumMin);
        req.totalNumMax = (totalNumMax==='' ? undefined : totalNumMax);
        req.usedNumMin = (usedNumMin==='' ? undefined : usedNumMin);
        req.usedNumMax = (usedNumMax==='' ? undefined : usedNumMax);
        req.invalidNumMin = (invalidNumMin==='' ? undefined : invalidNumMin);
        req.invalidNumMax = (invalidNumMax==='' ? undefined : invalidNumMax);
        req.priceMin = (priceMin==='' ? undefined : priceMin);
        req.priceMax = (priceMax==='' ? undefined : priceMax);

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
    pageOnClick = (page) => {

        const req = constant.fetch.req.turnPage;

        req.page = page;
        this.turnPage(req);
    }
    orderOnClick = (colName, direction) => {

        const req = constant.fetch.req.changeOrder;
        const orderCode = constant.orderCode;

        req.order = orderCode[colName][direction===0 ? 'asc' : 'desc'];
        this.changeOrder(req);
    }


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
    turnPage = async (params) => {

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
        }
    };
    changeOrder = async (params) => {

        const {fetch} =  constant;
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
        }
    };


    // after fetch
    afterSearchTable = (data) => {

        const {table, pagination} = data;

        this.updateState(table, pagination);
    }
    afterTurnPage = (data) => {

        const {table, pagination} = data;

        this.updateState(table, pagination);
    };
    afterChangeOrder = (data) => {

        const {table, pagination} = data;

        this.updateState(table, pagination);
    }
    updateState = (table, pagination) => {

        const {roomTable, p} = this.state;

        this.setState({
            roomTable : {
                ...roomTable,
                tableRows : table.tableRows
            },
            pagination : {
                ...p,
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

    getTableRows = () => {

        const {roomTable} = this.state;

        return roomTable.tableRows;
    }
}

export default RoomList;