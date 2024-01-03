class Solution {
public:
    vector<string> findItinerary(vector<vector<string>>& tickets) {
        map<string, vector<string>> graph;
        for (auto& ticket : tickets) {
            graph[ticket[0]].push_back(ticket[1]);
        }
        
        // Sort destinations for each source
        for (auto& it : graph) {
            sort(it.second.begin(), it.second.end(), greater<string>());
        }

        vector<string> res;
        stack<string> s;
        
        s.push("JFK");
        while (!s.empty()) {
            string src = s.top();
            if (graph[src].empty()) {
                res.push_back(src);
                s.pop();
            } else {
                s.push(graph[src].back());
                graph[src].pop_back();
            }
        }
        
        reverse(res.begin(), res.end());

        if (res.size() != tickets.size() + 1) {
            return {};
        }
        
        return res; // In case no valid itinerary is found
    }
};