import React, { Component } from 'react';
import { Col, Form, Row } from 'react-bootstrap';

class TotalNum extends Component {

    render() {
        
        const {value} = this.props;

        return (
            <Form.Group as={Row}>
                <Form.Label column xs='auto' htmlFor='form_totalNumber'>總房數 : </Form.Label>
                <Col>
                    <Form.Control required type='number' id='form_totalNumber' value={value.value} onChange={this.onChange} 
                            disabled={value.disabled} min={1} />
                    <Form.Control.Feedback type='invalid'>請輸入總房數(不可小於1)</Form.Control.Feedback>
                </Col>
            </Form.Group>
        );
    }

    // on
    onChange = (event) => {

        const {setter, getter} = this.props;

        const totalNumStr = event.target.value;
        const totalNum = parseInt(event.target.value, 10);
        if(totalNumStr!=='' &&  totalNum>=0){

            let usedNum = parseInt(getter.getUsedNum().value, 10);
            let invalidNum = parseInt(getter.getInValidNum().value, 10);
    
            const invalidNumMax = totalNum;
            invalidNum = invalidNum<invalidNumMax ? invalidNum : invalidNumMax;
            const usedNumMax = totalNum-invalidNum;
            usedNum = usedNum<usedNumMax ? usedNum : usedNumMax;
    
            this.setter('value', event.target.value, () => {
    
                setter.setInValidNum({
                    ...getter.getInValidNum(),
                    options : Array.from({length : invalidNumMax+1}, (v, i) => i),
                    value : `${invalidNum}`
                }, () => {

                    setter.setUsedNum({
                        ...getter.getUsedNum(),
                        options : Array.from({length : usedNumMax+1}, (v, i) => i),
                        value : `${usedNum}`
                    });
                });
            });
        }else{

            this.setter('value', event.target.value, () => {

                setter.setInValidNum({
                    ...getter.getInValidNum(),
                    options : [],
                    value : ''
                }, () => {

                    setter.setUsedNum({
                        ...getter.getUsedNum(),
                        options : [],
                        value : ''
                    });
                });
            });
        }
        
    };


    // setter
    setter = (colName, colVal, onSet) => {

        const {setter, value} = this.props;
        setter.setTotalNum({
            ...value,
            [colName] : colVal
        }, onSet);
    };
}

export default TotalNum;