import React, { Component } from 'react';
import { Stack, Button } from 'react-bootstrap';

class SortTableHeader extends Component {
    render() {

        // props
        const {text} = this.props;

        // style
        const headerStyle = {
            whiteSpace : 'nowrap',
            marginRight : '3rem'
        };

        return (
            <Stack direction='horizontal'>
                <div className='me-auto' >
                    <div style={headerStyle}>
                        <h6 className='mb-0'>
                            <b>{text}</b>
                        </h6>
                    </div>
                </div>
                <div>
                    <Stack>
                        <div>
                            <Button variant='outline-secondary' size='sm' className='little-btn'>▲</Button>
                        </div>
                        <div>
                            <Button variant='outline-secondary' size='sm' className='little-btn'>▼</Button>
                        </div>
                    </Stack>
                </div>
            </Stack>
        );
    }
}

export default SortTableHeader;