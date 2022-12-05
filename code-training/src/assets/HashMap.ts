/**
 * HashMap.ts
 * @author HU JIAJUN <e0556371@u.nus.edu>
 * @file HashMap algorithm
 */

export const partialCode = `// 遍历

// 记录元素出现的次数`;

export const fullCode = `// 遍历
for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
  int key = entry.getKey();
  int value = entry.getValue();
}

// 记录元素出现的次数
for (int i = 0; i < nums.length; i++) {
  map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
}`;
