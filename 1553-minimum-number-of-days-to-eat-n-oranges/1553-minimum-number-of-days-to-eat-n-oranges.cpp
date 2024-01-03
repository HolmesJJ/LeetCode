class Solution {
public:
    int minDays(int n) {
        unordered_map<int, int> days_needed; // 用于存储到达每个状态所需的最少天数
        queue<int> q;
        q.push(n);
        days_needed[n] = 0; // 从n橙子开始，所需天数为0

        while (!q.empty()) {
            int current = q.front();
            q.pop();
            if (current == 0) {
                return days_needed[current];
            }

            // 尝试吃掉一个橙子的情况
            if (days_needed.find(current - 1) == days_needed.end()) {
                days_needed[current - 1] = days_needed[current] + 1;
                q.push(current - 1);
            }

            // 尝试如果n能被2整除，吃掉一半橙子的情况
            if (current % 2 == 0 && days_needed.find(current / 2) == days_needed.end()) {
                days_needed[current / 2] = days_needed[current] + 1;
                q.push(current / 2);
            }

            // 尝试如果n能被3整除，吃掉两个三分之一橙子的情况
            if (current % 3 == 0 && days_needed.find(current / 3) == days_needed.end()) {
                days_needed[current / 3] = days_needed[current] + 1;
                q.push(current / 3);
            }
        }

        return days_needed[0];
    }
};