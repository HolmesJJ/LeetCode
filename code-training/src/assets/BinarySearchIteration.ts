/**
 * BinarySearchIteration.ts
 * @author HU JIAJUN <e0556371@u.nus.edu>
 * @file BinarySearchIteration algorithm
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
public int binarySearch(int[] nums, int target) {
  int low = 0;
  int high = nums.length - 1;
  while (low <= high) {
    int mid = low + (high - low) / 2;
    if (nums[mid] < target) {
      low = mid + 1;
    }
    else {
      high = mid - 1;
    }
  }
  return low;
}

// 找不到target
int pos = binarySearch(nums, target);
if (pos == nums.length || nums[pos] > target) {
  return -1;
}

// 时间复杂度
O(logn)

// 空间复杂度
O(1)`;
