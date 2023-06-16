import React, { Component, createRef } from 'react';
import { Form, Stack } from 'react-bootstrap';

class CardNumber extends Component {

    cardNumber2Ref = createRef();
    cardNumber3Ref = createRef();
    cardNumber4Ref = createRef();

    render() {

        return (
            <Stack>
                <Form.Label htmlFor='card_number1'>信用卡卡號</Form.Label>
                <Stack direction='horizontal' gap={2}>
                    <Form.Control id='card_number1' htmlSize={4} value={this.getter('value1')} onChange={e => this.onChange(e, 'value1', this.cardNumber2Ref)} />
                    <div>-</div>
                    <Form.Control id='card_number2' htmlSize={4} value={this.getter('value2')} onChange={e => this.onChange(e, 'value2', this.cardNumber3Ref)} ref={this.cardNumber2Ref} />
                    <div>-</div>
                    <Form.Control id='card_number3' htmlSize={4} value={this.getter('value3')} onChange={e => this.onChange(e, 'value3', this.cardNumber4Ref)} ref={this.cardNumber3Ref} />
                    <div>-</div>
                    <Form.Control id='card_number4' htmlSize={4} value={this.getter('value4')} onChange={e => this.onChange(e, 'value4', undefined, this.cardNumber4Ref)} ref={this.cardNumber4Ref} />
                </Stack>
            </Stack>
        );
    }

    // on
    onChange = (event, colName, focusRef, selfRef) => {

        const value = event.target.value;
        this.setter(colName, value, () => {

            if(focusRef && value.length>=3)
                focusRef.current.focus();
            else if(value.length>=3)
                selfRef && selfRef.current.blur();
        });
    }


    // setter getter
    setter = (colName, colVal, onSet) => {

        const {setter, getter} = this.props;

        setter.setCardNumber({
            ...getter.getCardNumber(),
            [colName] : colVal
        }, onSet);
    };
    getter = (colName) => {

        const {getter} = this.props;
        return getter.getCardNumber()[colName];
    }
}

export default CardNumber;