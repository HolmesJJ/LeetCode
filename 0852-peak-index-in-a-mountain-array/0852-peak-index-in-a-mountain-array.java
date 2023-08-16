class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        if (arr.length < 3) {
            return 0;
        }
        int start = 0;
        int end = arr.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid - 1] < arr[mid] && arr[mid + 1] < arr[mid]) {
                return mid;
            } else if (arr[mid - 1] < arr[mid]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return 0;
    }
}