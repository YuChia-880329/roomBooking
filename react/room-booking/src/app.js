import React, { Component } from 'react';
import Backend from './backend';
import { BrowserRouter } from 'react-router-dom';

class App extends Component {
    render() {
        return (
            <BrowserRouter>
                <Backend />
            </BrowserRouter>
        );
    }
}

export default App;