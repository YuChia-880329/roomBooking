import React, { Component } from 'react';
import { Stack } from 'react-bootstrap';
import Hotel from './hotel/hotel';

class Hotels extends Component {

    render() {

        const getter = {
            hotel : {
                getFilterForm : this.props.getter.getFilterForm
            }
        };

        return (
            <Stack gap={4}>
                {
                    this.getter('items').map(item => (
                        <Hotel key={item.roomId} value={item} getter={getter.hotel} />
                    ))
                }
            </Stack>
        );
    }


    // setter getter
    setter = (colName, colVal, onSet) => {

        const {setter, getter} = this.props;

        setter.setHotels({
            ...getter.getHotels(),
            [colName] : colVal
        }, onSet);
    };
    getter = (colName) => {

        const {getter} = this.props;
        return getter.getHotels()[colName];
    }
}

export default Hotels;