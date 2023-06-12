import React, { Component } from 'react';
import { Form, Stack } from 'react-bootstrap';

const constant = {
    months : ['01', '02', '03', '04', '05', '06', '07', '08', '09', '10', '11', '12'],
    years : ['2023', '2024', '2025', '2026']
};

class ExpireDate extends Component {

    render() {

        return (
            <Stack>
                <Form.Label>信用卡有效期限</Form.Label>
                <Stack direction='horizontal' gap={3}>
                    <Form.Control as='select'>
                        {
                            constant.months.map(
                                month => (
                                    <option key={month}>{month}</option>
                                )
                            )
                        }
                    </Form.Control>
                    <div>月</div>
                    <Form.Control as='select'>
                        {
                            constant.years.map(
                                year => (
                                    <option key={year}>{year}</option>
                                )
                            )
                        }
                    </Form.Control>
                    <div>年</div>
                </Stack>
            </Stack>
        );
    }
}

export default ExpireDate;