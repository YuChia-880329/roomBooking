import '../../../css/custom.css';
import React, { Component } from 'react';
import { Table } from 'react-bootstrap';
import SortTh from '../../../hoc/table/sort-th';
import SortTd from '../../../hoc/table/sort-td';

const constant = {
    header : {
        name : {
            text : '房型名稱',
            colName : 'name'
        },
        totalNum : {
            text : '總房數',
            colName : 'totalNum'
        },
        usedNum : {
            text : '使用中房數',
            colName : 'usedNum'
        },
        invalidNum : {
            text : '不開放房數',
            colName : 'invalidNum'
        },
        price : {
            text : '房間單價',
            colName : 'price'
        },
    }
}
class RoomTable extends Component {
    
    render() {

        const {header} = constant;
        const {fctn} = this.props;
    
        return (
            <Table striped bordered responsive hover>
                <thead>
                    <tr>
                        <SortTh text={header.name.text} ascOnClick={() => {fctn.orderOnClick(header.name.colName, 0)}} 
                                descOnClick={() => {fctn.orderOnClick(header.name.colName, 1)}} />
                        <SortTh text={header.totalNum.text} ascOnClick={() => {fctn.orderOnClick(header.totalNum.colName, 0)}} 
                                descOnClick={() => {fctn.orderOnClick(header.totalNum.colName, 1)}} />
                        <SortTh text={header.usedNum.text} ascOnClick={() => {fctn.orderOnClick(header.usedNum.colName, 0)}} 
                                descOnClick={() => {fctn.orderOnClick(header.usedNum.colName, 1)}} />
                        <SortTh text={header.invalidNum.text} ascOnClick={() => {fctn.orderOnClick(header.invalidNum.colName, 0)}} 
                                descOnClick={() => {fctn.orderOnClick(header.invalidNum.colName, 1)}} />
                        <SortTh text={header.price.text} ascOnClick={() => {fctn.orderOnClick(header.price.colName, 0)}} 
                                descOnClick={() => {fctn.orderOnClick(header.price.colName, 1)}} />
                    </tr>
                </thead>
                <tbody>
                    {
                        fctn.getTableRows().map(tableRow => (
                            <tr key={tableRow.index}>
                                <SortTd text={tableRow.name} />
                                <SortTd text={tableRow.totalNum} />
                                <SortTd text={tableRow.usedNum} />
                                <SortTd text={tableRow.invalidNum} />
                                <SortTd text={tableRow.price} />
                            </tr>
                        ))
                    }
                </tbody>
            </Table>
        );
    }
}

export default RoomTable;