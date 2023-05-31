import urls from '../../../../files/urls.json';
import config from '../../../../files/config.json';
import axios from 'axios';
import React, { Component } from 'react';
import { Col, Form, Row } from 'react-bootstrap';


const constant = {
    fetch : {
        url : {
            allPayMethods : urls.backend.bookingOrderList.allPayMethods
        },
        config : {
            timeout : config.fetch.timeout
        }
    }
}
class PayMethod extends Component {

    constructor(props){

        super(props);
        this.state = {
            payMethods : []
        }
    }

    componentDidMount(){

        this.getAllPayMethods();
    }

    render() {

        const rowStyle = {
            paddingTop : 'calc(.375rem + 1px)'
        };
        const checkboxStyle = {
            margin : '0'
        };
        const {payMethods} = this.state;
        const {values, onChange} = this.props;

        return (
            <Form.Group as={Row}>
                <Form.Label column xs='auto'>付款方式 : </Form.Label>
                <Col>
                    <Row xs='auto' className='g-3' style={rowStyle}>
                        {
                            payMethods.map(payMethod => (
                                <Col key={payMethod.id}>
                                    <Form.Check type='checkbox' label={payMethod.name} style={checkboxStyle} value={payMethod.id}
                                            checked={values.includes(`${payMethod.id}`)} onChange={onChange} />
                                </Col>
                            ))
                        }
                    </Row>
                </Col>
            </Form.Group>
        );
    }

     // other
     getAllPayMethods = () => {

        this.allPayMethods();
    };


    // fetch
    allPayMethods = async () => {

        const {fetch} =  constant;
        const url = fetch.url.allPayMethods;
        const config = fetch.config;

        const {serverInfo, data} = await axios.get(url, {
                timeout : config.timeout
            })
            .then(rs => rs.data)
            .catch(error => console.error(error));

        const statusCode = serverInfo.statusCode;
        if(statusCode === 200){

            this.afterAllPayMethods(data);
        }
    };


    // after fetch
    afterAllPayMethods = (data) => {

        // console.log('data : ', data);
        this.setState({
            payMethods : data.payMethods
        });
    };
}

export default PayMethod;