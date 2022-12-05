/**
 * MrqEntry.tsx
 * @author HU JIAJUN <e0556371@u.nus.edu>
 * @file Entry point for Mrq Scene
 */

import React from 'react';
import { Button, Checkbox } from '@material-ui/core';
import _ from 'lodash';

import { Type as MrqType } from 'models/MrqTypes';
import { useMrqEntry as useStyles } from 'styles/mrq';
import mrqs from 'assets/Mrqs.json';

export interface IMrqEntryProps {
  type: MrqType;
}

function randomIntFromInterval(min: number, max: number) {
  return Math.floor(Math.random() * (max - min + 1) + min);
}

export function MrqEntry(props: IMrqEntryProps) {
  const type = props.type;
  const styles = useStyles();
  const [isDone, setDone] = React.useState(false);
  const [expectedOptions, setExpectedOptions] = React.useState<string[]>([]);
  const [expectedCorrectOptions, setExpectedCorrectOptions] = React.useState<
    string[]
  >([]);
  const [selectedOptions, setSelectedOptions] = React.useState<string[]>([]);

  React.useEffect(() => {
    const mrqType =
      type === 'BINARY_SEARCH'
        ? 'BinarySearch'
        : type === 'BFS'
        ? 'BFS'
        : type === 'DFS'
        ? 'DFS'
        : type === 'DIJKSTRA'
        ? 'Dijkstra'
        : 'Backtracking';

    // Correct Mrqs
    const correctMrqs = _.pick(mrqs, mrqType);
    const correctOptions = _.reduce(
      correctMrqs,
      (result: string[], current) => result.concat(current),
      [],
    );

    // Remaining Mrqs
    const remainingMrqs = _.omit(mrqs, mrqType);
    const remainingOptions = _.reduce(
      remainingMrqs,
      (result: string[], current) => result.concat(current),
      [],
    );

    // Correct Options
    const shuffledCorrectOptions = correctOptions.sort(
      () => 0.5 - Math.random(),
    );
    const randomInt = randomIntFromInterval(1, 4);
    const numberOfExpectedCorrectOptions =
      randomInt <= correctOptions.length ? randomInt : correctOptions.length;
    const expectedCorrectOptions = shuffledCorrectOptions.slice(
      0,
      numberOfExpectedCorrectOptions,
    );

    // Remaining Options
    const shuffledRemainingOptions = remainingOptions.sort(
      () => 0.5 - Math.random(),
    );
    const numberOfExpectedRemainingOptions = 4 - numberOfExpectedCorrectOptions;
    const expectedRemainingOptions = shuffledRemainingOptions.slice(
      0,
      numberOfExpectedRemainingOptions,
    );

    // Expected Options
    setExpectedOptions(expectedCorrectOptions.concat(expectedRemainingOptions));
    setExpectedCorrectOptions(expectedCorrectOptions);
  }, [type]);

  console.log(isDone);
  console.log(expectedCorrectOptions);

  const handleChangeCheckbox = (
    event: React.ChangeEvent<HTMLInputElement>,
    option: string,
  ) => {
    if (event.target.checked) {
      setSelectedOptions((selectedOptions) => [...selectedOptions, option]);
    } else {
      setSelectedOptions(
        selectedOptions.filter((selectedOption) => selectedOption !== option),
      );
    }
  };

  return (
    <div className={styles.container}>
      {expectedOptions.map((option, key) => (
        <div className={styles.checkboxContainer} key={key}>
          <Checkbox
            checked={selectedOptions.includes(option)}
            color="primary"
            size="medium"
            onChange={(even) => handleChangeCheckbox(even, option)}
          />
          {isDone ? (
            expectedCorrectOptions.includes(option) &&
            selectedOptions.includes(option) ? (
              <p className={styles.correctOption}>{option}</p>
            ) : expectedCorrectOptions.includes(option) &&
              !selectedOptions.includes(option) ? (
              <p className={styles.wrongOption}>{option}</p>
            ) : !expectedCorrectOptions.includes(option) &&
              selectedOptions.includes(option) ? (
              <p className={styles.wrongOption}>{option}</p>
            ) : (
              <p>{option}</p>
            )
          ) : (
            <p>{option}</p>
          )}
        </div>
      ))}
      <div className={styles.buttonContainer}>
        <Button
          variant="contained"
          size="medium"
          color="primary"
          className={styles.button}
          onClick={() => setDone(true)}
        >
          Done
        </Button>
        <Button
          variant="contained"
          size="medium"
          color="primary"
          className={styles.button}
          onClick={() => {
            setSelectedOptions([]);
            setDone(false);
          }}
        >
          Reset
        </Button>
      </div>
    </div>
  );
}
