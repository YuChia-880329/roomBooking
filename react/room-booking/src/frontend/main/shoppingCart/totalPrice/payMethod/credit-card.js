import React, { Component } from 'react';
import { Stack } from 'react-bootstrap';
import CardNumber from './creditCard/card-number';
import ExpireDate from './creditCard/expire-date';
import Validation from './creditCard/validation';


class CreditCard extends Component {

    render() {

        return (
            <Stack className='mt-3' gap={3}>
                <CardNumber />
                <ExpireDate />
                <Validation />
            </Stack>
        );
    }
}

export default CreditCard;