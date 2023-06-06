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
                status : undefined
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
        status : {
            asc : 11,
            desc : 12
        }
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
                show : false,
                name : {
                    value : ''
                },
                totalRoomNum : {
                    valueMin : '',
                    valueMax : ''
                },
                usedRoomNum : {
                    valueMin : '',
                    valueMax : ''
                },
                invalidRoomNum : {
                    valueMin : '',
                    valueMax : ''
                },
                price : {
                    valueMin : '',
                    valueMax : ''
                },
                status : {
                    value : ''
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
            <BackendMain titleText='房型列表' Content={this.Content} />
        );
    }

    // jsx
    Content = () => {

        const fctn = {
            roomTable : {
                changeOrder : this.changeOrder
            },
            filterModal : {
                searchTable : this.searchTable
            }
        }
        const {roomTable, pagination, filterModal} = this.state;

        const setter = {
            roomTable : {
                setRoomTable : (val, onSet) => this.setter('roomTable', val, onSet)
            },
            filterModal : {
                setFilterModal : (val, onSet) => this.setter('filterModal', val, onSet)
            }
        }

        return (
            <Fragment>
                <Container className='w-75'>
                    <RoomTable value={roomTable} setter={setter.roomTable} fctn={fctn.roomTable} />
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

        const name = filterModal.name.value;
        const totalNumMin = filterModal.totalRoomNum.valueMin;
        const totalNumMax = filterModal.totalRoomNum.valueMax;
        const usedNumMin = filterModal.usedRoomNum.valueMin;
        const usedNumMax = filterModal.usedRoomNum.valueMax;
        const invalidNumMin = filterModal.invalidRoomNum.valueMin;
        const invalidNumMax = filterModal.invalidRoomNum.valueMax;
        const priceMin = filterModal.price.valueMin;
        const priceMax = filterModal.price.valueMax;
        const status = filterModal.status.value;

        req.name = (name==='' ? undefined : name);
        req.totalNumMin = (totalNumMin==='' ? undefined : totalNumMin);
        req.totalNumMax = (totalNumMax==='' ? undefined : totalNumMax);
        req.usedNumMin = (usedNumMin==='' ? undefined : usedNumMin);
        req.usedNumMax = (usedNumMax==='' ? undefined : usedNumMax);
        req.invalidNumMin = (invalidNumMin==='' ? undefined : invalidNumMin);
        req.invalidNumMax = (invalidNumMax==='' ? undefined : invalidNumMax);
        req.priceMin = (priceMin==='' ? undefined : priceMin);
        req.priceMax = (priceMax==='' ? undefined : priceMax);
        req.status = (status==='' ? undefined : status);

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

        const {fctn} = this.props;
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
    changeOrderFetch = async (params) => {

        const {fctn} = this.props;
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
        }else if(statusCode===400 || statusCode===500){

            fctn.showInformModal(serverInfo.msg);
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
    updateState = (table, p) => {

        const {roomTable, pagination} = this.state;

        this.setter('roomTable', {
            ...roomTable,
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

export default RoomList;