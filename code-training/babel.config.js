/**
 * babel.config.js
 * @author HU JIAJUN <e0556371@u.nus.edu>
 * @file Babel configuration stript
 */

module.exports = {
  presets: [
    '@babel/preset-env',
    ['@babel/preset-react', {
      'runtime': 'automatic'
    }],
    '@babel/preset-typescript',
  ],
};
