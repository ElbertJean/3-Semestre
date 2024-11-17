import React from 'react';
import { BrowserRouter, Routes, Route, Navigate } from 'react-router-dom';

import Home from '../pages/Home/Home';
import Register from '../pages/Register/Register';
import Products from '../pages/Products/Products';

function RouterRoutes() {
    return(
        <BrowserRouter>
            <Routes>
                <Route path='/' element={<Home />} />
                <Route path='/register' element={<Register />} />
                <Route path='/products' element={<Products />} />
            </Routes>
        </BrowserRouter>
    )
}

export default RouterRoutes;
