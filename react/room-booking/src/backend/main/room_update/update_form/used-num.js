import React, { Component } from 'react';
import { Col, Form, Row } from 'react-bootstrap';

class UsedNum extends Component {
    
    render() {

        const {value} = this.props;

        return (
            <Form.Group as={Row}>
                <Form.Label column xs='auto'>使用中房數 : </Form.Label>
                <Col>
                    <Form.Control as='select' value={value.value} onChange={this.onChange} disabled={value.disabled}>
                        {
                            value.disabled ? 
                                    (<option value={-1}>----------------</option>) :
                                            value.options.map(
                                                op => (
                                                    <option key={op} value={op}>{op}</option>
                                                )
                                            )
                        }
                    </Form.Control>
                </Col>
            </Form.Group>
        );
    }

    // on
    onChange = (event) => {

        const {setter, getter} = this.props;

        const usedNum = parseInt(event.target.value, 10);
        const totalNum = parseInt(getter.getTotalNum().value, 10);
        const invalidNum = parseInt(getter.getInValidNum().value, 10);
        const invalidNumMax = totalNum-usedNum;

        this.setter('value', event.target.value, () => {

            setter.setInValidNum({
                ...getter.getInValidNum(),
                options : Array.from({length : invalidNumMax+1}, (v, i) => i),
                value : invalidNum<=invalidNumMax ? invalidNum : invalidNumMax
            });
        });
    };


    // setter
    setter = (colName, colVal, onSet) => {

        const {setter, value} = this.props;
        
        setter.setUsedNum({
            ...value,
            [colName] : colVal
        }, onSet);
    };
}

export default UsedNum;