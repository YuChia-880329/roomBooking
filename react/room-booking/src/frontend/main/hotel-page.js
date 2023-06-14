import houseIcon from '../../image/house-icon.png';
import React, { Component, Fragment } from 'react';
import { Col, Image, Row, Stack } from 'react-bootstrap';
import FilterForm from './hotelPage/filter-form';
import FrontendMain from '../../hoc/frontend-main';
import Introduction from './hotelPage/introduction';
import Rooms from './hotelPage/rooms';
import Pagn from '../../hoc/pagn';
import BuyModal from './hotelPage/buy-modal';
import { useLocation, useParams } from 'react-router-dom';


class HotelPageWrapped extends Component {

    constructor(props){

        super(props);
        this.state = {
            filterForm : {
                validated : false,
                date : {
                    valueCheckinDate : this.props.data.checkinDate,
                    valueCheckoutDate : this.props.data.checkoutDate
                },
                number : {
                    value : this.props.data.number
                }
            },
            introduction : {
                imgUrl : '',
                hotelName : '',
                address : '',
                description : '',
                feature : []
            },
            rooms : [],
            pagination : {
                first : {
                    show : true,
                    toPage : 1
                },
                prev : {
                    show : true,
                    toPage : 1
                },
                pages : [1, 2, 3],
                next : {
                    show : true,
                    toPage : 3
                },
                last : {
                    show : true,
                    toPage : 3 
                },
                currentPage : 2
            }
        };
    }

    render() {

        return (
            <FrontendMain Content={this.Content} />
        );
    }

    // jsx
    Content = () => {

        const homeIconStyle = {
            width : '16rem',
            height : '16rem'
        };
        const{pagination} = this.state;
        const setter = {
            filterForm : {
                setFilterForm : (colVal, onSet) => this.setter('filterForm', colVal, onSet)
            }
        };
        const getter = {
            filterForm : {
                getFilterForm : () => this.getter('filterForm')
            }
        };
        const fctn = {
            filterForm : {
                showInformModal : this.props.fctn.showInformModal,
                closeInformModal : this.props.fctn.closeInformModal
            }
        };

        return (
            <Fragment>
                <Row className='justify-content-center'>
                    <Col xs='auto' className='align-self-center'>
                        <Image src={houseIcon} style={homeIconStyle} />
                    </Col>
                    <Col xs={8}>
                        <FilterForm setter={setter.filterForm} getter={getter.filterForm} fctn={fctn.filterForm} />
                    </Col>
                </Row>
                <div className='mt-5'>
                    <Introduction />
                </div>
                <div className='my-5 pt-5'>
                    <Rooms />
                </div>
                <Stack direction='horizontal'>
                    <div className='ms-auto'>
                        <Pagn pagn={pagination} />
                    </div>
                </Stack>
                <BuyModal />
            </Fragment>
        );
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

const HotelPage = props => {

    const params = useParams();
    const location = useLocation();
    const data = {
        ...params,
        ...location.state
    };

    return (<HotelPageWrapped {...props} data={data} />);
};

export default HotelPage;