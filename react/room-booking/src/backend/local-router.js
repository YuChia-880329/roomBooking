import React, { Component } from 'react';
import { Nav } from 'react-bootstrap';
import { BrowserRouter, Link } from 'react-router-dom';

class router extends Component {
    render() {
        return (
            <Nav>
                <BrowserRouter>
                    <Nav.Link>
                        <Link>飯店資料</Link>
                    </Nav.Link>
                    <Nav.Link>
                        <Link>房型列表</Link>
                    </Nav.Link>
                    <Nav.Link>
                        <Link>房型更新</Link>
                    </Nav.Link>
                    <Nav.Link>
                        <Link>新增房型</Link>
                    </Nav.Link>
                    <Nav.Link>
                        <Link>訂房訂單</Link>
                    </Nav.Link>
                    <Nav.Link>
                        <Link>前端頁面</Link>
                    </Nav.Link>
                </BrowserRouter>
            </Nav>
        );
    }
}

export default router;