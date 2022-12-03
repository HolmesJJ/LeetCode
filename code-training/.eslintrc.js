/**
 * .eslintrc.js
 * @author HU JIAJUN <e0556371@u.nus.edu>
 * @file ESLint configuration stript
 */

module.exports = {
  root: true,
  extends: [
    'react-app',
    'react-app/jest',
    'eslint:recommended',
    'plugin:@typescript-eslint/recommended',
    'prettier',
  ],
  parser: '@typescript-eslint/parser',
  plugins: [
    '@typescript-eslint',
    'prettier',
  ],
  overrides: [{
    files: ['*.ts', '*.tsx'],
    rules: {
      '@typescript-eslint/no-explicit-any': 'off',
    },
  }],
};
