/**
 * MrqEntry.ts
 * @author HU JIAJUN <e0556371@u.nus.edu>
 * @file MrqEntry style sheet
 * @barrel hook
 */

import { makeStyles } from '@material-ui/core';

export const useMrqEntry = makeStyles((theme) => ({
  container: {
    display: 'flex',
    alignItems: 'center',
    justifyContent: 'center',
    flexDirection: 'column',
  },
  checkboxContainer: {
    display: 'flex',
    alignItems: 'center',
    justifyContent: 'start',
    flexDirection: 'row',
    minWidth: 600,
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
  },
  correctOption: {
    color: theme.palette.success.light,
  },
  wrongOption: {
    color: theme.palette.error.light,
  },
}));
