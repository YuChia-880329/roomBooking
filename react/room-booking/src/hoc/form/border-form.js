import React, { Component } from 'react';

class BorderForm extends Component {
    
    render() {

        const {Content} = this.props;
        const borderStyle = {
            padding : '4.5rem 4.5rem 3rem'
        };

        return (
            <div className='border border-2 border-secondary rounded-4 rounded' style={borderStyle}>
                <Content />
            </div>
        );
    }
}

export default BorderForm;