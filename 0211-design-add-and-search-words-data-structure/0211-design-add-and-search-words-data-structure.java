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

class WordDictionary {

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
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
        return search(word, root);
    }

    public boolean search(String word, TrieNode node) {
        int l = word.length();
        for (int i = 0; i < l; i++) {
            char letter = word.charAt(i);
            if (letter == '.') {
                for (Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
                    if (search(word.substring(i + 1), entry.getValue())) {
                        return true;
                    }
                }
            }
            if (!node.children.containsKey(letter)) {
                return false;
            }
            node = node.children.get(letter);
        }
        return node.isWord;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */