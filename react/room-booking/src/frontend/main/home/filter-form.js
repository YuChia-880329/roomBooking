import React, { Component } from 'react';
import BorderForm from '../../../hoc/form/border-form';
import { Col, Form, Row, Stack } from 'react-bootstrap';
import Date from './filterForm/date';
import Number from './filterForm/number';
import Section from './filterForm/section';
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
            },
            section : {
                setSection : (colVal, onSet) => this.setter('section', colVal, onSet)
            }
        };
        const getter = {
            date : {
                getDate : () => this.getter('date')
            },
            number : {
                getNumber : () => this.getter('number')
            },
            section : {
                getSection : () => this.getter('section')
            }
        }

        return (
            <Form>
                <Stack gap={5}>
                    <Date setter={setter.date} getter={getter.date} />
                    <Row>
                        <Col>
                            <Number setter={setter.number} getter={getter.number} />
                        </Col>
                        <Col>
                            <Section setter={setter.section} getter={getter.section} />
                        </Col>
                    </Row>
                    <Stack direction='horizontal' className='justify-content-end'>
                        <Button variant='outline-primary'>搜尋</Button>
                    </Stack>
                </Stack>
            </Form>
        );
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