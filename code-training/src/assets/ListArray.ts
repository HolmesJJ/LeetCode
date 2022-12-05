/**
 * ListArray.ts
 * @author HU JIAJUN <e0556371@u.nus.edu>
 * @file ListArray algorithm
 */

export const partialCode = `// List<Integer> to int[]
int[] array = ;
// OR
int[] array = ;

// 反转
// List

// Array`;

export const fullCode = `// List<Integer> to int[]
int[] array = list.stream().mapToInt(i -> i).toArray();
// OR
int[] array = list.stream().mapToInt(Integer::intValue).toArray();

// 反转
// List
Collections.reverse(list);
// Array
Collections.reverse(Arrays.asList(arr))`;
