class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        map<string, vector<string>> graph;
        wordList.push_back(beginWord);
        for (int i = 0; i < wordList.size(); i++) {
            for (int j = i + 1; j < wordList.size(); j++) {
                string w1 = wordList[i];
                string w2 = wordList[j];
                if (w1 != w2) {
                    int diff = 0;
                    for (int i = 0; i < w1.size(); i++) {
                        if (w1[i] != w2[i]) {
                            diff++;
                        }
                    }
                    if (diff == 1) {
                        graph[w1].push_back(w2);
                        graph[w2].push_back(w1);
                    }
                }
            }
        }
        
        if (graph.find(endWord) == graph.end()) {
            return 0;
        }
        
        int res = 1;
        
        set<string> visited;
        queue<string> q;
        visited.insert(beginWord);
        q.push(beginWord);
        while (!q.empty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                string node = q.front();
                q.pop();
                if (node == endWord) {
                    return res;
                }
                vector<string> nNodes = graph[node];
                for (auto& nNode : nNodes) {
                    if (visited.find(nNode) == visited.end()) {
                        visited.insert(nNode);
                        q.push(nNode);
                    }
                }
            }
            res++;
        }
        
        return 0;
    }
};