import '../../css/custom.css';
import React, { Component } from 'react';
import { Table } from 'react-bootstrap';
import SortTableHeader from '../../hoc/table/sort-table-header';

class RoomTable extends Component {
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
                            <SortTableHeader text='房型名稱' />
                        </th>
                        <th style={headerStyle}>
                            <SortTableHeader text='總房數' />
                        </th>
                        <th style={headerStyle}>
                            <SortTableHeader text='開放空房數' />
                        </th>
                        <th style={headerStyle}>
                            <SortTableHeader text='不開放房數' />
                        </th>
                        <th style={headerStyle}>
                            <SortTableHeader text='房間單價' />
                        </th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>標準雙人房</td>
                        <td>10</td>
                        <td>2</td>
                        <td>5</td>
                        <td>1000</td>
                    </tr>
                    <tr>
                        <td>標準雙人房</td>
                        <td>10</td>
                        <td>2</td>
                        <td>5</td>
                        <td>1000</td>
                    </tr>
                    <tr>
                        <td>標準雙人房</td>
                        <td>10</td>
                        <td>2</td>
                        <td>5</td>
                        <td>1000</td>
                    </tr>
                    <tr>
                        <td>標準雙人房</td>
                        <td>10</td>
                        <td>2</td>
                        <td>5</td>
                        <td>1000</td>
                    </tr>
                    <tr>
                        <td>標準雙人房</td>
                        <td>10</td>
                        <td>2</td>
                        <td>5</td>
                        <td>1000</td>
                    </tr>
                    <tr>
                        <td>標準雙人房</td>
                        <td>10</td>
                        <td>2</td>
                        <td>5</td>
                        <td>1000</td>
                    </tr>
                </tbody>
            </Table>
        );
    }
}

export default RoomTable;