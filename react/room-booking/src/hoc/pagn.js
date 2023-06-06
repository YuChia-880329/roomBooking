import React, { Component } from 'react';
import { Pagination } from 'react-bootstrap';

class Pagn extends Component {
    
    render() {

        const {pagn, turnPage} = this.props;

        return (
            <Pagination className='mb-0'>
                {pagn.first.show && <Pagination.First onClick={e => turnPage(pagn.first.toPage)} />}
                {pagn.prev.show && <Pagination.Prev onClick={e => turnPage(pagn.prev.toPage)} />}
                {
                    pagn.pages.map(
                        page => (
                            <Pagination.Item key={page} active={page===pagn.currentPage} 
                                    onClick={page===pagn.currentPage ? undefined : e => turnPage(page)}>{page}</Pagination.Item>
                        )
                    )
                }
                {pagn.next.show && <Pagination.Next onClick={() => turnPage(pagn.next.toPage)} />}
                {pagn.last.show && <Pagination.Last onClick={() => turnPage(pagn.last.toPage)} />}
            </Pagination>
        );
    }
}

export default Pagn;