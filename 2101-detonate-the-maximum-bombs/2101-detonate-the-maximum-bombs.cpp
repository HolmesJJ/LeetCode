class Solution {
public:
    int maximumDetonation(vector<vector<int>>& bombs) {
        int m = bombs.size();
        bool visited[m];
        
        int count = 0;
        int res = 0;
        queue<vector<int>> q;
        for (int i = 0; i < m; i++) {
            count = 0;
            for (int j = 0; j < m; j++) {
                visited[j] = false;
            }
            q.push(bombs[i]);
            visited[i] = true;
            count++;
            while (!q.empty()) {
                vector<int> node = q.front();
                q.pop();
                double x = node[0];
                double y = node[1];
                double r = node[2];
                for (int k = 0; k < m; k++) {
                    if (k != i && !visited[k]) {
                        vector<int> nNode = bombs[k];
                        double nX = nNode[0];
                        double nY = nNode[1];
                        double nR = nNode[2];
                        double x2 = (x - nX) * (x - nX);
                        double y2 = (y - nY) * (y - nY);
                        double dist = sqrt(x2 + y2);
                        if (r >= dist) {
                            q.push(bombs[k]);
                            visited[k] = true;
                            count++;
                        }
                    }
                }
            }
            res = max(res, count);
        }

        return res;
    }
};