import '../../../css/custom.css';
import React, { Component } from 'react';
import { Table } from 'react-bootstrap';
import SortTh from '../../../hoc/table/sort-th';
import SortTd from '../../../hoc/table/sort-td';

const constant = {
    headerTexts : ['房型名稱', '總房數', '使用中房數', '不開放房數', '房間單價']
}
class RoomTable extends Component {
    
    render() {

        const {headerTexts} = constant;
        const {fctn} = this.props;
    
        return (
            <Table striped bordered responsive hover>
                <thead>
                    <tr>
                        {headerTexts.map(
                            text => (
                                <SortTh key={text} text={text} />
                            )
                        )}
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