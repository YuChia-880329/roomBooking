import React, { Component } from 'react';
import { Table } from 'react-bootstrap';
import SortTableHeader from '../../hoc/table/sort-table-header';

class OrderTable extends Component {
    render() {

        // style
        const headerStyle = {
            paddingLeft : '1rem',
            paddingRight : '1rem'
        };

        return (
            <Table striped bordered responsive hover>
                <thead>
                    <tr>
                        <th style={headerStyle}>
                            <SortTableHeader text='訂單編號' />
                        </th>
                        <th style={headerStyle}>
                            <SortTableHeader text='客人姓名' />
                        </th>
                        <th style={headerStyle}>
                            <SortTableHeader text='客人手機' />
                        </th>
                        <th style={headerStyle}>
                            <SortTableHeader text='預定房型' />
                        </th>
                        <th style={headerStyle}>
                            <SortTableHeader text='預定房間數' />
                        </th>
                        <th style={headerStyle}>
                            <SortTableHeader text='房型單價' />
                        </th>
                        <th style={headerStyle}>
                            <SortTableHeader text='總金額' />
                        </th>
                        <th style={headerStyle}>
                            <SortTableHeader text='預定入住日期' />
                        </th>
                        <th style={headerStyle}>
                            <SortTableHeader text='預定退房日期' />
                        </th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>1</td>
                        <td>黃小明</td>
                        <td>0910123456</td>
                        <td>標準雙人房</td>
                        <td>1</td>
                        <td>1000</td>
                        <td>1000</td>
                        <td>2023/05/14</td>
                        <td>2023/05/15</td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>黃小明</td>
                        <td>0910123456</td>
                        <td>標準雙人房</td>
                        <td>1</td>
                        <td>1000</td>
                        <td>1000</td>
                        <td>2023/05/14</td>
                        <td>2023/05/15</td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>黃小明</td>
                        <td>0910123456</td>
                        <td>標準雙人房</td>
                        <td>1</td>
                        <td>1000</td>
                        <td>1000</td>
                        <td>2023/05/14</td>
                        <td>2023/05/15</td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>黃小明</td>
                        <td>0910123456</td>
                        <td>標準雙人房</td>
                        <td>1</td>
                        <td>1000</td>
                        <td>1000</td>
                        <td>2023/05/14</td>
                        <td>2023/05/15</td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>黃小明</td>
                        <td>0910123456</td>
                        <td>標準雙人房</td>
                        <td>1</td>
                        <td>1000</td>
                        <td>1000</td>
                        <td>2023/05/14</td>
                        <td>2023/05/15</td>
                    </tr>
                </tbody>
            </Table>
        );
    }
}

export default OrderTable;