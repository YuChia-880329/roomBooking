import urls from '../../files/urls.json';
import config from '../../files/config.json';
import React, { Component } from 'react';
import { Container, Navbar, Nav, Button } from 'react-bootstrap';
import { Link } from 'react-router-dom';
import axios from 'axios';

const constant = {
    fetch : {
        url : {
            hotelName : urls.backend.hotelName,
            logout : urls.backend.logout
        },
        config : {
            timeout : config.fetch.timeout
        }
    }
}
class BackendNavbar extends Component {

    constructor(props){

        super(props);
        this.state = {
            hotelName : ''
        }
    }
    

    componentDidMount(){

        const {fctn} = this.props;

        fctn.checkLogin(() => {

            this.hotelName();
        });
    }

    render() {

        // state
        const {hotelName} = this.state;

        // style
        const brandStyle = {
            fontSize : '2rem'
        };

        return (
            <Navbar className='navbar-dark bg-secondary bg-gradient' expand='lg' fixed='top' collapseOnSelect>
                <Container fluid className='px-5'>
                    <Navbar.Brand style={brandStyle}>
                        歡迎 <span>{hotelName}</span>
                    </Navbar.Brand>
                    <Navbar.Toggle />
                    <Navbar.Collapse>
                        <Nav className='me-auto'>
                            <Nav.Link as={Link} to='./hotelInfo'>飯店資料</Nav.Link>
                            <Nav.Link as={Link} to='./roomList'>房型列表</Nav.Link>
                            <Nav.Link as={Link} to='./roomUpdate'>房型更新</Nav.Link>
                            <Nav.Link as={Link} to='./roomCreate'>新增房型</Nav.Link>
                            <Nav.Link as={Link} to='./bookingOrderList'>訂房訂單</Nav.Link>
                            <Nav.Link>前端頁面</Nav.Link>
                        </Nav>
                        <Nav>
                            <Nav.Link>
                                <Button variant='outline-light' onClick={this.onClickLogoutBtn}>登出</Button>
                            </Nav.Link>
                        </Nav>
                    </Navbar.Collapse>
                </Container>
            </Navbar>
        );
    }


    // on
    onClickLogoutBtn = (event) => {

        const {fctn} = this.props;

        fctn.showConfirmModal('確定要登出嗎 ? ', () => {

            fctn.closeConfirmModal();
            this.logout();
        });
    };



    // other
    hotelName = () => {

        this.hotelNameFetch();
    }
    logout = () => {

        this.logoutFetch();
    }
    toLogin = () => {

        window.location.href = './login';
    };



    // fetch
    hotelNameFetch = async () => {

        const {fctn} = this.props;
        const {fetch} =  constant;
        const url = fetch.url.hotelName;
        const config = fetch.config;

        const {serverInfo, data} = await axios.get(url, {
                timeout : config.timeout,
                withCredentials: true
            })
            .then(rs => rs.data)
            .catch(error => console.error(error));

        const statusCode = serverInfo.statusCode;
        if(statusCode === 200){

            this.afterHotelName(data);
        }else if(statusCode===400 || statusCode===500){

            fctn.showInformModal(serverInfo.msg);
        }
    };
    logoutFetch = async () => {

        const {fctn} = this.props;
        const {fetch} =  constant;
        const url = fetch.url.logout;
        const config = fetch.config;

        const {serverInfo, data} = await axios.post(url, undefined, {
                timeout : config.timeout,
                withCredentials: true
            })
            .then(rs => rs.data)
            .catch(error => console.error(error));

        const statusCode = serverInfo.statusCode;
        if(statusCode === 200){

            this.afterLogout(data);
        }else if(statusCode===400 || statusCode===500){

            fctn.showInformModal(serverInfo.msg);
        }
    };


    // after fetch
    afterHotelName = (data) => {

        this.setState({
            hotelName : data.hotelName
        });
    }
    afterLogout = (data) => {

        const {fctn} = this.props;

        fctn.showInformModal(data.msg, () => {

            if(data.success)
                this.toLogin();
            else
                fctn.closeInformModal();
        });
    }


    // setter
    setter = (colName, colVal, onSet) => {

        this.setState({
            [colName] : colVal
        }, () => {

            onSet && onSet();
        });
    }
}

export default BackendNavbar;