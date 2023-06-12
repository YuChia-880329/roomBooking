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

        return (
            <Form>
                <Stack gap={5}>
                    <Date />
                    <Row>
                        <Col>
                            <Number />
                        </Col>
                        <Col>
                            <Section />
                        </Col>
                    </Row>
                    <Stack direction='horizontal' className='justify-content-end'>
                        <Button variant='outline-primary'>搜尋</Button>
                    </Stack>
                </Stack>
            </Form>
        );
    };
}

export default FilterForm;