import React, { Component } from 'react';

class SortTableTd extends Component {

    render() {

        // props
        const {text} = this.props;

        // style
        const hdStyle = {
            paddingLeft : '1rem',
            paddingRight : '1rem'
        };

        return (
            <td style={hdStyle}>{text}</td>
        );
    }
}

export default SortTableTd;