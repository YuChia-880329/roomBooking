import '../../../css/custom.css';
import React, { Component } from 'react';
import { Table } from 'react-bootstrap';
import SortTableHeader from '../../../hoc/table/sort-table-header';
import SortTableTd from '../../../hoc/table/sort-table-td';

class RoomTable extends Component {
    
    render() {
        
        const headerTexts = ['房型名稱', '總房數', '使用中房數', '不開放房數', '房間單價'];
        const example = ['標準雙人房', 10, 2, 5, 1000];

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
                        {example.map(
                            val => (
                                <SortTableTd text={val} />
                            )
                        )}
                    </tr>
                    <tr>
                        {example.map(
                            val => (
                                <SortTableTd text={val} />
                            )
                        )}
                    </tr>
                    <tr>
                        {example.map(
                            val => (
                                <SortTableTd text={val} />
                            )
                        )}
                    </tr>
                    <tr>
                        {example.map(
                            val => (
                                <SortTableTd text={val} />
                            )
                        )}
                    </tr>
                    <tr>
                        {example.map(
                            val => (
                                <SortTableTd text={val} />
                            )
                        )}
                    </tr>
                    <tr>
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

export default RoomTable;