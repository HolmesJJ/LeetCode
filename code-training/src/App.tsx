/**
 * App.tsx
 * @author HU JIAJUN <e0556371@u.nus.edu>
 * @file React Application Base
 */

import { BrowserRouter, Routes, Route } from 'react-router-dom';

import { MainEntry } from 'scenes/';

export function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<MainEntry />}></Route>
      </Routes>
    </BrowserRouter>
  );
}
