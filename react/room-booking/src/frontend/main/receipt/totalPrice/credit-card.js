import React, { Component, Fragment } from 'react';

class CreditCard extends Component {

    render() {

        return (
            <Fragment>
                <p>
                    卡號 : <span>{this.getter('cardNumber')}</span>
                </p>
            </Fragment>
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