import urls from '../../files/urls.json';
import config from '../../files/config.json';
import React, { Component, Fragment } from 'react';
import FrontendMain from '../../hoc/frontend-main';
import Rooms from './receipt/rooms';
import TotalPrice from './receipt/total-price';
import { useLocation } from 'react-router-dom';
import axios from 'axios';

const constant = {
    fetch : {
        url : {
            show : urls.frontend.receipt.show,
            turnPage : urls.frontend.receipt.turnPage
        },
        config : {
            timeout : config.fetch.timeout
        },
        req : {
            show : {
                receiptId : -1
            },
            turnPage : {
                page : '',
                receiptId : ''
            }
        }
    }
}

class ReceiptWrapped extends Component {

    constructor(props){

        super(props);
        this.state = {
            rooms : {
                items : [],
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
            },
            totalPrice : {
                totalPrice : 0,
                payMethod : '',
                showCreditCard : false,
                creditCard : {
                    cardNumber : ''
                }
            }
        };
    }

    componentDidMount(){

        const {fctn} = this.props;

        fctn.checkLogin(() => {

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

        const setter = {
            rooms : {
                setRooms : (colVal, onSet) => this.setter('rooms', colVal, onSet)
            },
            totalPrice : {
                setTotalPrice : (colVal, onSet) => this.setter('totalPrice', colVal, onSet)
            }
        };
        const getter = {
            rooms : {
                getRooms : () => this.getter('rooms')
            },
            totalPrice : {
                getTotalPrice : () => this.getter('totalPrice')
            }
        };
        const fctn = {
            rooms : {
                turnPage : this.turnPage
            }
        };


        return (
            <Fragment>
                <h1>訂房完成</h1>
                <hr />
                <div className='mt-5'>
                    <Rooms setter={setter.rooms} getter={getter.rooms} fctn={fctn.rooms} />
                </div>
                <hr />
                <div className='mt-5'>
                    <TotalPrice setter={setter.totalPrice} getter={getter.totalPrice} />
                </div>
            </Fragment>
        );
    }


    // other
    show = () => {

        const {data} = this.props;
        const req = constant.fetch.req.show;

        req.receiptId = data.receiptId
        this.showFetch(req);
    };
    turnPage = (page) => {

        const {data} = this.props;
        const req = constant.fetch.req.turnPage;

        req.page = page;
        req.receiptId = data.receiptId
        this.turnPageFetch(req);
    };



    // fetch
    showFetch = async (params) => {

        const {fctn} = this.props;
        const {fetch} =  constant;
        const url = fetch.url.show;
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

            this.afterShow(data);
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
    afterShow = (data) => {

        this.updateState(data);        
    };
    afterTurnPage = (data) => {

        this.updateState(data);
    };
    updateState = (data) => {

        const {rooms, totalPrice} = this.state;
        this.setter('rooms', {
            ...rooms,
            items : data.items,
            pagination : data.pagination
        }, () => {

            this.setter('totalPrice', {
                ...totalPrice,
                totalPrice : data.totalPrice,
                payMethod : data.payMethod.name,
                showCreditCard : data.payMethod.needCreditCard,
                creditCard : {
                    ...totalPrice.creditCard,
                    cardNumber : data.payMethod.creditCard.cardNumber
                }
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

const Receipt = props => {

    const location = useLocation();
    const data = location.state;

    return (<ReceiptWrapped {...props} data={data} />);
};
export default Receipt;