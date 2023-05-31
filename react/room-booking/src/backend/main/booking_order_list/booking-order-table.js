import React, { Component } from 'react';
import { Table } from 'react-bootstrap';
import SortTh from '../../../hoc/table/sort-th';
import SortTd from '../../../hoc/table/sort-td';


const constant = {
    header : {
        id : {
            text : '訂單編號',
            colName : 'id'
        },
        clientName : {
            text : '客人姓名',
            colName : 'clientName'
        },
        clientPhone : {
            text : '客人手機',
            colName : 'clientPhone'
        },
        roomName : {
            text : '預定房型',
            colName : 'roomName'
        },
        roomNum : {
            text : '預定房間數',
            colName : 'roomNum'
        },
        price : {
            text : '房型單價',
            colName : 'price'
        },
        payMethod : {
            text : '付款方式',
            colName : 'payMethod'
        },
        checkinDateTime : {
            text : '預定入住日期時辰',
            colName : 'checkinDateTime'
        },
        checkoutDate : {
            text : '預定退房日期',
            colName : 'checkoutDate'
        },
        useDay : {
            text : '入住天數',
            colName : 'useDay'
        },
        totalPrice : {
            text : '總金額',
            colName : 'totalPrice'
        },
    }
}
class OrderTable extends Component {
    
    render() {
        
        const {header} = constant;
        const {fctn} = this.props;

        return (
            <Table striped bordered responsive hover>
                <thead>
                    <tr>
                        <SortTh text={header.id.text} ascOnClick={() => {fctn.orderOnClick(header.id.colName, 0)}} 
                                descOnClick={() => {fctn.orderOnClick(header.id.colName, 1)}} />
                        <SortTh text={header.clientName.text} ascOnClick={() => {fctn.orderOnClick(header.clientName.colName, 0)}} 
                                descOnClick={() => {fctn.orderOnClick(header.clientName.colName, 1)}} />
                        <SortTh text={header.clientPhone.text} ascOnClick={() => {fctn.orderOnClick(header.clientPhone.colName, 0)}} 
                                descOnClick={() => {fctn.orderOnClick(header.clientPhone.colName, 1)}} />
                        <SortTh text={header.roomName.text} ascOnClick={() => {fctn.orderOnClick(header.roomName.colName, 0)}} 
                                descOnClick={() => {fctn.orderOnClick(header.roomName.colName, 1)}} />
                        <SortTh text={header.roomNum.text} ascOnClick={() => {fctn.orderOnClick(header.roomNum.colName, 0)}} 
                                descOnClick={() => {fctn.orderOnClick(header.roomNum.colName, 1)}} />
                        <SortTh text={header.price.text} ascOnClick={() => {fctn.orderOnClick(header.price.colName, 0)}} 
                                descOnClick={() => {fctn.orderOnClick(header.price.colName, 1)}} />
                        <SortTh text={header.payMethod.text} ascOnClick={() => {fctn.orderOnClick(header.payMethod.colName, 0)}} 
                                descOnClick={() => {fctn.orderOnClick(header.payMethod.colName, 1)}} />
                        <SortTh text={header.checkinDateTime.text} ascOnClick={() => {fctn.orderOnClick(header.checkinDateTime.colName, 0)}} 
                                descOnClick={() => {fctn.orderOnClick(header.checkinDateTime.colName, 1)}} />
                        <SortTh text={header.checkoutDate.text} ascOnClick={() => {fctn.orderOnClick(header.checkoutDate.colName, 0)}} 
                                descOnClick={() => {fctn.orderOnClick(header.checkoutDate.colName, 1)}} />
                        <SortTh text={header.useDay.text} ascOnClick={() => {fctn.orderOnClick(header.useDay.colName, 0)}} 
                                descOnClick={() => {fctn.orderOnClick(header.useDay.colName, 1)}} />
                        <SortTh text={header.totalPrice.text} ascOnClick={() => {fctn.orderOnClick(header.totalPrice.colName, 0)}} 
                                descOnClick={() => {fctn.orderOnClick(header.totalPrice.colName, 1)}} />
                    </tr>
                </thead>
                <tbody>
                    {
                        fctn.getTableRows().map(tableRow => (
                            <tr key={tableRow.id}>
                                <SortTd text={tableRow.id} />
                                <SortTd text={tableRow.clientName} />
                                <SortTd text={tableRow.clientPhone} />
                                <SortTd text={tableRow.roomName} />
                                <SortTd text={tableRow.roomNum} />
                                <SortTd text={tableRow.price} />
                                <SortTd text={tableRow.payMethod} />
                                <SortTd text={tableRow.checkinDateTime} />
                                <SortTd text={tableRow.checkoutDate} />
                                <SortTd text={tableRow.useDay} />
                                <SortTd text={tableRow.totalPrice} />
                            </tr>
                        ))
                    }
                </tbody>
            </Table>
        );
    }
}

export default OrderTable;