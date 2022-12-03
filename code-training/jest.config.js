/**
 * jest.config.js
 * @author HU JIAJUN <e0556371@u.nus.edu>
 * @file Jest configuration stript
 */

/* eslint-disable @typescript-eslint/no-var-requires */
const {
  defaults: tsjPreset
} = require('ts-jest/presets');

module.exports = {
  modulePaths: ["src"],
  ...tsjPreset,
  globals: {
    'ts-jest': {
      babelConfig: true,
    },
  },
  moduleFileExtensions: ['ts', 'tsx', 'js', 'jsx', 'json', 'node'],
  setupFiles: ['<rootDir>/tools/jestSetup.js'],
  setupFilesAfterEnv: ['@testing-library/jest-dom/extend-expect'],
  transform: {
    ...tsjPreset.transform,
  },
};
