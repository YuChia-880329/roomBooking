import React, { Component, Fragment } from 'react';
import FrontendMain from '../../hoc/frontend-main';
import Rooms from './receipt/rooms';
import TotalPrice from './receipt/total-price';

class Receipt extends Component {

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
    render() {

        return (
            <FrontendMain Content={this.Content} />
        );
    }

    // jsx
    Content = () => {

        return (
            <Fragment>
                <h1>訂房完成</h1>
                <hr />
                <div className='mt-5'>
                    <Rooms />
                </div>
                <hr />
                <div className='mt-5'>
                    <TotalPrice />
                </div>
            </Fragment>
        );
    }
}

export default Receipt;