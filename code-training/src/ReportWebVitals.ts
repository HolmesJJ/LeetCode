/**
 * ReportWebVitals.tsx
 * @author HU JIAJUN <e0556371@u.nus.edu>
 * @file Measures performance of React Application
 */

import { ReportHandler } from 'web-vitals';

export function ReportWebVitals(onPerfEntry?: ReportHandler) {
  if (onPerfEntry && onPerfEntry instanceof Function) {
    import('web-vitals').then(({ getCLS, getFID, getFCP, getLCP, getTTFB }) => {
      getCLS(onPerfEntry);
      getFID(onPerfEntry);
      getFCP(onPerfEntry);
      getLCP(onPerfEntry);
      getTTFB(onPerfEntry);
    });
  }
}
