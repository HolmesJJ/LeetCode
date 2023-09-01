class TrieNode {
    public Map<Character, TrieNode> children;
    public boolean isWord;
    public String word;
    public TrieNode() {
        children = new HashMap<>();
        isWord = false;
        word = null;
    }
}

class Solution {
    
    Set<String> set = new HashSet<>();
    List<String> results = new ArrayList<>();
    private TrieNode root = new TrieNode();

    public void insert(String word) {
        int l = word.length();
        TrieNode node = root;
        for (int i = 0; i < l; i++) {
            char letter = word.charAt(i);
            if (!node.children.containsKey(letter)) {
                node.children.put(letter, new TrieNode());
            }
            node = node.children.get(letter);
        }
        node.isWord = true;
        node.word = word;
    }

    public List<String> findWords(char[][] board, String[] words) {
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean[][] visited = new boolean[m][n];
                String result = "";
                dfs(set, results, result, board, visited, i, j, root);
            }
        }
        return results;
    }

    public void dfs(Set<String> set, List<String> results, String result, char[][] grid, boolean[][] visited, int i, int j, TrieNode node) {
        if (node.isWord && !set.contains(result)) {
            set.add(result);
            results.add(result);
        }
        if (i < 0 || i == grid.length || j < 0 || j == grid[0].length || visited[i][j] || !node.children.containsKey(grid[i][j])) {
            return;
        }
        visited[i][j] = true;
        TrieNode nextNode = node.children.get(grid[i][j]);
        result = result + grid[i][j];
        dfs(set, results, result, grid, visited, i + 1, j, nextNode);
        dfs(set, results, result, grid, visited, i, j + 1, nextNode);
        dfs(set, results, result, grid, visited, i - 1, j, nextNode);
        dfs(set, results, result, grid, visited, i, j - 1, nextNode);
        result = result.substring(0, result.length() - 1);
        visited[i][j] = false;
    }
}