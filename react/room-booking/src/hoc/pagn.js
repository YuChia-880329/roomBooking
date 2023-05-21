import React, { Component } from 'react';
import { Pagination } from 'react-bootstrap';

class Pagn extends Component {
    render() {

        // props
        const {pages} = this.props;

        return (
            <Pagination className='mb-0'>
                <Pagination.First />
                <Pagination.Prev />
                {
                    pages.map(
                        page => (<Pagination.Item>{page}</Pagination.Item>))}
                <Pagination.Next />
                <Pagination.Last />
            </Pagination>
        );
    }
}

export default Pagn;