class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int count = 0;
        if (arr.length < k) {
            return count;
        }
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum = sum + arr[i];
        }
        if (sum * 1.0 / k >= threshold) {
            count++;
        }
        for (int i = k; i < arr.length; i++) {
            sum = sum - arr[i - k];
            sum = sum + arr[i];
            if (sum * 1.0 / k >= threshold) {
                count++;
            }
        }
        return count;
    }
}