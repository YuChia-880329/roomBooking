import React, { Component } from 'react';
import { Container, Stack } from 'react-bootstrap';
import Room from './rooms/room';

class Rooms extends Component {

    render() {

        const containerStyle = {
            width : '85%'
        };
        const setter = {
            room : {
                setItems : (colVal, onSet) => this.setter('items', colVal, onSet)
            }
        };
        const getter = {
            room : {
                getItems : () => this.getter('items')
            }
        };
        const fctn = {
            room : {
                showInformModal : this.props.fctn.showInformModal,
                closeInformModal : this.props.fctn.closeInformModal
            }
        };


        return (
            <Container style={containerStyle}>
                <Stack gap={4}>
                    {
                        this.getter('items').map(
                            item => (
                                <Room key={item.roomId} value={item} setter={setter.room} getter={getter.room} fctn={fctn.room} />
                            )
                        )
                    }
                </Stack>
            </Container>
        );
    }


    // setter getter
    setter = (colName, colVal, onSet) => {

        const {setter, getter} = this.props;

        setter.setRooms({
            ...getter.getRooms(),
            [colName] : colVal
        }, onSet);
    };
    getter = (colName) => {

        const {getter} = this.props;
        return getter.getRooms()[colName];
    }
}

export default Rooms;