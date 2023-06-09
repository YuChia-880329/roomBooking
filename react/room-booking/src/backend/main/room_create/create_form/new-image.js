import React, { Component } from 'react';
import { Button, Col, Form, Row, Stack } from 'react-bootstrap';

class NewImage extends Component {

    render() {
        
        const {value} = this.props;

        return (
            <Form.Group as={Row}>
                <Form.Label column xs='auto' htmlFor='form_newImage1'>新增照片 : </Form.Label>
                <Col>
                    <Row>
                        <Col xs='auto'>
                            <Stack gap={4}>
                                {
                                    value.numbers.map(
                                        (n, index) => (
                                            <Stack direction='horizontal' gap={4} key={n}>
                                                <Form.Control type='file' id={`form_newImage${n}`} name={`form_newImage${n}`} 
                                                        onChange={e => this.onChange(e, n)} />
                                                <div style={{visibility : (index>0) ? 'block' : 'hidden'}}>
                                                    <Button variant='outline-primary' size='sm' onClick={e => this.onClickMinusBtn(e, n)} >-</Button>
                                                </div>
                                            </Stack>
                                        )
                                    )
                                }
                                <div>
                                    <Button variant='outline-primary' size='sm' onClick={this.onClickPlusBtn}>+</Button>
                                </div>
                            </Stack>
                        </Col>
                    </Row>
                </Col>
            </Form.Group>
        );
    }

    // on
    onChange = (event, n) => {

        const {value} = this.props;

        const alreadyHas = value.hasfile.includes(n);
        if(!alreadyHas && event.target.value!=='')
            this.setter('hasfile', [...value.hasfile, n]);
        else if(event.target.value==='')
            this.setter('hasfile', value.hasfile.filter(v => v!==n));
    }
    onClickPlusBtn = (event) => {

        const {value} = this.props;

        const i = value.index+1;

        this.setter('numbers', [...value.numbers, i], () => {

            this.setter('index', i);
        });
    }
    onClickMinusBtn = (event, n) => {

        const {value, fctn} = this.props;

        fctn.showConfirmModal('確定要移除 ? ', () => {

            this.setter('numbers', value.numbers.filter(v => v!==n), () => {

                this.setter('hasfile', value.hasfile.filter(v => v!==n));
            });
            fctn.closeConfirmModal();
        });
    }


    // setter
    setter = (colName, colVal, onSet) => {

        const {setter, value} = this.props;
        setter.setNewImage({
            ...value,
            [colName] : colVal
        }, onSet);
    };
}

export default NewImage;