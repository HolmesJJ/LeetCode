class Solution {
public:
    int numOfSubarrays(vector<int>& arr, int k, int threshold) {
        int n = arr.size();
        int left = 0;
        int right = 0;
        int sum = 0;
        int count = 0;
        while (right < n) {
            sum += arr[right];
            right++;
            while (right - left >= k && sum >= threshold * k) {
                if (right - left == k) {
                    count++;
                }
                sum -= arr[left];
                left++;
            }
        }
        return count;
    }
};