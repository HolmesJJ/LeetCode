/**
 * BinarySearchRecursion.ts
 * @author HU JIAJUN <e0556371@u.nus.edu>
 * @file BinarySearchRecursion algorithm
 */

export const partialCode = `// Corner Case 处理


// 若找不到target, 则返回比target[ ]的值的位置
// 若target值重复, 则始终返回第[ ]个target的位置; 若要返回最后一个target的位置, 则需要修改为[ ]
public binarySearch() {
  
}

// 找不到target


// 时间复杂度
O( )

// 空间复杂度
O( )`;

export const fullCode = `// Corner Case 处理
if (nums == null || nums.length == 0) {
  return -1;
}

// 若找不到target, 则返回比target大一点的值的位置
// 若target值重复, 则始终返回第一个target的位置; 若要返回最后一个target的位置, 则需要修改为nums[mid] <= target
public int binarySearch(int[] nums, int target, int low, int high) {
  if (low > high) {
    return low;
  }
  int mid = low + (high - low) / 2;
  if (nums[mid] < target) {
    return binarySearch(nums, target, mid + 1, high);
  }
  else {
    return binarySearch(nums, target, low, mid - 1);
  }
}

// 找不到target
int pos = binarySearch(nums, target, 0, nums.length - 1);
if (pos == nums.length || nums[pos] > target) {
  return -1;
}

// 时间复杂度
O(logn)

// 空间复杂度
O(1)`;
