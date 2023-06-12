import React, { Component } from 'react';
import Backend from './backend';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Frontend from './frontend';

class App extends Component {

    render() {
        
        return (
            <BrowserRouter>
                <Routes>
                    <Route path='/roomBooking/backend/*' element={<Backend />} />
                    <Route path='/roomBooking/*' element={<Frontend />} />
                </Routes>
            </BrowserRouter>
        );
    }
}

export default App;