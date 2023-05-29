import React, { Component } from 'react';
import { Pagination } from 'react-bootstrap';

class Pagn extends Component {
    
    render() {

        const {pagn, fctn} = this.props;

        return (
            <Pagination className='mb-0'>
                {pagn.first.show && <Pagination.First onClick={() => fctn.pageOnClick(pagn.first.toPage)} />}
                {pagn.prev.show && <Pagination.Prev onClick={() => fctn.pageOnClick(pagn.prev.toPage)} />}
                {
                    pagn.pages.map(
                        page => (
                            <Pagination.Item key={page} active={page===pagn.currentPage} onClick={page===pagn.currentPage ? undefined : () => fctn.pageOnClick(page)}>{page}</Pagination.Item>
                        )
                    )
                }
                {pagn.next.show && <Pagination.Next onClick={() => fctn.pageOnClick(pagn.next.toPage)} />}
                {pagn.last.show && <Pagination.Last onClick={() => fctn.pageOnClick(pagn.last.toPage)} />}
            </Pagination>
        );
    }
}

export default Pagn;