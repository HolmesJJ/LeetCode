/**
 * Editor.tsx
 * @author HU JIAJUN <e0556371@u.nus.edu>
 * @file Editor Component
 */

import CodeEditor from '@uiw/react-textarea-code-editor';

export interface IEditorProps {
  code: string;
  setCode: (code: string) => void;
}

export function Editor(props: IEditorProps) {
  const code = props.code;
  const setCode = props.setCode;
  return (
    <CodeEditor
      value={code}
      language="java"
      placeholder="Please enter Java code."
      onChange={(evn) => setCode(evn.target.value)}
      padding={15}
      style={{
        fontSize: 15,
        backgroundColor: '#f5f5f5',
        width: '100%',
        minWidth: 1200,
        minHeight: 300,
        fontFamily:
          'ui-monospace,SFMono-Regular,SF Mono,Consolas,Liberation Mono,Menlo,monospace',
      }}
    />
  );
}
