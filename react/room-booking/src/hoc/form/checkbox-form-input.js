import React, { Component } from 'react';
import { Col, Form, Row } from 'react-bootstrap';
import HorizontalFormInput from './horizontal-form-input';

class CheckboxFormInput extends Component {
    
    ctrl = () => {

        // props
        const {rowColsNum, checks} = this.props;

        // style
        const rowStyle = {
            paddingTop : 'calc(.375rem + 1px)'
        };
        const checkboxStyle = {
            margin : '0'
        };

        return (
            <Row xs={rowColsNum} className='g-3' style={rowStyle}>
                
                {checks.map(check => (
                    <Col>
                        <Form.Check type='checkbox' label={check} style={checkboxStyle} />
                    </Col>
                ))}
            </Row>
        );
    };
    render() {
        
        // props
        const {text, AddCtrl} = this.props;

        return (
            <HorizontalFormInput text={text} Ctrl={this.ctrl} AddCtrl={AddCtrl} />
        );
    }
}

export default CheckboxFormInput;