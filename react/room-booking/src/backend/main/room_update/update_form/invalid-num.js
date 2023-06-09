import React, { Component } from 'react';
import { Col, Form, Row } from 'react-bootstrap';

class InvalidNum extends Component {

    render() {
        
        const {value} = this.props;

        return (
            <Form.Group as={Row}>
                <Form.Label column xs='auto'>不開放房數 : </Form.Label>
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

        const invalidNum = parseInt(event.target.value, 10);
        const totalNum = parseInt(getter.getTotalNum().value, 10);
        const usedNum = parseInt(getter.getUsedNum().value, 10);
        const usedNumMax = totalNum-invalidNum;

        this.setter('value', event.target.value, () => {

            setter.setUsedNum({
                ...getter.getUsedNum(),
                options : Array.from({length : usedNumMax+1}, (v, i) => i),
                value : usedNum<=usedNumMax ? `${usedNum}` : `${usedNumMax}`
            });
        });
    };


    // setter
    setter = (colName, colVal, onSet) => {

        const {setter, value} = this.props;
        setter.setInValidNum({
            ...value,
            [colName] : colVal
        }, onSet);
    };
}

export default InvalidNum;