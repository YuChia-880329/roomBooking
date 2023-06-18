import urls from '../../files/urls.json';
import config from '../../files/config.json';
import axios from 'axios';
import React, { Component, Fragment } from 'react';
import { Container, Navbar, Nav, Button, Form, Row, Col } from 'react-bootstrap';
import { useNavigate } from 'react-router-dom';

const constant = {
    fetch : {
        url : {
            logout : urls.frontend.logout,
            searchHotel : urls.frontend.searchHotel,
            memberName : urls.frontend.memberName
        },
        config : {
            timeout : config.fetch.timeout
        },
        req : {
            searchHotel : {
                name : ''
            }
        }
    }
};

class FrontendNavbarWrapped extends Component {
    
    constructor(props){

        super(props);
        this.state = {
            homeTitle : '訂房網',
            validatedSearchHotelForm : false,
            isLogin : false,
            memberName : 'Ken',
            valueSearchHotel : ''
        };
    }

    componentDidMount(){

        const {fctn} = this.props;
        
        this.memberName(() => {

            fctn.checkLogin((failMsg) => {

                this.setter('isLogin', false);
            }, () => {
    
                this.setter('isLogin', true);
            });
        });
    }

    render() {

        // style
        const brandStyle = {
            fontSize : '2rem'
        };
        const {isLogin} = this.state;

        return (
            <Navbar className='navbar-dark bg-secondary bg-gradient' expand='lg' fixed='top' collapseOnSelect>
                <Container fluid className='px-5'>
                    <Navbar.Brand as={Nav.Link} style={brandStyle} onClick={this.onClickHomeTitle}>
                        {this.getter('homeTitle')}
                    </Navbar.Brand>
                    <Navbar.Toggle />
                    <Navbar.Collapse>
                        <Nav className='me-auto'>
                            <Form noValidate validated={this.getter('validatedSearchHotelForm')} onSubmit={this.onSubmitSearchForm}>
                                <Form.Group as={Row}>
                                    <Col>
                                        <Form.Control htmlSize={50} value={this.getter('valueSearchHotel')} 
                                                onChange={this.onChangeSearchHotel} required />
                                        <Form.Control.Feedback type='invalid'>請輸入搜尋條件</Form.Control.Feedback>
                                    </Col>
                                    <Col className='ms-1'>
                                        <Button type='send' variant='outline-light'>搜尋飯店</Button>
                                    </Col>
                                </Form.Group>
                            </Form>
                        </Nav>
                        {
                            isLogin ? (
                                <Fragment>
                                    <Navbar.Text className='me-3 fs-2'>
                                        歡迎 <span>{this.getter('memberName')}</span>
                                    </Navbar.Text>
                                    <Nav>
                                        <Nav.Link>
                                            <Button variant='outline-light' onClick={this.onClickShoppingCartBtn}>前往購物車</Button>
                                        </Nav.Link>
                                        <Nav.Link>
                                            <Button variant='outline-light' onClick={this.onClickLogoutBtn}>登出</Button>
                                        </Nav.Link>
                                    </Nav>
                                </Fragment>
                            ) : (
                                <Nav>
                                    <Nav.Link>
                                        <Button variant='outline-light' onClick={this.onClickLoginBtn}>登入</Button>
                                    </Nav.Link>
                                    <Nav.Link>
                                        <Button variant='outline-light' onClick={this.onClickSignupBtn}>註冊</Button>
                                    </Nav.Link>
                                </Nav>
                            )
                        }
                    </Navbar.Collapse>
                </Container>
            </Navbar>
        );
    }


    // on
    onChangeSearchHotel = (event) => {

        this.setter('valueSearchHotel', event.target.value);
    };
    onClickShoppingCartBtn = (event) => {

        const {navigate} = this.props;

        navigate('/roomBooking/shoppingcart');
    };
    onClickLoginBtn = (event) => {

        const {navigate} = this.props;

        navigate('/roomBooking/login');
    };
    onClickSignupBtn = (event) => {

        const {navigate} = this.props;

        navigate('/roomBooking/signup');
    };
    onClickLogoutBtn = (event) => {

        const {fctn} = this.props;

        fctn.showConfirmModal('確定要登出 ? ', () => {

            fctn.closeConfirmModal();
            this.logout();
        });
    };
    onSubmitSearchForm = (event) => {

        event.preventDefault();
        this.setter('validatedSearchHotelForm', true, () => {

            if(event.target.checkValidity()){

                this.searchHotel();
            }
        });
    };
    onClickHomeTitle = (event) => {

        const {navigate} = this.props;

        navigate('../home');
    };



    // other
    logout = () => {

        this.logoutFetch();
    };
    searchHotel = () => {

        const req = constant.fetch.req.searchHotel;

        req.name = this.getter('valueSearchHotel');
        this.searchHotelFetch(req);
    };
    memberName = (onSuccess) => {

        this.memberNameFetch(onSuccess);
    };



    // fetch
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
    searchHotelFetch = async (params) => {

        const {fctn} = this.props;
        const {fetch} =  constant;
        const url = fetch.url.searchHotel;
        const config = fetch.config;

        const {serverInfo, data} = await axios.get(url, {
                timeout : config.timeout,
                withCredentials: true,
                params : params
            })
            .then(rs => rs.data)
            .catch(error => console.error(error));

        const statusCode = serverInfo.statusCode;
        if(statusCode === 200){

            this.afterSearchHotel(data);
        }else if(statusCode===400 || statusCode===500){

            fctn.showInformModal(serverInfo.msg);
        }
    };
    memberNameFetch = async (onSuccess) => {

        const {fctn} = this.props;
        const {fetch} =  constant;
        const url = fetch.url.memberName;
        const config = fetch.config;

        const {serverInfo, data} = await axios.get(url, {
                timeout : config.timeout,
                withCredentials: true
            })
            .then(rs => rs.data)
            .catch(error => console.error(error));

        const statusCode = serverInfo.statusCode;
        if(statusCode === 200){

            this.afterMemberName(data, onSuccess);
        }else if(statusCode===400 || statusCode===500){

            fctn.showInformModal(serverInfo.msg);
        }
    };



    // after fetch
    afterLogout = (data) => {

        const {fctn} = this.props;

        fctn.showInformModal(data.msg, () => {

            fctn.closeInformModal();
            if(data.success){

                this.setter('isLogin', false, () => {

                    window.location.href = '/roomBooking/home';
                });
            }
        });
    };
    afterSearchHotel = (data) => {

        const {fctn} = this.props;

        if(data.hasHotel){

            fctn.showConfirmModal(`確定前往${this.getter('valueSearchHotel')} ?`, () => {

                this.setter('validatedSearchHotelForm', false, () => {

                    fctn.closeConfirmModal();
                    window.location.href = `/roomBooking/hotelPage/${data.hotelId}`;
                });
            });
        }else {

            fctn.showInformModal(data.msg);
        }
    };
    afterMemberName(data, onSuccess){

        this.setter('memberName', data.memberName, () => {

            onSuccess && onSuccess();
        });
    }



    // setter getter
    setter = (colName, colVal, onSet) => {

        this.setState({
            [colName] : colVal
        }, () => {

            onSet && onSet();
        });
    };
    getter = (colName) => {

        return this.state[colName];
    };
}

const FrontendNavbar = props => {

    const navigate = useNavigate();

    return (<FrontendNavbarWrapped {...props} navigate={navigate} />);
};

export default FrontendNavbar;