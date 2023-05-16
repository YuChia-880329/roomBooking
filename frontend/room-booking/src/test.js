import React, { Component } from 'react';

class Test extends Component {

    state = {
        str : '',
        show : false
    }

    componentDidMount(){

        this.getData();
    }

    render() {
        const {str, show} = this.state;
        return (
            <div>
                {show && <h1>{str}</h1>}
                <button type='button' onClick={this.btnClicked}>show</button>
            </div>
        );
    }


    btnClicked = () => {

        this.setState({show : !this.state.show})
    }

    getData = async() => {

        const json = await this.fetchTest();
        this.setState({str : json.string});
    }

    fetchTest = async () => {

        const url = 'http://localhost:8086/roomBooking/t';
            
        const json = await fetch(url)
            .then(resp => resp.json());

        return json;
    }
}

export default Test;