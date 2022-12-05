/**
 * CodeEntry.tsx
 * @author HU JIAJUN <e0556371@u.nus.edu>
 * @file Entry point for Code Scene
 */

import React from 'react';
import { DiffViewer, Editor } from 'components';
import { Button } from '@material-ui/core';
import { Optional } from 'nasi-lemak';

import { Type as AlgoType } from 'models/AlgoTypes';
import {
  partialCode as binarySearchIterationPartialCode,
  fullCode as binarySearchIterationFullCode,
} from 'assets/BinarySearchIteration';
import {
  partialCode as binarySearchRecursionPartialCode,
  fullCode as binarySearchRecursionFullCode,
} from 'assets/BinarySearchRecursion';
import {
  partialCode as bfsPartialCode,
  fullCode as bfsFullCode,
} from 'assets/BFS';
import {
  partialCode as levelOrderPartialCode,
  fullCode as levelOrderFullCode,
} from 'assets/LevelOrder';
import {
  partialCode as dfsPartialCode,
  fullCode as dfsFullCode,
} from 'assets/DFS';
import {
  partialCode as dijkstraPartialCode,
  fullCode as dijkstraFullCode,
} from 'assets/Dijkstra';
import {
  partialCode as backtrackingPartialCode,
  fullCode as backtrackingFullCode,
} from 'assets/Backtracking';
import {
  partialCode as listArrayPartialCode,
  fullCode as listArrayFullCode,
} from 'assets/ListArray';
import {
  partialCode as hashMapPartialCode,
  fullCode as hashMapFullCode,
} from 'assets/HashMap';
import {
  partialCode as hashMapListPartialCode,
  fullCode as hashMapListFullCode,
} from 'assets/HashMapList';
import {
  partialCode as mathPartialCode,
  fullCode as mathFullCode,
} from 'assets/Math';
import {
  partialCode as lengthOfNPartialCode,
  fullCode as lengthOfNFullCode,
} from 'assets/LengthOfN';
import {
  partialCode as breakInNestedLoopsPartialCode,
  fullCode as breakInNestedLoopsFullCode,
} from 'assets/BreakInNestedLoops';
import { useCodeEntry as useStyles } from 'styles/code';

export interface ICodeEntryProps {
  type: AlgoType;
}

export function CodeEntry(props: ICodeEntryProps) {
  const type = props.type;
  const styles = useStyles();
  const partialCode =
    type === 'BINARY_SEARCH_ITERATION'
      ? binarySearchIterationPartialCode
      : type === 'BINARY_SEARCH_RECURSION'
      ? binarySearchRecursionPartialCode
      : type === 'BFS'
      ? bfsPartialCode
      : type === 'LEVEL_ORDER'
      ? levelOrderPartialCode
      : type === 'DFS'
      ? dfsPartialCode
      : type === 'DIJKSTRA'
      ? dijkstraPartialCode
      : type === 'BACKTRACKING'
      ? backtrackingPartialCode
      : type === 'LIST_ARRAY'
      ? listArrayPartialCode
      : type === 'HASHMAP'
      ? hashMapPartialCode
      : type === 'HASHMAP_LIST'
      ? hashMapListPartialCode
      : type === 'MATH'
      ? mathPartialCode
      : type === 'LENGTH_OF_N'
      ? lengthOfNPartialCode
      : type === 'BREAK_IN_NESTED_LOOPS'
      ? breakInNestedLoopsPartialCode
      : '';
  const fullCode =
    type === 'BINARY_SEARCH_ITERATION'
      ? binarySearchIterationFullCode
      : type === 'BINARY_SEARCH_RECURSION'
      ? binarySearchRecursionFullCode
      : type === 'BFS'
      ? bfsFullCode
      : type === 'LEVEL_ORDER'
      ? levelOrderFullCode
      : type === 'DFS'
      ? dfsFullCode
      : type === 'DIJKSTRA'
      ? dijkstraFullCode
      : type === 'BACKTRACKING'
      ? backtrackingFullCode
      : type === 'LIST_ARRAY'
      ? listArrayFullCode
      : type === 'HASHMAP'
      ? hashMapFullCode
      : type === 'HASHMAP_LIST'
      ? hashMapListFullCode
      : type === 'MATH'
      ? mathFullCode
      : type === 'LENGTH_OF_N'
      ? lengthOfNFullCode
      : type === 'BREAK_IN_NESTED_LOOPS'
      ? breakInNestedLoopsFullCode
      : '';
  const [code, setCode] = React.useState(partialCode);
  const [isDone, setDone] = React.useState(false);
  return (
    <div className={styles.container}>
      <Editor code={code} setCode={setCode} />
      <Optional predicate={isDone}>
        <DiffViewer oldValue={fullCode} newValue={code} />
      </Optional>
      <div className={styles.buttonContainer}>
        <Optional predicate={!isDone}>
          <Button
            variant="contained"
            size="medium"
            color="primary"
            className={styles.button}
            onClick={() => setDone(true)}
          >
            Done
          </Button>
        </Optional>
        <Optional predicate={isDone}>
          <Button
            variant="contained"
            size="medium"
            color="primary"
            className={styles.button}
            onClick={() => setDone(false)}
          >
            Continue
          </Button>
        </Optional>
        <Button
          variant="contained"
          size="medium"
          color="primary"
          className={styles.button}
          onClick={() => {
            setCode(partialCode);
            setDone(false);
          }}
        >
          Reset
        </Button>
      </div>
    </div>
  );
}
