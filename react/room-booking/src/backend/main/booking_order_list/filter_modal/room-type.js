import urls from '../../../../files/urls.json';
import config from '../../../../files/config.json';
import React, { Component } from 'react';
import { Col, Form, Row } from 'react-bootstrap';
import axios from 'axios';


const constant = {
    fetch : {
        url : {
            allRooms : urls.backend.bookingOrderList.allRooms
        },
        config : {
            timeout : config.fetch.timeout
        }
    }
}
class RoomType extends Component {

    constructor(props){

        super(props);
        this.state = {
            rooms : []
        }
    }

    componentDidMount(){

        this.getAllRooms();
    }
    
    render() {

        const {rooms} = this.state;
        const {value, onChange} = this.props;

        return (
            <Form.Group as={Row}>
                <Form.Label column xs='auto'>預定房型 : </Form.Label>
                <Col>
                    <Form.Control as='select' value={value} onChange={onChange}>
                        <option value=''>--- 請選擇 ---</option>
                        {rooms.map(
                            room => (
                                <option key={room.id} value={room.id}>{room.name}</option>
                            )
                        )}
                    </Form.Control>
                </Col>
            </Form.Group>
        );
    }

    // other
    getAllRooms = () => {

        this.allRooms();
    };


    // fetch
    allRooms = async () => {

        const {fetch} =  constant;
        const url = fetch.url.allRooms;
        const config = fetch.config;

        const {serverInfo, data} = await axios.get(url, {
                timeout : config.timeout,
                withCredentials: true
            })
            .then(rs => rs.data)
            .catch(error => console.error(error));

        const statusCode = serverInfo.statusCode;
        if(statusCode === 200){

            this.afterAllRooms(data);
        }
    };


    // after fetch
    afterAllRooms = (data) => {

        this.setState({
            rooms : data.rooms
        });
    };
}

export default RoomType;