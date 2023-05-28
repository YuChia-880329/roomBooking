import React, { Component } from 'react';
import { Stack } from 'react-bootstrap';
import { IconCaretUp, IconCaretDown } from '@tabler/icons-react';

class SortTh extends Component {
    
    render() {

        // props
        const {text, ascOnClick, descOnClick} = this.props;

        // style
        const headerStyle = {
            paddingLeft : '1rem',
            paddingRight : '1rem'
        };
        const textStyle = {
            whiteSpace : 'nowrap',
            marginRight : '3rem'
        };
        
        return (
            <th style={headerStyle}>
                <Stack direction='horizontal'>
                    <div className='me-auto' >
                        <div style={textStyle}>
                            <h6 className='mb-0'>
                                <b>{text}</b>
                            </h6>
                        </div>
                    </div>
                    <div>
                        <Stack gap={1}>
                            <button type='button' className='caretBtn' onClick={ascOnClick} >
                                <IconCaretUp width={20} height={14} />
                            </button>
                            <button type='button' className='caretBtn' onClick={descOnClick} >
                                <IconCaretDown width={20} height={14} />
                            </button>
                        </Stack>
                    </div>
                </Stack>
            </th>
        );
    }
}

export default SortTh;