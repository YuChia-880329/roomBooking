import urls from '../../../../files/urls.json';
import config from '../../../../files/config.json';
import React, { Component } from 'react';
import { Col, Form, Row } from 'react-bootstrap';
import axios from 'axios';

const constant = {
    fetch : {
        url : {
            allSections : urls.backend.hotelInfo.allSections
        },
        config : {
            timeout : config.fetch.timeout
        }
    }
}
class Section extends Component {

    constructor(props){

        super(props);
        this.state = {
            sections : []
        };
    }

    componentDidMount(){

        this.getAllSections();
    }

    render() {

        const {sections} = this.state;

        return (
            <Form.Group as={Row}>
                <Form.Label column xs='auto'>飯店地址區域 : </Form.Label>
                <Col>
                    <Form.Select>
                        <option value=''>---- 請選擇 ----</option>
                        {sections.map(
                            section => (
                                <option key={section.code} value={section.code}>{section.name}</option>
                            )
                        )}
                    </Form.Select>
                </Col>
            </Form.Group>
        );
    }

    // other
    getAllSections = () => {

        this.allSections();
    };


    // fetch
    allSections = async () => {

        const {fetch} =  constant;
        const url = fetch.url.allSections;
        const config = fetch.config;

        const {serverInfo, data} = await axios.get(url, {
                timeout : config.timeout
            })
            .then(rs => rs.data)
            .catch(error => console.error(error));

        const statusCode = serverInfo.statusCode;
        if(statusCode === 200){

            this.afterAllSections(data);
        }
    };


    // after fetch
    afterAllSections = (data) => {

        this.setState({
            sections : data.sections
        });
    };
}

export default Section;