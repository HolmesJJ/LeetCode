/**
 * jestSetup.js
 * @author HU JIAJUN <e0556371@u.nus.edu>
 * @file Jest startup stript to mock various dependent variables and libraries used.
 */

process.env.REACT_APP_ENDPOINT_SERVER_URL = 'mock endpoint';
process.env.REACT_APP_ENDPOINT_POLL_INTERVAL_MS = 1000;
process.env.REACT_APP_RETRY_BACKOFF_INTERVAL_MS = 100;
process.env.REACT_APP_RETRY_BACKOFF_MAX_RETRIES = 5;
