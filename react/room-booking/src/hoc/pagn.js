import React, { Component } from 'react';
import { Pagination } from 'react-bootstrap';

class Pagn extends Component {
    
    render() {

        const {showFirst, showPrev, pages, showNext, showLast, currentPage} = this.props;

        return (
            <Pagination className='mb-0'>
                {showFirst && <Pagination.First />}
                {showPrev && <Pagination.Prev />}
                {
                    pages.map(
                        page => (
                            <Pagination.Item key={page} active={page===currentPage}>{page}</Pagination.Item>
                        )
                    )
                }
                {showNext && <Pagination.Next />}
                {showLast && <Pagination.Last />}
            </Pagination>
        );
    }
}

export default Pagn;