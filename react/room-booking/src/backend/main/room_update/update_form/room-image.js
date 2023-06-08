import React, { Component } from 'react';
import { Col, Form, Image, Row, Stack } from 'react-bootstrap';

class RoomImage extends Component {

    render() {

        const imageStyle = {
            maxHeight : '10rem',
            maxWidth : '10rem',
            height : '10rem',
            width : '10rem'
        };
        const {value} = this.props;

        return (
            <Form.Group as={Row}>
                <Form.Label column xs='auto'>房間照片 : </Form.Label>
                <Col>
                    <Stack gap={4}>
                        <Form.Control as='select' value={value.value} onChange={this.onChange} disabled={value.disabled}>
                            {
                                value.disabled ? 
                                        (<option value={-1}>----------------</option>) :
                                                value.options.map(
                                                    op => (
                                                        <option key={op.id} value={op.id}>{op.imgName}</option>
                                                    )
                                                )
                            }
                        </Form.Control>
                        {
                            !value.disabled &&
                                <div>
                                    <Image src={value.url} alt='room photo' className='d-inline-block' style={imageStyle} />
                                </div>
                        }
                        
                    </Stack>
                </Col>
            </Form.Group>
        );
    }

    // on
    onChange = (event) => {

        const {value, setter, getter} = this.props;
        const {options} = value;
        const target = options.reduce((a, c) => {

            if(a !== null)
                return a;
            else if(c.id === parseInt(event.target.value, 10))
                return c;
            else
                return null;
        }, null);

        this.setter('value', event.target.value, () => {

            this.setter('url', target.url, () => {

                setter.setImageOrder({
                    ...getter.getImageOrder(),
                    value : target.order
                });
            });
        });
    };


    // setter
    setter = (colName, colVal, onSet) => {

        const {setter, value} = this.props;
        setter.setRoomImage({
            ...value,
            [colName] : colVal
        }, onSet);
    };
}

export default RoomImage;