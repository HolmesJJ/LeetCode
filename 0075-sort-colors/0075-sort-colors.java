class Solution {
    public void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int partition(int nums[], int low, int high) {
        int pivot = nums[high];
        int left = low;
        int right = high - 1;
        while (true) {
            while (left <= right && nums[left] < pivot) {
                left++;
            }
            while (right >= left && nums[right] > pivot) {
                right--;
            }
            if (left >= right) {
                break;
            }
            swap(nums, left, right);
            left++;
            right--;
        }
        swap(nums, left, high);
        return left;
    }

    public void sort(int nums[], int low, int high) {
        if (low < high) {
            int pi = partition(nums, low, high);
            sort(nums, low, pi - 1);
            sort(nums, pi + 1, high);
        }
    }

    public void sortColors(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }
}