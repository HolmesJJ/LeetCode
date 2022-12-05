/**
 * MainEntry.ts
 * @author HU JIAJUN <e0556371@u.nus.edu>
 * @file MainEntry style sheet
 * @barrel hook
 */

import { makeStyles } from '@material-ui/core';

export const useMainEntry = makeStyles(() => ({
  container: {
    display: 'flex',
    alignItems: 'center',
    justifyContent: 'center',
    flexDirection: 'column',
  },
}));
