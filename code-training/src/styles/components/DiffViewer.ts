/**
 * DiffViewer.ts
 * @author HU JIAJUN <e0556371@u.nus.edu>
 * @file DiffViewer style sheet
 * @barrel hook
 */

import { makeStyles } from '@material-ui/core/styles';

export const useDiffViewer = makeStyles(() => ({
  container: {
    alignItems: 'center',
    justifyContent: 'center',
    display: 'flex',
    minWidth: 1200,
  },
}));
