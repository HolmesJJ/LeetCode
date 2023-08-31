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

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
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
    
    public boolean search(String word) {
        int l = word.length();
        TrieNode node = root;
        for (int i = 0; i < l; i++) {
            char letter = word.charAt(i);
            if (!node.children.containsKey(letter)) {
                return false;
            }
            node = node.children.get(letter);
        }
        return node.isWord;
    }
    
    public boolean startsWith(String prefix) {
        int l = prefix.length();
        TrieNode node = root;
        for (int i = 0; i < l; i++) {
            char letter = prefix.charAt(i);
            if (!node.children.containsKey(letter)) {
                return false;
            }
            node = node.children.get(letter);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */