class Solution {
public:
    int openLock(vector<string>& deadends, string target) {
        set<string> deadend(deadends.begin(), deadends.end());
        set<string> visited;
        
        if (deadend.find("0000") != deadend.end()) {
            return -1;
        }

        int res = 0;
        
        int dirs[2] = {-1, 1};

        queue<string> q;
        q.push("0000");
        visited.insert("0000");
        while (!q.empty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                string node = q.front();
                q.pop();
                if (node == target) {
                    return res;
                }
                for (int i = 0; i < 4; i++) {
                    for (auto& dir : dirs) {
                        int nWheel = stoi(node.substr(i, 1)) + dir;
                        if (nWheel == -1) {
                            nWheel = 9;
                        }
                        if (nWheel == 10) {
                            nWheel = 0;
                        }
                        string nNode = node.substr(0, i) + to_string(nWheel) + node.substr(i + 1, node.size() - i - 1);
                        if (deadend.find(nNode) == deadend.end() && visited.find(nNode) == visited.end()) {
                            q.push(nNode);
                            visited.insert(nNode);
                        }
                    }
                }
            }
            res++;
        }
        
        return -1;
    }
};