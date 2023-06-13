import React, { Component, Fragment } from 'react';
import FrontendMain from '../../hoc/frontend-main';
import Rooms from './receipt/rooms';
import TotalPrice from './receipt/total-price';

class Receipt extends Component {

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