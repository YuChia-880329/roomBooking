import React, { Component } from 'react';
import { Button, Stack } from 'react-bootstrap';
import PayMethod from './totalPrice/pay-method';

class TotalPrice extends Component {

    render() {

        const borderStyle = {
            padding : '3rem 3rem 2rem'
        };

        return (
            <div className='border border-1 border-secondary rounded-2 rounded' style={borderStyle}>
                <Stack gap={5}>
                    <Stack direction='horizontal'>
                        <h3>總價</h3>
                        <h2 className='text-secondary ms-auto'>
                            $ <span>3000</span> 元
                        </h2>
                    </Stack>
                    <PayMethod />
                    <Button variant='outline-primary'>結帳</Button>
                </Stack>
            </div>
        );
    }
}

export default TotalPrice;