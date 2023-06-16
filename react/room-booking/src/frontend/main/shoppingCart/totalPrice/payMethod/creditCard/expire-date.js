import React, { Component } from 'react';
import { Form, Stack } from 'react-bootstrap';

class ExpireDate extends Component {

    render() {

        return (
            <Stack>
                <Form.Label>信用卡有效期限</Form.Label>
                <Stack direction='horizontal' gap={3}>
                    <Form.Control as='select' value={this.getter('valueMonth')} onChange={e => this.onChange(e, 'valueMonth')}>
                        {
                            this.getter('monthOptions').map(
                                month => (
                                    <option key={month.id} value={month.id}>{month.name}</option>
                                )
                            )
                        }
                    </Form.Control>
                    <div>月</div>
                    <Form.Control as='select' value={this.getter('valueYear')} onChange={e => this.onChange(e, 'valueYear')}>
                        {
                            this.getter('yearOptions').map(
                                year => (
                                    <option key={year.id} value={year.id}>{year.name}</option>
                                )
                            )
                        }
                    </Form.Control>
                    <div>年</div>
                </Stack>
            </Stack>
        );
    }


    // on
    onChange = (event, colName) => {

        this.setter(colName, event.target.value);
    }


    // setter getter
    setter = (colName, colVal, onSet) => {

        const {setter, getter} = this.props;

        setter.setExpireDate({
            ...getter.getExpireDate(),
            [colName] : colVal
        }, onSet);
    };
    getter = (colName) => {

        const {getter} = this.props;
        return getter.getExpireDate()[colName];
    }
}

export default ExpireDate;