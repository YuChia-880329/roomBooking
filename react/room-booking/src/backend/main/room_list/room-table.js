import '../../../css/custom.css';
import React, { Component } from 'react';
import { Table } from 'react-bootstrap';
import SortTh from '../../../hoc/table/sort-th';
import SortTd from '../../../hoc/table/sort-td';

const constant = {
    header : {
        name : {
            text : '房型名稱'
        },
        totalNum : {
            text : '總房數'
        },
        invalidNum : {
            text : '不開放房數'
        },
        price : {
            text : '房間單價'
        },
        status : {
            text : '房間狀態'
        }
    }
}
class RoomTable extends Component {
    
    render() {

        const {header} = constant;
        const {value} = this.props;
    
        return (
            <Table striped bordered responsive hover>
                <thead>
                    <tr>
                        <SortTh text={header.name.text} ascOnClick={e => this.onClickOrder(e, 'name', 0)} 
                                descOnClick={e => this.onClickOrder(e, 'name', 1)} />
                        <SortTh text={header.totalNum.text}  ascOnClick={e => this.onClickOrder(e, 'totalNum', 0)} 
                                descOnClick={e => this.onClickOrder(e, 'totalNum', 1)} />
                        <SortTh text={header.invalidNum.text}  ascOnClick={e => this.onClickOrder(e, 'invalidNum', 0)} 
                                descOnClick={e => this.onClickOrder(e, 'invalidNum', 1)} />
                        <SortTh text={header.price.text}  ascOnClick={e => this.onClickOrder(e, 'price', 0)} 
                                descOnClick={e => this.onClickOrder(e, 'price', 1)} />
                        <SortTh text={header.status.text}  ascOnClick={e => this.onClickOrder(e, 'status', 0)} 
                                descOnClick={e => this.onClickOrder(e, 'status', 1)} />
                    </tr>
                </thead>
                <tbody>
                    {
                        value.tableRows.map(tableRow => (
                            <tr key={tableRow.index}>
                                <SortTd text={tableRow.name} />
                                <SortTd text={tableRow.totalNum} />
                                <SortTd text={tableRow.invalidNum} />
                                <SortTd text={tableRow.price} />
                                <SortTd text={tableRow.status} />
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
        setter.setRoomTable({
            ...value,
            [colName] : colVal
        }, onSet);
    };
}

export default RoomTable;