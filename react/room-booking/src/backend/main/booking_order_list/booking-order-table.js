import React, { Component } from 'react';
import { Table } from 'react-bootstrap';
import SortTh from '../../../hoc/table/sort-th';
import SortTd from '../../../hoc/table/sort-td';


const constant = {
    header : {
        id : {
            text : '訂單編號'
        },
        clientName : {
            text : '客人姓名'
        },
        clientPhone : {
            text : '客人手機'
        },
        roomName : {
            text : '預定房型'
        },
        roomNum : {
            text : '預定房間數'
        },
        price : {
            text : '房型單價'
        },
        payMethod : {
            text : '付款方式'
        },
        checkinDate : {
            text : '預定入住日期'
        },
        checkoutDate : {
            text : '預定退房日期'
        },
        useDay : {
            text : '入住天數'
        },
        totalPrice : {
            text : '總金額'
        }
    }
}
class OrderTable extends Component {
    
    render() {
        
        const {header} = constant;
        const {value} = this.props;

        return (
            <Table striped bordered responsive hover>
                <thead>
                    <tr>
                        <SortTh text={header.id.text} ascOnClick={e => this.onClickOrder(e, 'id', 0)} 
                                descOnClick={e => this.onClickOrder(e, 'id', 1)} />
                        <SortTh text={header.clientName.text} ascOnClick={e => this.onClickOrder(e, 'clientName', 0)} 
                                descOnClick={e => this.onClickOrder(e, 'clientName', 1)} />
                        <SortTh text={header.clientPhone.text} ascOnClick={e => this.onClickOrder(e, 'clientPhone', 0)} 
                                descOnClick={e => this.onClickOrder(e, 'clientPhone', 1)} />
                        <SortTh text={header.roomName.text} ascOnClick={e => this.onClickOrder(e, 'roomName', 0)} 
                                descOnClick={e => this.onClickOrder(e, 'roomName', 1)} />
                        <SortTh text={header.roomNum.text} ascOnClick={e => this.onClickOrder(e, 'roomNum', 0)} 
                                descOnClick={e => this.onClickOrder(e, 'roomNum', 1)} />
                        <SortTh text={header.price.text} ascOnClick={e => this.onClickOrder(e, 'price', 0)} 
                                descOnClick={e => this.onClickOrder(e, 'price', 1)} />
                        <SortTh text={header.payMethod.text} ascOnClick={e => this.onClickOrder(e, 'payMethod', 0)} 
                                descOnClick={e => this.onClickOrder(e, 'payMethod', 1)} />
                        <SortTh text={header.checkinDate.text} ascOnClick={e => this.onClickOrder(e, 'checkinDate', 0)} 
                                descOnClick={e => this.onClickOrder(e, 'checkinDate', 1)} />
                        <SortTh text={header.checkoutDate.text} ascOnClick={e => this.onClickOrder(e, 'checkoutDate', 0)} 
                                descOnClick={e => this.onClickOrder(e, 'checkoutDate', 1)} />
                        <SortTh text={header.useDay.text} ascOnClick={e => this.onClickOrder(e, 'useDay', 0)} 
                                descOnClick={e => this.onClickOrder(e, 'useDay', 1)} />
                        <SortTh text={header.totalPrice.text} ascOnClick={e => this.onClickOrder(e, 'totalPrice', 0)} 
                                descOnClick={e => this.onClickOrder(e, 'totalPrice', 1)} />
                    </tr>
                </thead>
                <tbody>
                    {
                        value.tableRows.map(tableRow => (
                            <tr key={tableRow.id}>
                                <SortTd text={tableRow.id} />
                                <SortTd text={tableRow.clientName} />
                                <SortTd text={tableRow.clientPhone} />
                                <SortTd text={tableRow.roomName} />
                                <SortTd text={tableRow.roomNum} />
                                <SortTd text={tableRow.price} />
                                <SortTd text={tableRow.payMethod} />
                                <SortTd text={tableRow.checkinDate} />
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

    // on
    onClickOrder = (event, colName, direction) => {

        const {fctn} = this.props;
        fctn.changeOrder(colName, direction);
    }

    // setter
    setter = (colName, colVal, onSet) => {

        const {setter, value} = this.props;
        setter.setBookingOrderTable({
            ...value,
            [colName] : colVal
        }, onSet);
    };
}

export default OrderTable;