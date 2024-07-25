class Solution {
public:
    bool isHappy(int n) {
        unordered_set<int> hashSet;
        while (n > 1) {
            int temp = 0;
            while (n > 0) {
                int digit = n % 10;
                temp += digit * digit;
                n /= 10;
            }
            if (hashSet.find(temp) != hashSet.end()) {
                return false;
            }
            hashSet.insert(temp);
            n = temp;
        }
        return true;
    }
};