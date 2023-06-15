import React, { Component } from 'react';
import BorderForm from '../../../hoc/form/border-form';
import { Col, Form, Row, Stack } from 'react-bootstrap';
import Date from './filterForm/date';
import Number from './filterForm/number';
import { Button } from 'react-bootstrap';

class FilterForm extends Component {

    render() {

        return (
            <BorderForm Content={this.Content} />
        );
    }

    // jsx
    Content = () => {

        const setter = {
            date : {
                setDate : (colVal, onSet) => this.setter('date', colVal, onSet)
            },
            number : {
                setNumber : (colVal, onSet) => this.setter('number', colVal, onSet)
            }
        };
        const getter = {
            date : {
                getDate : () => this.getter('date')
            },
            number : {
                getNumber : () => this.getter('number')
            }
        }

        return (
            <Form noValidate validated={this.getter('validated')} onSubmit={this.onSubmit}>
                <Stack gap={5}>
                    <Date setter={setter.date} getter={getter.date} />
                    <Row>
                        <Col>
                            <Number setter={setter.number} getter={getter.number} />
                        </Col>
                        <Col>
                            <Stack direction='horizontal' className='justify-content-end'>
                                <Button type='send' variant='outline-primary'>搜尋</Button>
                            </Stack>
                        </Col>
                    </Row>
                </Stack>
            </Form>
        );
    };

    // on
    onSubmit = (event) => {

        const {fctn} = this.props;

        event.preventDefault();
        this.setter('validated', true, () => {

            if(event.target.checkValidity() === true){
    
                fctn.search();
                this.setter('validated', false);
            }else{

                fctn.showInformModal('表單未完整');
            }
        });
    };

    // setter getter
    setter = (colName, colVal, onSet) => {

        const {setter, getter} = this.props;

        setter.setFilterForm({
            ...getter.getFilterForm(),
            [colName] : colVal
        }, onSet);
    };
    getter = (colName) => {

        const {getter} = this.props;
        return getter.getFilterForm()[colName];
    }
}

export default FilterForm;