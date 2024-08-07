class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        int n = digits.size();
        if (digits[n - 1] < 9) {
            digits[n - 1]++;
            return digits;
        }
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
                if (i == 0) {
                    digits.insert(digits.begin(), 1);
                    return digits;
                }
            } else {
                digits[i]++;
                return digits;
            }
        }
        return digits;
    }
};