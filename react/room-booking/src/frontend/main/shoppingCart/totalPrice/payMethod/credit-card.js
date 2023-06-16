import React, { Component } from 'react';
import { Stack } from 'react-bootstrap';
import CardNumber from './creditCard/card-number';
import ExpireDate from './creditCard/expire-date';
import Validation from './creditCard/validation';


class CreditCard extends Component {

    render() {

        const setter = {
            cardNumber : {
                setCardNumber : (colVal, onSet) => this.setter('cardNumber', colVal, onSet)
            },
            expireDate : {
                setExpireDate : (colVal, onSet) => this.setter('expireDate', colVal, onSet)
            },
            validation : {
                setValidation : (colVal, onSet) => this.setter('validation', colVal, onSet)
            }
        };
        const getter = {
            cardNumber : {
                getCardNumber : () => this.getter('cardNumber')
            },
            expireDate : {
                getExpireDate : () => this.getter('expireDate')
            },
            validation : {
                getValidation : () => this.getter('validation')
            }
        };

        return (
            <Stack className='mt-3' gap={3}>
                <CardNumber setter={setter.cardNumber} getter={getter.cardNumber} />
                <ExpireDate setter={setter.expireDate} getter={getter.expireDate} />
                <Validation setter={setter.validation} getter={getter.validation} />
            </Stack>
        );
    }


    // setter getter
    setter = (colName, colVal, onSet) => {

        const {setter, getter} = this.props;

        setter.setCreditCard({
            ...getter.getCreditCard(),
            [colName] : colVal
        }, onSet);
    };
    getter = (colName) => {

        const {getter} = this.props;
        return getter.getCreditCard()[colName];
    }
}

export default CreditCard;