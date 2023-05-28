import urls from '../../files/urls.json';
import config from '../../files/config.json';
import React, { Component, Fragment } from 'react';
import { Button, Container, Stack } from 'react-bootstrap';
import RoomTable from './room_list/room-table';
import BackendMain from '../../hoc/backend-main';
import Pagn from '../../hoc/pagn';
import FilterModal from './room_list/filter-modal';
import axios from 'axios';


const constant ={
    fetch : {
        url : {
            searchTable : urls.backend.roomList.searchTable
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
            }
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
                showFirst : true,
                showPrev : true,
                pages : [1],
                showNext : true,
                showLast : true,
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
                getTableRows : this.getTableRows
            },
            filterModal : {
                getFilterModalVal : this.getFilterModalVal,
                setFilterModalVal : this.setFilterModalVal,
                tableUpdate : this.tableUpdate
            }
        }
        const {filterModal} = this.state;
        const {pagination} = this.state;

        return (
            <Fragment>
                <Container className='w-75'>
                    <RoomTable fctn={fctn.roomTable} />
                    <Stack direction='horizontal' className='mt-5'>
                        <div>
                            <Button variant='outline-primary' onClick={() => this.showFilterModal()}>篩選</Button>
                        </div>
                        <div className='ms-auto'>
                            <Pagn showFirst={pagination.showFirst} showPrev={pagination.showPrev} pages={pagination.pages} 
                                    showNext={pagination.showNext} showLast={pagination.showLast} currentPage={pagination.currentPage} />
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


    // after fetch
    afterSearchTable = (data) => {

        const {roomTable} = this.state;
        const {table, pagination} = data;

        this.setState({
            roomTable : {
                ...roomTable,
                tableRows : table.tableRows
            },
            pagination : {
                showFirst : pagination.showFirst,
                showPrev : pagination.showPrev,
                pages : pagination.pages,
                showNext : pagination.showNext,
                showLast : pagination.showLast,
                currentPage : pagination.currentPage
            }
        });
    }


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