import React, { Component, Fragment } from 'react';
import CreditCard from './totalPrice/credit-card';

class TotalPrice extends Component {

    render() {

        const setter = {
            creditCard : {
                setCreditCard : (colVal, onSet) => this.setter('creditCard', colVal, onSet)
            }
        };
        const getter = {
            creditCard : {
                getCreditCard : () => this.getter('creditCard')
            }
        };

        return (
            <Fragment>
                <h3>
                    總計 <span>{this.getter('totalPrice')}</span> 元
                </h3>
                <div className='mt-5 w-25'>
                    <h5>
                        付款方式 : <span>{this.getter('payMethod')}</span>
                    </h5>
                    <hr />
                    {
                        this.getter('showCreditCard') && (
                            <div className='mt-3'>
                                <CreditCard setter={setter.creditCard} getter={getter.creditCard} />
                            </div>  
                        )
                    }
                </div>
            </Fragment>
        );
    }


    // setter getter
    setter = (colName, colVal, onSet) => {

        const {setter, getter} = this.props;

        setter.setTotalPrice({
            ...getter.getTotalPrice(),
            [colName] : colVal
        }, onSet);
    };
    getter = (colName) => {

        const {getter} = this.props;
        return getter.getTotalPrice()[colName];
    }
}

export default TotalPrice;