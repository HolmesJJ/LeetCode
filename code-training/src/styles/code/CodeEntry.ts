/**
 * CodeEntry.ts
 * @author HU JIAJUN <e0556371@u.nus.edu>
 * @file CodeEntry style sheet
 * @barrel hook
 */

import { makeStyles } from '@material-ui/core';

export const useCodeEntry = makeStyles(() => ({
  container: {
    display: 'flex',
    alignItems: 'center',
    justifyContent: 'center',
    flexDirection: 'column',
  },
  buttonContainer: {
    display: 'flex',
    alignItems: 'center',
    justifyContent: 'center',
    flexDirection: 'row',
  },
  button: {
    marginTop: 20,
    marginLeft: 20,
    marginRight: 20,
    width: 130,
    height: 40,
  }
}));
