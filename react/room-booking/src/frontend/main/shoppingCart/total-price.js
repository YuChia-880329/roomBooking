import React, { Component } from 'react';
import { Button, Stack } from 'react-bootstrap';
import PayMethod from './totalPrice/pay-method';

class TotalPrice extends Component {

    render() {

        const borderStyle = {
            padding : '3rem 3rem 2rem'
        };
        const setter = {
            payMethod : {
                setPayMethod : (colVal, onSet) => this.setter('payMethod', colVal, onSet)
            }
        };
        const getter = {
            payMethod : {
                getPayMethod : () => this.getter('payMethod')
            }
        };
        

        return (
            <div className='border border-1 border-secondary rounded-2 rounded' style={borderStyle}>
                <Stack gap={5}>
                    <Stack direction='horizontal'>
                        <h3>總價</h3>
                        <h2 className='text-secondary ms-auto'>
                            $ <span>{this.getter('totalPrice')}</span> 元
                        </h2>
                    </Stack>
                    <PayMethod setter={setter.payMethod} getter={getter.payMethod} />
                    <Button variant='outline-primary'>結帳</Button>
                </Stack>
            </div>
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