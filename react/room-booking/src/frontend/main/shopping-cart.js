import {getToday} from '../../files/util';
import urls from '../../files/urls.json';
import config from '../../files/config.json';
import React, { Component, Fragment } from 'react';
import FrontendMain from '../../hoc/frontend-main';
import { Col, Row, Stack } from 'react-bootstrap';
import Item from './shoppingCart/item';
import TotalPrice from './shoppingCart/total-price';
import Pagn from '../../hoc/pagn';
import axios from 'axios';

const today = getToday();
const constant = {
    fetch : {
        url : {
            show : urls.frontend.shoppingCart.show,
            delete : urls.frontend.shoppingCart.delete,
            payMethodOptions : urls.frontend.shoppingCart.payMethodOptions,
            turnPage : urls.frontend.shoppingCart.turnPage,
            checkout : urls.frontend.shoppingCart.checkout
        },
        config : {
            timeout : config.fetch.timeout
        },
        req : {
            delete : {
                itemId : -1
            },
            turnPage : {
                page : ''
            },
            checkout : {
                payMethod : {
                    name : '',
                    needCreditCard : false,
                    creditCard : {
                        cardNumber1 : '',
                        cardNumber2 : '',
                        cardNumber3 : '',
                        cardNumber4 : '',
                    }
                }
            }
        }
    },
    dateOptions : {
        years : Array.from({
            length : 10
        }, (v, i) => ({
            id : i+today.year,
            name : `${i+today.year}`
        })),
        months : Array.from({
            length : 12
        }, (v, i) => ({
            id : i+1,
            name : i<9 ? `0${i+1}` : `${i+1}`
        }))
    }
}

class ShoppingCart extends Component {

    constructor(props){

        super(props);
        this.state = {
            items : [],
            totalPrice : {
                totalPrice : 0,
                payMethod : {
                    options : [],
                    value : '',
                    showCreditCard : false,
                    creditCard : {
                        cardNumber : {
                            value1 : '',
                            value2 : '',
                            value3 : '',
                            value4 : ''
                        },
                        expireDate : {
                            monthOptions : constant.dateOptions.months,
                            yearOptions : constant.dateOptions.years,
                            valueMonth : '',
                            valueYear : ''
                        },
                        validation : {
                            value : ''
                        }
                    }
                }
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
            }
        };
    }

    componentDidMount(){

        this.payMethodOptions(() => {

            this.show();
        });
    }

    render() {

        return (
            <FrontendMain Content={this.Content} />
        );
    }

    // jsx
    Content = () => {

        const{pagination} = this.state;
        const setter = {
            totalPrice : {
                setTotalPrice : (colVal, onSet) => this.setter('totalPrice', colVal, onSet)
            }
        };
        const getter = {
            totalPrice : {
                getTotalPrice : () => this.getter('totalPrice')
            }
        };
        const fctn = {
            item : {
                showConfirmModal : this.props.fctn.showConfirmModal,
                closeConfirmModal : this.props.fctn.closeConfirmModal,
                delete : this.delete
            },
            totalPrice : {
                showConfirmModal : this.props.fctn.showConfirmModal,
                closeConfirmModal : this.props.fctn.closeConfirmModal,
                checkout : this.checkout
            }
        }


        return (
            <Fragment>
                <h1>您的購物車</h1>
                <hr />
                <div className='mt-5'>
                    <Row>
                        <Col xs={8}>
                            <Stack gap={3}>
                                {
                                    this.getter('items').map(
                                        item => (
                                            <Item key={item.itemId} value={item} fctn={fctn.item} />
                                        )
                                    )
                                }
                            </Stack>
                        </Col>
                        <Col xs={4}>
                            <Stack className='h-100'>
                                <TotalPrice setter={setter.totalPrice} getter={getter.totalPrice} fctn={fctn.totalPrice} />
                                <div className='mt-auto ms-auto'>
                                    <div className='mt-5'>
                                        <Pagn pagn={pagination} turnPage={this.turnPage} />
                                    </div>
                                </div>
                            </Stack>
                        </Col>
                    </Row>
                </div>
            </Fragment>
        );
    }


    // other
    show = () => {

        this.showFetch();
    };
    delete = (itemId) => {

        const req = constant.fetch.req.delete;
        req.itemId = itemId;
        this.deleteFetch(req);
    };
    payMethodOptions = (onSuccess) => {

        this.payMethodOptionsFetch(onSuccess);
    };
    turnPage = (page) => {

        const req = constant.fetch.req.turnPage;

        req.page = page;
        this.turnPageFetch(req);
    };
    checkout = () => {

        const {totalPrice} = this.state;
        const req = constant.fetch.req.checkout;

        req.payMethod.name = totalPrice.payMethod.value;
        req.payMethod.needCreditCard = totalPrice.payMethod.showCreditCard;
        req.payMethod.creditCard.cardNumber1 = totalPrice.payMethod.creditCard.cardNumber.value1;
        req.payMethod.creditCard.cardNumber2 = totalPrice.payMethod.creditCard.cardNumber.value2;
        req.payMethod.creditCard.cardNumber3 = totalPrice.payMethod.creditCard.cardNumber.value3;
        req.payMethod.creditCard.cardNumber4 = totalPrice.payMethod.creditCard.cardNumber.value4;
        
        this.checkoutFetch(req);
    };




    // fetch
    showFetch = async () => {

        const {fctn} = this.props;
        const {fetch} =  constant;
        const url = fetch.url.show;
        const config = fetch.config;

        const {serverInfo, data} = await axios.get(url, {
                timeout : config.timeout,
                withCredentials: true
            })
            .then(rs => rs.data)
            .catch(error => console.error(error));

        const statusCode = serverInfo.statusCode;
        if(statusCode === 200){

            this.afterShow(data);
        }else if(statusCode===400 || statusCode===500){

            fctn.showInformModal(serverInfo.msg);
        }
    };
    deleteFetch = async (req) => {

        const {fctn} = this.props;
        const {fetch} =  constant;
        const url = fetch.url.delete;
        const config = fetch.config;

        const {serverInfo, data} = await axios.delete(url, {
                timeout : config.timeout,
                withCredentials: true,
                data : req
            })
            .then(rs => rs.data)
            .catch(error => console.error(error));

        const statusCode = serverInfo.statusCode;
        if(statusCode === 200){

            this.afterDelete(data);
        }else if(statusCode===400 || statusCode===500){

            fctn.showInformModal(serverInfo.msg);
        }
    };
    payMethodOptionsFetch = async (onSuccess) => {

        const {fctn} = this.props;
        const {fetch} =  constant;
        const url = fetch.url.payMethodOptions;
        const config = fetch.config;

        const {serverInfo, data} = await axios.get(url, {
                timeout : config.timeout
            })
            .then(rs => rs.data)
            .catch(error => console.error(error));

        const statusCode = serverInfo.statusCode;
        if(statusCode === 200){

            this.afterPayMethodOptions(data, onSuccess);
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
    checkoutFetch = async (req) => {

        const {fctn} = this.props;
        const {fetch} =  constant;
        const url = fetch.url.checkout;
        const config = fetch.config;

        const {serverInfo, data} = await axios.post(url, req, {
                timeout : config.timeout,
                withCredentials: true
            })
            .then(rs => rs.data)
            .catch(error => console.error(error));

        const statusCode = serverInfo.statusCode;
        if(statusCode === 200){

            this.afterCheckout(data);
        }else if(statusCode===400 || statusCode===500){

            fctn.showInformModal(serverInfo.msg);
        }
    };


    

    // after fetch
    afterShow = (data) => {

        this.updateState(data);
    };
    afterDelete = (data) => {

        const {fctn} = this.props;

        if(data.success){

            fctn.showInformModal(data.msg, () => {

                fctn.closeInformModal();
                this.show();
            });
        }else{

            fctn.showInformModal(data.msg);
        }
    };
    afterPayMethodOptions = (data, onSuccess) => {

        const {totalPrice} = this.state;
        
        this.setter('totalPrice', {
            ...totalPrice,
            payMethod : {
                ...totalPrice.payMethod,
                options : data.options
            }
        }, () => {

            onSuccess && onSuccess();
        });
    };
    afterTurnPage = (data) => {

        this.updateState(data);
    };
    afterCheckout = (data) => {

        const {fctn} = this.props;

        if(data.success){

            fctn.showInformModal(data.msg, () => {

                fctn.closeInformModal();
                this.show();
            });
        }else{

            fctn.showInformModal(data.msg);
        }
    };
    updateState = (data) => {

        const {totalPrice, pagination} = this.state;

        this.setter('items', data.itemList.items, () => {

            this.setter('totalPrice', {
                ...totalPrice,
                totalPrice : data.totalPrice
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

export default ShoppingCart;