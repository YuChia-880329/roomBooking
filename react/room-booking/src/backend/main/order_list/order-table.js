import React, { Component } from 'react';
import { Table } from 'react-bootstrap';
import SortTh from '../../../hoc/table/sort-th';
import SortTd from '../../../hoc/table/sort-td';

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
                                <SortTh text={text} />
                            )
                        )}
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <SortTd text='1' />
                        {example.map(
                            val => (
                                <SortTd text={val} />
                            )
                        )}
                    </tr>
                    <tr>
                        <SortTd text='2' />
                        {example.map(
                            val => (
                                <SortTd text={val} />
                            )
                        )}
                    </tr>
                    <tr>
                        <SortTd text='3' />
                        {example.map(
                            val => (
                                <SortTd text={val} />
                            )
                        )}
                    </tr>
                    <tr>
                        <SortTd text='4' />
                        {example.map(
                            val => (
                                <SortTd text={val} />
                            )
                        )}
                    </tr>
                </tbody>
            </Table>
        );
    }
}

export default OrderTable;