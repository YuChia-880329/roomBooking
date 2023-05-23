import React, { Component } from 'react';
import { Table } from 'react-bootstrap';
import SortTableHeader from '../../hoc/table/sort-table-header';
import SortTableTd from '../../hoc/table/sort-table-td';

class OrderTable extends Component {
    
    render() {

        const headerTexts = ['訂單編號', '客人姓名', '客人手機', '預定房型', '預定房間數', 
            '房型單價', '付款方式', '預定入住日期', '預定入住時辰', '預定退房日期', '入住天數', '總金額'];
        const example = ['黃小明', '0910123456', '標準雙人房', 1, 1000, '現金', 
            '2023/05/14', '16:00', '2023/05/15', 1, 1000];


        return (
            <Table striped bordered responsive hover>
                <thead>
                    <tr>
                        {headerTexts.map(
                            text => (
                                <SortTableHeader text={text} />
                            )
                        )}
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <SortTableTd text='1' />
                        {example.map(
                            val => (
                                <SortTableTd text={val} />
                            )
                        )}
                    </tr>
                    <tr>
                        <SortTableTd text='2' />
                        {example.map(
                            val => (
                                <SortTableTd text={val} />
                            )
                        )}
                    </tr>
                    <tr>
                        <SortTableTd text='3' />
                        {example.map(
                            val => (
                                <SortTableTd text={val} />
                            )
                        )}
                    </tr>
                    <tr>
                        <SortTableTd text='4' />
                        {example.map(
                            val => (
                                <SortTableTd text={val} />
                            )
                        )}
                    </tr>
                </tbody>
            </Table>
        );
    }
}

export default OrderTable;