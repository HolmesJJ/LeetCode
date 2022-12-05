/**
 * App.tsx
 * @author HU JIAJUN <e0556371@u.nus.edu>
 * @file React Application Base
 */

import { BrowserRouter, Routes, Route } from 'react-router-dom';

import { MainEntry, CodeEntry, MrqEntry } from 'scenes/';

export function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<MainEntry />}></Route>
        <Route
          path="/code/binarySearchIteration"
          element={<CodeEntry type={'BINARY_SEARCH_ITERATION'} />}
        ></Route>
        <Route
          path="/code/binarySearchRecursion"
          element={<CodeEntry type={'BINARY_SEARCH_RECURSION'} />}
        ></Route>
        <Route path="/code/bfs" element={<CodeEntry type={'BFS'} />}></Route>
        <Route
          path="/code/levelOrder"
          element={<CodeEntry type={'LEVEL_ORDER'} />}
        ></Route>
        <Route path="/code/dfs" element={<CodeEntry type={'DFS'} />}></Route>
        <Route
          path="/code/dijkstra"
          element={<CodeEntry type={'DIJKSTRA'} />}
        ></Route>
        <Route
          path="/code/backtracking"
          element={<CodeEntry type={'BACKTRACKING'} />}
        ></Route>
        <Route
          path="/code/listArray"
          element={<CodeEntry type={'LIST_ARRAY'} />}
        ></Route>
        <Route
          path="/code/hashMap"
          element={<CodeEntry type={'HASHMAP'} />}
        ></Route>
        <Route
          path="/code/hashMapList"
          element={<CodeEntry type={'HASHMAP_LIST'} />}
        ></Route>
        <Route path="/code/math" element={<CodeEntry type={'MATH'} />}></Route>
        <Route
          path="/code/lengthOfN"
          element={<CodeEntry type={'LENGTH_OF_N'} />}
        ></Route>
        <Route
          path="/code/breakInNestedLoops"
          element={<CodeEntry type={'BREAK_IN_NESTED_LOOPS'} />}
        ></Route>
        <Route
          path="/mrq/binarySearch"
          element={<MrqEntry type={'BINARY_SEARCH'} />}
        ></Route>
        <Route path="/mrq/bfs" element={<MrqEntry type={'BFS'} />}></Route>
        <Route path="/mrq/dfs" element={<MrqEntry type={'DFS'} />}></Route>
        <Route
          path="/mrq/dijkstra"
          element={<MrqEntry type={'DIJKSTRA'} />}
        ></Route>
        <Route
          path="/mrq/backtracking"
          element={<MrqEntry type={'BACKTRACKING'} />}
        ></Route>
      </Routes>
    </BrowserRouter>
  );
}
