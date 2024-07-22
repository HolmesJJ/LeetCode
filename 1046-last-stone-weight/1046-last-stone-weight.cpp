class Solution {
public:
    int lastStoneWeight(vector<int>& stones) {
        if (stones.size() == 1) {
            return stones[0];
        }
        priority_queue<int, vector<int>, less<int>> pq;
        for (auto stone : stones) {
            pq.push(stone);
        }
        while (pq.size() > 1) {
            int s1 = pq.top();
            pq.pop();
            int s2 = pq.top();
            pq.pop();
            if (s1 > s2) {
                pq.push(s1 - s2);
            }
        }
        return pq.size() > 0 ? pq.top() : 0;
    }
};