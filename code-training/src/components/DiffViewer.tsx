/**
 * DiffViewer.tsx
 * @author HU JIAJUN <e0556371@u.nus.edu>
 * @file DiffViewer Component
 */

import ReactDiffViewer from 'react-diff-viewer-continued';

import { useDiffViewer as useStyles } from 'styles/components/DiffViewer';

export interface IEditorProps {
  oldValue: string;
  newValue: string;
}

export function DiffViewer(props: IEditorProps) {
  const styles = useStyles();
  const oldValue = props.oldValue;
  const newValue = props.newValue;
  return (
    <div className={styles.container}>
      <ReactDiffViewer
        oldValue={oldValue}
        newValue={newValue}
        splitView={true}
      />
    </div>
  );
}
