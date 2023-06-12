import React, { Component } from 'react';
import { Form, Stack } from 'react-bootstrap';

const constant = {
    months : ['01', '02', '03', '04', '05', '06', '07', '08', '09', '10', '11', '12'],
    years : ['2023', '2024', '2025', '2026']
};
class CreditCard extends Component {

    render() {

        return (
            <Stack className='mt-3' gap={4}>
                <Stack>
                    <Form.Label htmlFor='card_number1'>信用卡卡號</Form.Label>
                    <Stack direction='horizontal' gap={1}>
                        <Form.Control id='card_number1' htmlSize={4} />
                        <div>-</div>
                        <Form.Control id='card_number2' htmlSize={4} />
                        <div>-</div>
                        <Form.Control id='card_number3' htmlSize={4} />
                        <div>-</div>
                        <Form.Control id='card_number4' htmlSize={4} />
                    </Stack>
                </Stack>
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
                <Stack direction='horizontal' gap={3}>
                    <Form.Label className='mb-0'>信用卡檢核碼</Form.Label>
                    <div>
                        <Form.Control htmlSize={3}></Form.Control>
                    </div>
                </Stack>
            </Stack>
        );
    }
}

export default CreditCard;