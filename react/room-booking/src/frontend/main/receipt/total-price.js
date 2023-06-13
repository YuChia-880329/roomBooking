import React, { Component, Fragment } from 'react';
import CreditCard from './totalPrice/credit-card';

class TotalPrice extends Component {

    render() {

        return (
            <Fragment>
                <h3>
                    總計 <span>3000</span> 元
                </h3>
                <div className='mt-5 w-25'>
                    <h5>
                        付款方式 : <span>信用卡</span>
                    </h5>
                    <hr />
                    <div className='mt-3'>
                        <CreditCard />
                    </div>
                </div>
            </Fragment>
        );
    }
}

export default TotalPrice;