import React, { Component } from 'react';
import { Table } from 'react-bootstrap';
import SortTableHeader from '../../hoc/table/sort-table-header';

class OrderTable extends Component {
    
    TableHeader = (props) => {

        // local props
        const {text} = props;

        // style
        const headerStyle = {
            paddingLeft : '1rem',
            paddingRight : '1rem'
        };

        return (
            <th style={headerStyle}>
                <SortTableHeader text={text} />
            </th>
        );
    };

    render() {

        const headerTexts = ['訂單編號', '客人姓名', '客人手機', '預定房型', '預定房間數', 
            '房型單價', '總金額', '付款方式', '預定入住日期', '預定入住時辰', '預定退房日期'];
        const example = ['黃小明', '0910123456', '標準雙人房', 1, 1000, 1000, '現金', 
            '2023/05/14', '16:00', '2023/05/15'];

        return (
            <Table striped bordered responsive hover>
                <thead>
                    <tr>
                        {headerTexts.map(
                            text => (
                                <this.TableHeader text={text} />
                            )
                        )}
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>1</td>
                        {example.map(
                            val => (
                                <td>{val}</td>
                            )
                        )}
                    </tr>
                    <tr>
                        <td>2</td>
                        {example.map(
                            val => (
                                <td>{val}</td>
                            )
                        )}
                    </tr>
                    <tr>
                        <td>3</td>
                        {example.map(
                            val => (
                                <td>{val}</td>
                            )
                        )}
                    </tr>
                    <tr>
                        <td>4</td>
                        {example.map(
                            val => (
                                <td>{val}</td>
                            )
                        )}
                    </tr>
                </tbody>
            </Table>
        );
    }
}

export default OrderTable;