import React, { Component } from 'react';
import Backend from './backend';
import { BrowserRouter } from 'react-router-dom';
import Frontend from './frontend';

class App extends Component {

    render() {
        
        return (
            <BrowserRouter>
                <Backend />
                <Frontend />
            </BrowserRouter>
        );
    }
}

export default App;