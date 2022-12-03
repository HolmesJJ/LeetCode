/**
 * App.test.tsx
 * @author HU JIAJUN <e0556371@u.nus.edu>
 * @file Tests for App
 */

import { render } from '@testing-library/react';

import { App } from '../App';

test('snapshot', () => {
  const view = render(<App />);
  expect(view).toMatchSnapshot();
});
