class Solution {
public:
    int findCheapestPrice(int n, vector<vector<int>>& flights, int src, int dst, int k) {
        vector<vector<pair<int, int>>> graph(n);
        for (auto& flight : flights) {
            graph[flight[0]].push_back({flight[1], flight[2]});
        }
        
        vector<int> prices(n, INT_MAX);
        prices[src] = 0;

        // Bellman-Ford algorithm
        for (int i = 0; i <= k; i++) {
            vector<int> tmpPrices(prices);
            for (int u = 0; u < n; u++) {
                for (auto& v : graph[u]) {
                    int next = v.first;
                    int price = v.second;
                    if (prices[u] != INT_MAX && prices[u] + price < tmpPrices[next]) {
                        tmpPrices[next] = prices[u] + price;
                    }
                }
            }
            prices.swap(tmpPrices);
        }

        return prices[dst] == INT_MAX ? -1 : prices[dst];
    }
};