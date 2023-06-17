import {indexof} from '../../../../files/util';
import React, { Component } from 'react';
import { Col, Form, Row, Stack } from 'react-bootstrap';
import CreditCard from './payMethod/credit-card';

class PayMethod extends Component {

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
            <Form.Group as={Stack} gap={4}>
                <Row>
                    <Form.Label column xs='auto'>付款方式 : </Form.Label>
                    <Col>
                        <Form.Control as='select' value={this.getter('value')} onChange={e => this.onChange(e, )}>
                            {
                                this.getter('options').map(
                                    op => (
                                        <option key={op.id} value={op.id}>{op.name}</option>
                                    )
                                )
                            }
                        </Form.Control>
                    </Col>
                </Row>
                {
                    this.getter('showCreditCard') && <CreditCard setter={setter.creditCard} getter={getter.creditCard} />
                }
            </Form.Group>
        );
    }


    // on
    onChange = (event) => {

        const optionId = event.target.value;
        const options = this.getter('options');
        const index = indexof(options, option => option.id===parseInt(optionId));
        const needCreditCard = index>=0 ? options[index].needCreditCard : false;

        this.setter('value', optionId, () => {

            this.setter('showCreditCard', needCreditCard);
        });
    };



    // setter getter
    setter = (colName, colVal, onSet) => {

        const {setter, getter} = this.props;

        setter.setPayMethod({
            ...getter.getPayMethod(),
            [colName] : colVal
        }, onSet);
    };
    getter = (colName) => {

        const {getter} = this.props;
        return getter.getPayMethod()[colName];
    }
}

export default PayMethod;